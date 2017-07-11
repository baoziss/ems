package com.baizhi.entity;

import java.util.List;

/**
 * 部门表实体类
 * @author Administrator
 *
 */
public class Dept {
	private String id;//部门id
	private String name;//部门名称
	private List<Emp> emps;//关系映射
	//get set 方法
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	//有参无参构造方法
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(String id, String name, List<Emp> emps) {
		super();
		this.id = id;
		this.name = name;
		this.emps = emps;
	}
	//toString方法
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", emp=" + emps + "]";
	}
	
}
