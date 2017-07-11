package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Emp;

/**
 * 员工业务操作
 * @author Administrator
 *
 */
public interface EmpService {
	//添加员工操作
	void addEmp(Emp emp);
	//删除员工操作
	void dropEmp(String id);
	//修改员工操作
	void changeEmp(Emp emp);
	//查询所有员工
	List<Emp> queryAll();
	//查询一个员工
	Emp queryOne(String id);
}
