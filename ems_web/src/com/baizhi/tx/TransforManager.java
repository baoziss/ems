package com.baizhi.tx;

import java.sql.Connection;
import java.sql.SQLException;

import com.baizhi.util.JdbcUtil;

/**
 * 事务控制
 * @author Administrator
 *
 */
public class TransforManager {
	
	/**
	 * 事务开始
	 */
	public static void begin(){
		try {
			Connection con = JdbcUtil.getCon();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 提交事务
	 */
	public static void commit(){
		Connection con =null;
		try {
				con = JdbcUtil.getCon();
				con.commit();
			} catch (SQLException e) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, null, con);
		}
	}
}
