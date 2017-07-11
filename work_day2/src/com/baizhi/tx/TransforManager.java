package com.baizhi.tx;

import java.sql.Connection;

import com.baizhi.util.JdbcUtil;

/**
 * 事务管理
 * @author Administrator
 *
 */
public class TransforManager {
	/**
	 * 事务开始
	 */
	public static void begin(){
		Connection con = null;
		try {
			con = JdbcUtil.getCon();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 事务提交
	 */
	public static void commit(){
		Connection con = null;
		try {
			con = JdbcUtil.getCon();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, null, con);
		}
	}
	/**
	 * 事务回滚
	 */
	public static void rollback(){
		Connection con = null;
		try {
			con = JdbcUtil.getCon();
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, null, con);
		}
	}
}
