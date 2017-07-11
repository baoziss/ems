package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * 用户业务
 * @author Administrator
 *
 */
public interface UserService {
	//获取用户信息
	User queryOne(User user);
	//注册用户信息
	void regist(User user);
}
