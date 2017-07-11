package com.baizhi.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import com.baizhi.util.JdbcUtil;
/**
 * 员工表操作实现类
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	/**
	 * 查询所有员工
	 */
	public List<Emp> selectAll() {
		List<Emp> emps = new ArrayList<Emp>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql 预执行
			String sql = "select id,name,salary,age,birthday from ttt_emp";
			pstm = con.prepareStatement(sql);
			//执行sql
			rs = pstm.executeQuery();
			//处理查询结果
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				Double salary = rs.getDouble("salary");
				Integer age = rs.getInt("age");
				java.util.Date birthday = rs.getDate("birthday");
				Emp e = new Emp(id,name,salary,age,birthday);
				emps.add(e);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			//释放资源
			JdbcUtil.release(rs, pstm, con);
		}
		return emps;
	}

	/**
	 * 根据id获取员工信息实现
	 */
	public Emp selectOne(String id) {
		Emp e = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql 预执行
			String sql = "select id,name,salary,age,birthday from ttt_emp where id=?";
			pstm = con.prepareStatement(sql);
			//执行sql
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			//处理查询结果
			e = new Emp();
			if(rs.next()){
				e.setId(id);
				e.setName(rs.getString("name"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setBirthday(rs.getDate("birthday"));
			}
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}finally{
			//释放资源
			JdbcUtil.release(rs, pstm, con);
		}
		return e;
	}

	/**
	 * 添加一个员工
	 */
	public void insertEmp(Emp e) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获取con
			con = JdbcUtil.getCon();
			//确定sql 预执行
			String sql = "insert into ttt_emp values(?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			//为？赋值，执行sql
			pstm.setString(1, e.getId());
			pstm.setString(2, e.getName());
			pstm.setDouble(3, e.getSalary());
			pstm.setInt(4, e.getAge());
			java.sql.Date sqlDate = new java.sql.Date(e.getBirthday().getTime());
			pstm.setDate(5, sqlDate);
			pstm.executeUpdate();
		} catch (Exception e2) {
			throw new RuntimeException(e2);
		}finally{
			//释放资源
			JdbcUtil.release(null, pstm, null);
		}
	}
	/**
	 * 员工分页操作
	 * 根据页数和每页行数确定返回值
	 */
	public List<Emp> selectByPage(int pageNum,int rownum) {
		List<Emp> emps = new ArrayList<Emp>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql 预执行
			String sql = "select id,name,salary,age,birthday,rn from (select e1.*,rownum rn from ttt_emp e1) where rn>? and rn<=?";
			pstm = con.prepareStatement(sql);
			//执行sql
			int begin = pageNum*rownum-rownum;
			int end = pageNum*rownum;
			pstm.setInt(1, begin);
			pstm.setInt(2, end);
			rs = pstm.executeQuery();
			//处理查询结果
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				Double salary = rs.getDouble("salary");
				Integer age = rs.getInt("age");
				java.util.Date birthday = rs.getDate("birthday");
				Emp e = new Emp(id,name,salary,age,birthday);
				emps.add(e);
			}
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}finally{
			//释放资源
			JdbcUtil.release(rs, pstm, con);
		}
		return emps;
	}

	/**
	 * 删除员工
	 */
	public void deleteEmp(String id) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获取con
			con = JdbcUtil.getCon();
			//确定sql 预执行
			String sql = "delete from ttt_emp where id=?";
			pstm = con.prepareStatement(sql);
			//为？赋值，执行sql
			pstm.setString(1, id);
			pstm.executeUpdate();
		} catch (Exception e2) {
			throw new RuntimeException(e2);
		}finally{
			//释放资源
			JdbcUtil.release(null, pstm, null);
		}
	}

	@Override
	public void update(Emp e) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获取con
			con = JdbcUtil.getCon();
			//确定sql 预执行
			String sql = "update ttt_emp set name=?,salary=?,age=?,birthday=? where id=?";
			pstm = con.prepareStatement(sql);
			//为？赋值，执行sql
			pstm.setString(5, e.getId());
			pstm.setString(1, e.getName());
			pstm.setDouble(2, e.getSalary());
			pstm.setInt(3, e.getAge());
			java.sql.Date sqlDate = new java.sql.Date(e.getBirthday().getTime());
			pstm.setDate(4, sqlDate);
			pstm.executeUpdate();
		} catch (Exception e2) {
			throw new RuntimeException(e2);
		}finally{
			//释放资源
			JdbcUtil.release(null, pstm, null);
		}
	}
}
