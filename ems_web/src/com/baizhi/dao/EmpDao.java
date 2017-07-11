package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Emp;

/**
 * 员工表操作
 * @author Administrator
 *
 */
public interface EmpDao {
	//显示所有员工信息
	List<Emp> selectAll();
	//根据ID获得当前员工信息
	Emp selectOne(String id);
	//添加员工
	void insertEmp(Emp e);
	//员工分页操作
	List<Emp> selectByPage(int pageNum,int rownum);
	//删除员工操作
	void deleteEmp(String id);
	//修改员工操作
	void update(Emp e);
}
