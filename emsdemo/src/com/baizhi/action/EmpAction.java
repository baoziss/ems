package com.baizhi.action;

import java.util.List;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.baizhi.service.impl.EmpServiceImpl;
import com.baizhi.util.EncodeUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 员工相关action
 * @author Administrator
 *
 */
public class EmpAction extends ActionSupport {
	
	private Emp emp;
	private List<Emp> emps;
	private String mess;
	
	private EmpService es = new EmpServiceImpl();
	
	/**
	 * 获取所有员工
	 */
	public String queryAll(){
		emps = es.queryAll();
		return SUCCESS;
	}
	/**
	 * 删除员工
	 */
	public String dropEmp(){
		try {
			es.dropEmp(emp.getId());
			this.mess=EncodeUtil.encode("操作成功！");
		} catch (Exception e) {
			this.mess = EncodeUtil.encode(e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 插入员工信息
	 */
	public String addEmp(){
		try {
			es.addEmp(emp);
			this.mess=EncodeUtil.encode("操作成功！");
		} catch (Exception e) {
			this.mess = EncodeUtil.encode(e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 获取修改信息
	 * @return
	 */
	public String getChange(){
		this.emp = es.queryOne(emp.getId());
		return SUCCESS;
	}
	/**
	 * 修改操作
	 * @return
	 */
	public String changeEmp(){
		try {
			es.changeEmp(emp);
			this.mess=EncodeUtil.encode("操作成功！");
		} catch (Exception e) {
			this.mess = EncodeUtil.encode(e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
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
	
	
}
