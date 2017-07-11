package com.baizhi.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.baizhi.dao.EmpDAO;
import com.baizhi.dao.impl.EmpDAOImpl;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.baizhi.tx.TransforManager;
import com.baizhi.util.JdbcUtil;
/**
 * 员工操作业务
 * @author Administrator
 *
 */
public class EmpServiceImpl implements EmpService {
	
	private EmpDAO ed = new EmpDAOImpl();
	/**
	 * 查询某部门所有员工
	 */
	public List<Emp> queryAll(String did) {
		return ed.selectAll(did);
	}

	/**
	 * 查询一个员工
	 */
	public Emp queryOne(String id) {
		return ed.selectOne(id);
	}

	/**
	 * 删除一个员工
	 */
	public void dropEmp(String id) {
		try {
			TransforManager.begin();
			//调用DAO
			EmpDAO ed = new EmpDAOImpl();
			ed.deleteEmp(id);
			//事务提交
			TransforManager.commit();
		} catch (Exception e) {
			TransforManager.rollback();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改员工信息
	 */
	public void changeEmp(Emp e) {
		try {
			TransforManager.begin();
			//调用DAO
			EmpDAO ed = new EmpDAOImpl();
			ed.updateEmp(e);
			//事务提交
			TransforManager.commit();
		} catch (Exception e1) {
			TransforManager.rollback();
			throw new RuntimeException(e1);
		}
	}

	/**
	 * 添加员工
	 */
	public void addEmp(Emp e) {
		try {
			TransforManager.begin();
			//调用DAO
			EmpDAO ed = new EmpDAOImpl();
			e.setId(UUID.randomUUID().toString());
			ed.insertEmp(e);
			//事务提交
			TransforManager.commit();
		} catch (Exception e1) {
			TransforManager.rollback();
			throw new RuntimeException(e1);
		}
	}

}
