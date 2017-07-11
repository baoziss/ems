package com.baizhi.entity;
/**
 * 员工实体类
 * @author Administrator
 *
 */
public class Emp {
	private String id;
	private String name;
	private Double salary;
	private Integer age;
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
	public Emp(String id, String name, Double salary, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", age=" + age + "]";
	}
	
}
