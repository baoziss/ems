package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Emp;

/**
 * 员工DAO
 * @author Administrator
 *
 */
public interface EmpDAO {
	//查询某部门所有员工表信息
	List<Emp> selectAll(String did);
	//查询一个员工信息
	Emp selectOne(String id);
	//修改员工信息
	void updateEmp(Emp emp);
	//删除员工
	void deleteEmp(String id);
	//添加员工
	void insertEmp(Emp emp);
}
