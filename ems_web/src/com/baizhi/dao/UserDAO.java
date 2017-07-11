package com.baizhi.dao;

import com.baizhi.entity.User;

/**
 * 用户DAO
 * @author Administrator
 *
 */
public interface UserDAO {
	// 查询用户
	User selectOne(String username);
	// 插入用户
	void insertUser(User u);
}
