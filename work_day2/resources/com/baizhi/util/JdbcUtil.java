package com.baizhi.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
/**
 * Jdbc连接工具类
 * @author Administrator
 *
 */
public class JdbcUtil {
	//声明properties对象
	private static Properties prop = new Properties();
	//建立threadLocal对象
	private static final ThreadLocal<Connection> TOL = new ThreadLocal<Connection>();
	
	/**
	 * 静态代码块负责加载配置文件
	 */
	static{
		InputStream is = null;
		try {
			is = JdbcUtil.class.getResourceAsStream("/com/baizhi/conf/db.properties");
			prop.load(is);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(is != null){
				try {is.close();} catch (IOException e1) {e1.printStackTrace();throw new RuntimeException(e1);}
			}
		}
	}
	/**
	 * 获取数据库连接
	 * @return	
	 */
	public static Connection getCon(){
		Connection con = TOL.get();
		try {
			if(con==null){
				//加载驱动
				Class.forName(prop.getProperty("driver"));
				//获取连接
				con = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("name"),prop.getProperty("pwd"));
				TOL.set(con);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return con;
	}
	/**
	 * 释放连接资源
	 * @param rs	结果集
	 * @param pstm	preparedStatement
	 * @param con	连接
	 */
	public static void release(ResultSet rs,PreparedStatement pstm,Connection con){
		try {
			if(rs != null)rs.close();
			if(pstm != null) pstm.close();
			if(con != null) {con.close();TOL.remove();}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
