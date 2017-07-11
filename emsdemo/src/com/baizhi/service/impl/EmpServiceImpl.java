package com.baizhi.service.impl;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.baizhi.util.MybatisUtil;
/**
 * 员工业务操作实现类
 * @author Administrator
 *
 */
public class EmpServiceImpl implements EmpService {

	/**
	 * 添加员工操作
	 */
	public void addEmp(Emp emp) {
		EmpDao dao = MybatisUtil.getDao(EmpDao.class);
		try{
			emp.setId(UUID.randomUUID().toString());
			dao.insertEmp(emp);
			MybatisUtil.commit();
		} catch (Exception e) {
			//事务回滚
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加失败！");
		}	
	}

	/**
	 * 删除员工操作
	 */
	public void dropEmp(String id) {
		EmpDao dao = MybatisUtil.getDao(EmpDao.class);
		try {
			dao.deleteEmp(id);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("删除失败！");
		}
	}

	/**
	 * 修改员工操作
	 */
	public void changeEmp(Emp emp) {
		EmpDao dao = MybatisUtil.getDao(EmpDao.class);
		try {
			dao.updateEmp(emp);
			MybatisUtil.commit();
		} catch (Exception e) {
			//事务回滚
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("修改失败！");
		}
	}

	/**
	 * 查询所有员工操作
	 */
	public List<Emp> queryAll() {
		EmpDao dao = MybatisUtil.getDao(EmpDao.class);
		List<Emp> list = dao.selectBy(new Emp());
		MybatisUtil.release();
		return list;
	}

	/**
	 * 查询一个员工操作
	 */
	public Emp queryOne(String id) {
		EmpDao dao = MybatisUtil.getDao(EmpDao.class);
		Emp emp = new Emp();
		emp.setId(id);
		List<Emp> list = dao.selectBy(emp);
		MybatisUtil.release();
		return list.get(0);
	}

}
