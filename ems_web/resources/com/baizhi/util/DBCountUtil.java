package com.baizhi.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 获得表中数据条数
 * @author Administrator
 *
 */
public class DBCountUtil {
	
	public static int getCount(String tableName){
		int count = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getCon();
			String sql = "select count(id) from "+tableName.toUpperCase();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(rs, pstm, con);
		}
		return count;
		
	}
}
