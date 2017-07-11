package com.baizhi.entity;

/**
 * 用户表实体类
 * @author Administrator
 *
 */
public class User {
	private String id;//用户id
	private String username;//用户名
	private String realname;//真实姓名
	private String password;//用户密码
	private Integer sex;//性别 0 or 1
	private String salt;//盐
	//get set方法
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	//有参无参构造方法
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String username, String realname, String password,
			Integer sex, String salt) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.sex = sex;
		this.salt = salt;
	}
	//重写toString
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realname="
				+ realname + ", password=" + password + ", sex=" + sex
				+ ", salt=" + salt + "]";
	}
	
}
