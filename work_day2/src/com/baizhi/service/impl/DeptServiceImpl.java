package com.baizhi.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.baizhi.dao.DeptDAO;
import com.baizhi.dao.EmpDAO;
import com.baizhi.dao.impl.DeptDAOImpl;
import com.baizhi.dao.impl.EmpDAOImpl;
import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.service.DeptService;
import com.baizhi.tx.TransforManager;
import com.baizhi.util.JdbcUtil;

/**
 * 部门业务操作具体实现
 * @author Administrator
 *
 */
public class DeptServiceImpl implements DeptService {
	private DeptDAO ddi = new DeptDAOImpl();
	/**
	 * 查询所有部门信息
	 */
	public List<Dept> queryAll() {
		return ddi.selectAll();
	}

	/**
	 * 查询一个部门信息
	 */
	public Dept queryOne(String id) {
		return ddi.selectOne(id);
	}

	/**
	 * 添加部门
	 */
	public void addDept(String name) {
		try {
			TransforManager.begin();
			//调用DAO
			DeptDAO ddi = new DeptDAOImpl();
			String id = UUID.randomUUID().toString();
			Dept dept = new Dept();
			dept.setId(id);
			dept.setName(name);
			ddi.insertDept(dept);
			//提交事务
			TransforManager.commit();
		} catch (Exception e) {
			TransforManager.rollback();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除部门操作
	 */
	public void dropDept(String id) {
		try {
			TransforManager.begin();
			//调用DAO
			DeptDAO ddi = new DeptDAOImpl();
			//设置当前部门员工部门为空
			EmpDAO ed = new EmpDAOImpl();
			List<Emp> list = ed.selectAll(id);
			for (Emp emp : list) {
				emp.setDept(null);
				ed.updateEmp(emp);
			}
			ddi.deleteDept(id);
			//提交事务
			TransforManager.commit();
		} catch (Exception e) {
			TransforManager.rollback();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改部门信息
	 */
	public void changeDept(Dept dept) {
		try {
			TransforManager.begin();
			//调用DAO
			DeptDAO ddi = new DeptDAOImpl();
			ddi.updateDpet(dept);
			//提交事务
			TransforManager.commit();
		} catch (Exception e) {
			TransforManager.rollback();
			throw new RuntimeException(e);
		}
	}
}
