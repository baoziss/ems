package com.baizhi.util;

import java.util.Random;

/**
 * 随机盐工具类
 * @author Administrator
 *
 */
public class SaltUtil {
	/**
	 * 生成随机盐方法
	 * @param n  生成随机盐长度
	 * @return
	 */
	public static String getSalt(int n){
		char[] code = "1234567890qwertyuiopasdfghjklzxcvbmn!@#$%^&*()".toCharArray();
		//随机数
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			//从code数组中随机取出单个字符拼接
			sb.append(code[r.nextInt(code.length)]);
		}
		return sb.toString();
	}
}
