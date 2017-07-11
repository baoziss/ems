package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.EncodeUtil;
import com.baizhi.util.MD5Util;
import com.baizhi.util.SaltUtil;
import com.baizhi.util.ValidateImageCodeUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 用户模块控制器
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport {
	
	private String imageCode;
	private User user;
	private String mess;
	
	private UserService us = new UserServiceImpl();
	/**
	 * 用户登录控制
	 */
	public String login(){
		
		ValueStack vs = ActionContext.getContext().getValueStack();
			if(vs.findString("#session.code")==null){
				this.mess = EncodeUtil.encode("刷新页面重试！");
			}else if(vs.findString("#session.code").equals(imageCode)){
				try{
					User u = us.queryOne(user);
					vs.setValue("#session.user", u.getRealName());
					return SUCCESS;
				}catch (Exception e) {
				this.mess = EncodeUtil.encode(e.getMessage());
				}
			}else{
				this.mess = EncodeUtil.encode("验证码错误！");
			}
			return ERROR;
		
	}
	/**
	 * 用户注册控制
	 */
	public String regist(){
		ValueStack vs = ActionContext.getContext().getValueStack();
			if(vs.findString("#session.code")==null){
				this.mess = EncodeUtil.encode("刷新页面重试！");
			}
			if(vs.findString("#session.code").equals(imageCode)){
				try{
						User u = us.queryOne(user);
						this.mess = EncodeUtil.encode("用户已存在");
					}catch(Exception e){
						String salt = SaltUtil.getSalt(4);
						user.setSalt(salt);
						String pwd = MD5Util.getMd5Code(user.getPassword()+salt);
						user.setPassword(pwd);
						us.regist(user);
						return SUCCESS;
					}
			}else{
				this.mess = EncodeUtil.encode( "验证码错误！");
			}
			return ERROR;
	}
	/**
	 * 验证码
	 * @return
	 */
	public String imageCode(){
		//获取验证码
		String code = ValidateImageCodeUtils.getSecurityCode();
		BufferedImage image = ValidateImageCodeUtils.createImage(code);
		//获取将验证码放入session
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#session.code", code);
		//将图片放入流中
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			ServletOutputStream os = response.getOutputStream();
			ImageIO.write(image, "png", os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return INPUT;
		}
		return NONE;
	}
	
	
	
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
