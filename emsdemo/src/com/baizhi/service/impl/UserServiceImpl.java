package com.baizhi.service.impl;

import java.util.UUID;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MD5Util;
import com.baizhi.util.MybatisUtil;
import com.baizhi.util.SaltUtil;

/**
 * 用户业务实现类
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{

	/**
	 * 获取用户信息
	 */
	public User queryOne(User user) {
		UserDao dao = MybatisUtil.getDao(UserDao.class);
		if(user.getUsername() != null){
			User u = dao.selectUser(user.getUsername());
			MybatisUtil.release();
			if(u == null){
				throw new RuntimeException("用户不存在！");
			}else if(u.getPassword().equals(MD5Util.getMd5Code(user.getPassword()+u.getSalt()))){
				return u;
			}else{
				throw new RuntimeException("密码错误！");
			}
		}else{
			throw new RuntimeException("请输入用户名！");
		}
	}

	/**
	 * 注册用户
	 */
	public void regist(User user) {
		UserDao dao = MybatisUtil.getDao(UserDao.class);
		User u = dao.selectUser(user.getUsername());
		if(u != null){
			throw new RuntimeException("用户已存在！");
		}else{
			try {
				String salt = SaltUtil.getSalt(4);
				user.setId(UUID.randomUUID().toString());
				user.setPassword(MD5Util.getMd5Code(user.getPassword()+salt));
				user.setSalt(salt);
				dao.insertUser(user);
				//事务提交
				MybatisUtil.commit();
			} catch (Exception e) {
				//事务回滚
				MybatisUtil.rollback();
				throw new RuntimeException(e);
			}
		}
	}
}
