package com.baizhi.inter;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.baizhi.entity.Dept;
import com.baizhi.service.impl.DeptServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 获取所有部门
 * @author Administrator
 *
 */
public class DeptsInterceptor extends AbstractInterceptor {
	/**
	 * 将所有部门信息放入request作用域
	 */
	public String intercept(ActionInvocation ai) throws Exception {
		DeptServiceImpl ds = new DeptServiceImpl();
		List<Dept> depts = ds.queryAll();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#request.depts", depts);
		ai.invoke();
		
		return "error";
	}

}
