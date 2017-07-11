package com.baizhi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.JdbcUtil;
/**
 * 用户DAO实现类
 * @author Administrator
 *
 */
public class UserDAOImpl implements UserDAO {

	/**
	 * 查询一个用户方法实现
	 * @return
	 */
	public User selectOne(String username) {
		User u = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql 预执行sql
			String sql = "select id,username,realname,password,sex,salt from t_user where username=?";
			pstm = con.prepareStatement(sql);
			//为？赋值 执行sql
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			//处理查询结果
			if(rs.next()){
				String id = rs.getString("id");
				String realname = rs.getString("realname");
				String pwd = rs.getString("password");
				int s = rs.getInt("sex");
				String salt = rs.getString("salt");
				u = new User(id,username,realname,pwd,s,salt);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.release(rs, pstm, con);
		}
		return u;
	}

	/**
	 * 添加用户方法实现
	 * @param u
	 */
	public void insertUser(User u) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql 预执行sql
			String sql = "insert into t_user values(?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			//为？赋值执行sql
			pstm.setString(1, u.getId());
			pstm.setString(2, u.getUsername());
			pstm.setString(3, u.getRealname());
			pstm.setString(4, u.getPassword());
			pstm.setInt(5, u.getSex());
			pstm.setString(6, u.getSalt());
			pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.release(null, pstm, null);
		}
	}

}
