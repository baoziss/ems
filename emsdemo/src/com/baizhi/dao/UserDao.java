package com.baizhi.dao;

import com.baizhi.entity.User;

/**
 * 用户Dao
 * @author Administrator
 *
 */
public interface UserDao {
	//查询用户功能
	User selectUser(String username);
	//用户添加功能
	void insertUser(User user);
}
