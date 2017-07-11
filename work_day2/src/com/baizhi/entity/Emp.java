package com.baizhi.entity;

import java.util.Date;

/**
 * 员工表实体类
 * @author Administrator
 *
 */
public class Emp {
	private String id;//员工id
	private String name;//员工姓名
	private Double salary;//员工工资
	private Integer age;//员工年龄
	private Date birthday;//员工生日
	private Dept dept;//关系映射
	//get set方法
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	//有参无参构造方法
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(String id, String name, Double salary, Integer age,
			Date birthday, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.birthday = birthday;
		this.dept = dept;
	}
	//toString方法
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", age=" + age + ", birthday=" + birthday + ", dept=" + dept
				+ "]";
	}
}
