package com.baizhi.service.impl;

import java.sql.Connection;
import java.util.UUID;

import com.baizhi.dao.UserDAO;
import com.baizhi.dao.impl.UserDAOImpl;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.tx.TransforManager;
import com.baizhi.util.JdbcUtil;

/**
 * 用户业务方法实现
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {
	
	private UserDAO ud = new UserDAOImpl();
	/**
	 * 用户登录方法
	 */
	public User queryOne(String username) {
		return ud.selectOne(username);
	}

	/**
	 * 用户注册
	 */
	public void regist(User u) {
		try {
			TransforManager.begin();
			//调用DAO方法
			u.setId(UUID.randomUUID().toString());
			ud.insertUser(u);
			//提交事务
			TransforManager.commit();
		} catch (Exception e) {
			TransforManager.rollback();
			throw new RuntimeException(e);
		}
	}

}
