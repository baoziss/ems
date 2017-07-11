package com.baizhi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.dao.DeptDAO;
import com.baizhi.entity.Dept;
import com.baizhi.util.JdbcUtil;
/**
 * 部门表DAO实现
 * @author Administrator
 *
 */
public class DeptDAOImpl implements DeptDAO {
	

	/**
	 * 查询所有部门实现
	 */
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		List<Dept> list = new ArrayList<Dept>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql，预执行pstm
			String sql = "select id,name from t_dept";
			pstm = con.prepareStatement(sql);
			//执行pstm
			rs = pstm.executeQuery();
			//处理查询结果
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				Dept d = new Dept();
				d.setId(id);
				d.setName(name);
				list.add(d);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, pstm, con);
		}
		return list;
	}

	/**
	 * 插入部门实现
	 */
	public void insertDept(Dept dept) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//建立连接
			con = JdbcUtil.getCon();
			//执行sql
			String sql = "insert into t_dept values(?,?)";
			pstm = con.prepareStatement(sql);
			//为？赋值
			pstm.setString(1, dept.getId());
			pstm.setString(2, dept.getName());
			//执行sql
			pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.release(null, pstm, null);
		}
			
	}

	/**
	 * 修改部门表实现
	 */
	public void updateDpet(Dept dept) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//建立连接
			con = JdbcUtil.getCon();
			//执行sql
			String sql = "update t_dept set name=? where id=?";
			pstm = con.prepareStatement(sql);
			//为？赋值
			pstm.setString(1, dept.getName());
			pstm.setString(2, dept.getId());
			//执行sql
			pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.release(null, pstm, null);
		}
	}

	/**
	 * 删除部门
	 */
	public void deleteDept(String id) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//建立连接
			con = JdbcUtil.getCon();
			//执行sql
			String sql = "delete from t_dept where id=?";
			pstm = con.prepareStatement(sql);
			//为？赋值
			pstm.setString(1, id);
			//执行sql
			pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.release(null, pstm, null);
		}
	}

	/**
	 * 部门表查询一个具体实现
	 */
	public Dept selectOne(String id) {
		Dept d = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql，预执行pstm
			String sql = "select id,name from t_dept where id=?";
			pstm = con.prepareStatement(sql);
			//执行pstm
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			//处理查询结果
			if(rs.next()){
				String name = rs.getString("name");
				d = new Dept();
				d.setId(id);
				d.setName(name);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, pstm, con);
		}
		return d;
	}

}
