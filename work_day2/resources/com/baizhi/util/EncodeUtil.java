package com.baizhi.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 编码工具类
 * @author Administrator
 *
 */
public class EncodeUtil {
	/**
	 *设置编码
	 * @param mess 传入字符串
	 * @param charset 编码格式
	 * @return
	 */
	public static String encode(String mess,String charset){
		try {
			return URLEncoder.encode(mess, charset);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 默认编码格式utf-8
	 * @param mess
	 * @return
	 */
	public static String encode(String mess){
		return encode(mess,"utf-8");
	}
}
