package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Dept;
import com.baizhi.service.DeptService;
import com.baizhi.service.impl.DeptServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 部门模块控制器
 * @author Administrator
 *
 */
public class DeptAction extends ActionSupport {
	private List<Dept> deptlist;
	private Dept dept;
	public List<Dept> getDeptlist() {
		return deptlist;
	}
	public void setDeptlist(List<Dept> deptlist) {
		this.deptlist = deptlist;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	//新建业务层对象
	private DeptService ds = new DeptServiceImpl();
	/**
	 *显示所有部门信息控制方法 
	 */
	public String queryAll(){
		ValueStack vs = ActionContext.getContext().getValueStack();
		try {
			deptlist = ds.queryAll();
			vs.setValue("#session.deptlist", deptlist);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 删除部门控制方法
	 * @return
	 */
	public String dropDept(){
		try {
			ds.dropDept(dept.getId());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 获取要修改的部门信息控制方法
	 * @return
	 */
	public String getDeptChange(){
		try {
			dept = ds.queryOne(dept.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 修改部门Action
	 * @return
	 */
	public String changeDept(){
		try {
			ds.changeDept(dept);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 添加部门方法
	 */
	public String addDept(){
		try {
			ds.addDept(dept.getName());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
}
