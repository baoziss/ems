package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * 用户业务方法
 * @author Administrator
 *
 */
public interface UserService {
	//用户登录
	User queryOne(User user);
	//用户注册
	void regist(User u);
}
