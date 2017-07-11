package com.baizhi.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.baizhi.service.impl.EmpServiceImpl;
import com.baizhi.util.DBCountUtil;
import com.baizhi.util.EncodeUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 员工模块Action
 * @author Administrator
 *
 */
public class EmpAction extends ActionSupport {
	
	private Integer nowPage;
	private Integer countPage;
	private Integer pageNum=1;
	private String opentype;
	private Emp emp;
	private List<Emp> emps;
	
	private EmpService es = new EmpServiceImpl();
	
	/**
	 * 分页查询所有员工信息
	 */
	public String queryAll(){
		try {
			int i  = DBCountUtil.getCount("ttt_emp")%2;
			if(i==0){
				this.countPage = DBCountUtil.getCount("ttt_emp")/2;
			}else{
				this.countPage = DBCountUtil.getCount("ttt_emp")/2+1;
			}
			if(pageNum > countPage){
				pageNum = countPage;
			}else if(pageNum < 1){
				pageNum = 1;
			}
			nowPage = pageNum;
			
			emps = es.queryEmpNyPage(nowPage, 2);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	
	/**
	 * 添加员工信息
	 */
	public String addEmp(){
		try {
			es.addEmp(emp);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 下载员工信息
	 */
	public String downLoadEmp(){
		try {
			Emp e = es.queryEmp(emp.getId());
			HttpServletResponse response = ServletActionContext.getResponse();
			//获取响应流
			ServletOutputStream os = response.getOutputStream();
			//设置响应格式为txt
			response.setContentType("text/plain");
			//设置文件名
			String fileName = UUID.randomUUID().toString().replace("-", "")+new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(new Date())+".txt";
			//设置响应头
			response.setHeader("content-disposition", opentype+";fileName="+EncodeUtil.encode(fileName));
			//获取输出内容输出
			byte[] bs = e.toString().getBytes();
			IOUtils.write(bs, os);
			
			IOUtils.closeQuietly(os);
			
			return NONE;
		} catch (IOException e1) {
			e1.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 下载所有员工信息
	 * @return
	 */
	public String downLoadEmps(){
		try {
			List<Emp> list = es.queryEmps();
			HttpServletResponse response = ServletActionContext.getResponse();
			//获取响应输出流
			ServletOutputStream os = response.getOutputStream();
			//设置响应格式为txt
			response.setContentType("text/plain");
			//设置文件名
			String fileName = UUID.randomUUID().toString().replace("-", "")
					+ new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(new Date())
					+ ".txt";
			//设置响应头
			response.setHeader("content-disposition", "attachment;fileName="+EncodeUtil.encode(fileName));
			//获取输出内容
			for (Emp e : list ) {
				byte[] b = (e.toString()+"\r\n").getBytes();
				IOUtils.write(b, os);
			}
			IOUtils.closeQuietly(os);
			
			return NONE;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 删除员工Action
	 * @return
	 */
	public String dropEmp(){
		try {
			es.dropEmp(emp.getId());
			this.pageNum = this.nowPage;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 获取修改信息
	 * @return
	 */
	public String getChangeEmp(){
		try {
			this.emp = es.queryEmp(emp.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 修改信息Action
	 * @return
	 */
	public String changEmp(){
		try {
			es.changeEmp(emp);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	
	
	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	
	
}
