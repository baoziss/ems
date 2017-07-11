package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Dept;

/**
 * 部门DAO
 * @author Administrator
 *
 */
public interface DeptDAO {
	// 查询部门表中所有部门信息
	List<Dept> selectAll();
	//	 添加部门
	void insertDept(Dept dept);
	// 修改部门信息
	void updateDpet(Dept dept);
	// 删除部门表部门
	void deleteDept(String id);
	// 查询部门表中一个部门信息
	Dept selectOne(String id);
}
