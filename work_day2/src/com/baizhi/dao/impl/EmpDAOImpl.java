package com.baizhi.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.util.JdbcUtil;

/**
 * 员工表操作实现类
 * @author Administrator
 *
 */
public class EmpDAOImpl implements EmpDAO {

	/**
	 * 员工表查询所有实现
	 */
	public List<Emp> selectAll(String did) {
		List<Emp> list = new ArrayList<Emp>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql，预执行pstm
			String sql = "select e.id eid,e.name ename,salary,age,birthday,d.id did,d.name dname from t_emp e left join t_dept d on e.dept_id=d.id where d.id=?";
			pstm = con.prepareStatement(sql);
			//执行pstm
			pstm.setString(1, did);
			rs = pstm.executeQuery();
			//处理查询结果
			while(rs.next()){
				String name = rs.getString("dname");
				Dept d = new Dept();
				d.setId(did);
				d.setName(name);
				Emp e = new Emp(rs.getString("eid"),rs.getString("ename"),rs.getDouble("salary"),rs.getInt("age"),rs.getDate("birthday"),d);
				list.add(e);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, pstm, con);
		}
		return list;
	}

	/**
	 * 员工表查询一个方法
	 */
	public Emp selectOne(String id) {
		Emp emp = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql，预执行pstm
			String sql = "select e.id eid,e.name ename,salary,age,birthday,d.id did,d.name dname from t_emp e left join t_dept d on e.dept_id=d.id where e.id=?";
			pstm = con.prepareStatement(sql);
			//执行pstm
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			//处理查询结果
			if(rs.next()){
				String name = rs.getString("ename");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				java.util.Date utilDate = rs.getDate("birthday");
				Dept d = new Dept(rs.getString("did"),rs.getString("dname"),new ArrayList<Emp>());
				emp = new Emp(id,name,salary,age,utilDate,d);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, pstm, con);
		}
		return emp;
	}

	/**
	 * 修改员工信息
	 */
	public void updateEmp(Emp emp) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql，预执行pstm
			String sql = "update t_emp set name=?,salary=?,age=?,birthday=?,dept_id=? where id=?";
			pstm = con.prepareStatement(sql);
			//执行pstm
			pstm.setString(1, emp.getName());
			pstm.setDouble(2, emp.getSalary());
			pstm.setInt(3, emp.getAge());
			java.sql.Date sqlDate = new java.sql.Date(emp.getBirthday().getTime());
			pstm.setDate(4, sqlDate);
			Dept d = emp.getDept();
			if(d != null){
				pstm.setString(5, d.getId());
			}else{
				pstm.setString(5, null);
			}
			pstm.setString(6, emp.getId());
			pstm.executeUpdate();
			//处理查询结果
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(null, pstm, null);
		}
	}

	/**
	 * 删除员工操作
	 */
	public void deleteEmp(String id) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql，预执行pstm
			String sql = "delete from t_emp where id=?";
			pstm = con.prepareStatement(sql);
			//执行pstm
			pstm.setString(1, id);
			pstm.executeUpdate();
			//处理查询结果
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(null, pstm, null);
		}
	}

	/**
	 * 员工插入操作
	 */
	public void insertEmp(Emp emp) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//确定sql预执行
			String sql = "insert into t_emp values(?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			//为？赋值，执行sql
			pstm.setString(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setDouble(3, emp.getSalary());
			pstm.setInt(4, emp.getAge());
			java.sql.Date sqlDate = new java.sql.Date(emp.getBirthday().getTime());
			pstm.setDate(5, sqlDate);
			pstm.setString(6, emp.getDept().getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(null, pstm, null);
		}
	}

}
