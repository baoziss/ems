package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工实体类
 * @author Administrator
 *
 */
public class Emp implements Serializable{
	private String id;
	private String name;
	private Double salary;
	private Integer age;
	private Date birthday;
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
	public Emp() {
		super();
	}
	public Emp(String id, String name, Double salary, Integer age, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.birthday = birthday;
	}

	public String toString() {
		return "id：" + id + ", name：" + name + ", salary：" + salary
				+ ", age：" + age + ", birthday：" + birthday;
	}
	
}
