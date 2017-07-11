package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Emp;

/**
 * 员工表操作DAO
 * @author Administrator
 *
 */
public interface EmpDao {
	//员工插入操作
	void insertEmp(Emp emp);
	//员工删除
	void deleteEmp(String id);
	//员工表修改
	void updateEmp(Emp emp);
	//获得员工信息
	List<Emp> selectBy(Emp emp);
}
