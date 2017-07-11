package com.baizhi.entity;
/**
 * 用户表实体类
 * @author Administrator
 *
 */
public class User {
	private String id;
	private String username;
	private String realName;
	private String password;
	private String sex;
	private String salt;
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
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public User(String id, String username, String realName, String password,
			String sex, String salt) {
		super();
		this.id = id;
		this.username = username;
		this.realName = realName;
		this.password = password;
		this.sex = sex;
		this.salt = salt;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realName="
				+ realName + ", password=" + password + ", sex=" + sex
				+ ", salt=" + salt + "]";
	}
	
}
