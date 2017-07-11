package com.baizhi.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author Administrator
 *
 */
public class MD5Util {
	/**
	 * MD5加密方法
	 * @param pwd 明文密码
	 * @return
	 */
	public static String getMd5Code(String pwd){
		try {
			//设置加密格式
			MessageDigest digest = MessageDigest.getInstance("md5");
			//加密
			byte[] bs = digest.digest(pwd.getBytes());
			StringBuilder sb = new StringBuilder();
			for(byte b:bs){
				int c = b & 0xff;
				//转换成16进制数
				if(c<16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(c));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
