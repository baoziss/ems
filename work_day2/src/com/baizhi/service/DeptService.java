package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Dept;

/**
 * 部门表业务类
 * @author Administrator
 *
 */
public interface DeptService {
	//显示所有部门信息
	List<Dept> queryAll();
	//显示一个部门信息
	Dept queryOne(String id);
	//添加部门
	void addDept(String name);
	//删除部门
	void dropDept(String id);
	//修改部门
	void changeDept(Dept dept);
}
