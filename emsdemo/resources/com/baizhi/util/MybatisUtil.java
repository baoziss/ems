package com.baizhi.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis封装工具类
 * @author Administrator
 *
 */
public class MybatisUtil {
	
	private static final ThreadLocal<SqlSession> TOL = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sqlSessionFactory;
	private static InputStream IS;
	/**
	 * 加载配置文件
	 */
	static{
		try {
			IS = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(IS);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(IS);
		}
	}
	/**
	 * 获取sqlSession对象
	 */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = TOL.get();
		if(sqlSession == null){
			sqlSession = sqlSessionFactory.openSession();
			TOL.set(sqlSession);
		}
		return sqlSession;
	}
	/**
	 * 释放资源
	 */
	public static void release(){
		SqlSession sqlSession = getSqlSession();
		if(sqlSession != null){
			sqlSession.close();
			TOL.remove();
		}
	}
	/**
	 * 获取当前实现类
	 */
	public static <T>T getDao(Class<T> dao){
		return getSqlSession().getMapper(dao);
	}
	/**
	 * 事务提交
	 */
	public static void commit(){
		MybatisUtil.getSqlSession().commit();
		release();
	}
	/**
	 * 事务回滚
	 */
	public static void rollback(){
		MybatisUtil.getSqlSession().rollback();
		release();
	}
}
