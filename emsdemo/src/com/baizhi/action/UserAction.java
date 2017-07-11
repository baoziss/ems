package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.EncodeUtil;
import com.baizhi.util.ValidateImageCodeUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 用户相关action
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport {
	
	private User user;
	private String mess;
	private String code;
	
	private UserService us = new UserServiceImpl();
	/**
	 * 用户登录功能
	 */
	public String login(){
		ValueStack vs = ActionContext.getContext().getValueStack();
		try {
			User u = us.queryOne(user);
			vs.setValue("#session.user", u.getRealname());
			return SUCCESS;
		} catch (Exception e) {
			this.mess = EncodeUtil.encode(e.getMessage());
			return ERROR;
		}
	}
	/**
	 * 用户注册功能
	 */
	public String regist(){
		ValueStack vs = ActionContext.getContext().getValueStack();
		try {
			String imageCode = vs.findString("#session.code");
			if(imageCode == null){
				this.mess = EncodeUtil.encode("刷新页面重试！");
			}else if(imageCode.equalsIgnoreCase(this.code)){
				us.regist(user);
				return SUCCESS;
			}else{
				this.mess = EncodeUtil.encode("验证码错误！");
			}
		} catch (Exception e) {
			this.mess = e.getMessage();
			e.printStackTrace();
		}
		return ERROR;
	}
	/**
	 * 验证码
	 */
	public String imageCode(){
		//获取验证码
		String code = ValidateImageCodeUtils.getSecurityCode();
		BufferedImage createImage = ValidateImageCodeUtils.createImage(code);
		//保存code
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#session.code", code);
		//将图片放入流中
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			ServletOutputStream os = response.getOutputStream();
			ImageIO.write(createImage, "png", os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
