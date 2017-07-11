package com.baizhi.service.impl;

import java.sql.Connection;
import java.util.UUID;

import com.baizhi.dao.UserDAO;
import com.baizhi.dao.impl.UserDAOImpl;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.tx.TransforManager;
import com.baizhi.util.JdbcUtil;
import com.baizhi.util.MD5Util;

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
	public User queryOne(User u) {
		User user = ud.selectOne(u.getUsername());
		if(user != null){
			if(user.getPassword().equals(MD5Util.getMd5Code(u.getPassword()+user.getSalt()))){
				return user;
			}
			throw new RuntimeException("密码错误！");
		}else{
			throw new RuntimeException("用户不存在！");
		}
	}

	/**
	 * 用户注册
	 */
	public void regist(User u) {
		try {
			TransforManager.begin();
			//调用DAO方法
			UserDAO ud = new UserDAOImpl();
			u.setId(UUID.randomUUID().toString());
			ud.insertUser(u);
			TransforManager.commit();
		} catch (Exception e) {
			TransforManager.rollback();
			throw new RuntimeException(e);
		}
	}

}
