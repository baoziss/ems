package com.baizhi.test;

import org.junit.Test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;

/**
 * 测试用户业务层
 * @author Administrator
 *
 */
public class TestUserService {
	private UserService us = new UserServiceImpl();
	@Test
	public void testRegist(){
		us.regist(new User("1","wult","吴龙涛","123456","男","1234"));
	}
	@Test
	public void testQueryOne(){
		User user = new User();
		user.setUsername("wult");
		user.setPassword("123456");
		System.out.println(user);
		User one = us.queryOne(user);
		System.out.println(one);
	}
}
