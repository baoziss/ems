package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.service.DeptService;
import com.baizhi.service.EmpService;
import com.baizhi.service.impl.DeptServiceImpl;
import com.baizhi.service.impl.EmpServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 员工模块
 * @author Administrator
 *
 */
public class EmpAction extends ActionSupport {
	private List<Emp> emplist;
	private Emp emp;
	public List<Emp> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Emp> emplist) {
		this.emplist = emplist;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	//私有empService对象
	private EmpService es = new EmpServiceImpl();
	private DeptService ds = new DeptServiceImpl();
	
	/**
	 * 获取所有员工控制器
	 */
	public String queryAll(){
		ValueStack vs = ActionContext.getContext().getValueStack();
		try {
			emplist = es.queryAll(emp.getDept().getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 添加员工控制器
	 */
	public String addEmp(){
		try {
			String did = emp.getDept().getId();
			Dept d = ds.queryOne(did);
			emp.setDept(d);
			es.addEmp(emp);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 删除员工控制
	 */
	public String dropEmp(){
		try {
			es.dropEmp(emp.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	/**
	 * 修改员工信息显示控制
	 */
	public String getEmpChange(){
		try {
			emp = es.queryOne(emp.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
	public String changeEmp(){
		try {
			es.changeEmp(emp);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
}
