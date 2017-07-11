package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Emp;

/**
 * 员工操作业务
 * @author Administrator
 *
 */
public interface EmpService {
	//查询所有员工
	List<Emp> queryAll(String did);
	//查询一个员工
	Emp queryOne(String id);
	//删除员工
	void dropEmp(String id);
	//修改员工
	void changeEmp(Emp e);
	//添加员工
	void addEmp(Emp e);
}
