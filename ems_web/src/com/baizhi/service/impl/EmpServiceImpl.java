package com.baizhi.service.impl;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.EmpDao;
import com.baizhi.dao.impl.EmpDaoImpl;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.baizhi.tx.TransforManager;
/**
 * 员工业务实现类
 * @author Administrator
 *
 */
public class EmpServiceImpl implements EmpService {
	private EmpDao ed = new EmpDaoImpl();
	/**
	 * 获得所有员工
	 */
	public List<Emp> queryEmps() {
		return ed.selectAll();
	}

	/**
	 * 根据id获得某个员工信息
	 */
	public Emp queryEmp(String id) {
		return ed.selectOne(id);
	}

	/**
	 * 添加员工信息
	 */
	public void addEmp(Emp e) {
		try {
			TransforManager.begin();
			e.setId(UUID.randomUUID().toString());
			ed.insertEmp(e);
			TransforManager.commit();
		} catch (Exception e2) {
			TransforManager.rollback();
			throw new RuntimeException(e2);
		}
		
	}

	/**
	 * 根据页数和每页显示行数返回查询结果
	 */
	public List<Emp> queryEmpNyPage(int pageNum, int rownum) {
		return ed.selectByPage(pageNum, rownum);
	}

	/**
	 * 删除员工信息
	 */
	public void dropEmp(String id) {
		try {
			TransforManager.begin();
			ed.deleteEmp(id);
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
			ed.update(e);
			TransforManager.commit();
		} catch (Exception e2) {
			TransforManager.rollback();
			throw new RuntimeException(e2);
		}
		
	}

}
