package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Emp;

/**
 * 员工业务操作
 * @author Administrator
 *
 */
public interface EmpService {
	//获取所有员工信息
	List<Emp> queryEmps();
	//根据id获取员工信息
	Emp queryEmp(String id);
	//添加员工信息
	void addEmp(Emp e);
	//员工分页查询
	List<Emp> queryEmpNyPage(int pageNum,int rownum);
	//删除员工信息
	void dropEmp(String id);
	//修改员工信息
	void changeEmp(Emp e);
}
