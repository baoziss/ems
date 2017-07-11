package com.baizhi.inter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 控制页面
 * @author Administrator
 *
 */
public class PageNumInterceptor extends AbstractInterceptor {

	
	public String intercept(ActionInvocation ai) throws Exception {
		ValueStack vs = ActionContext.getContext().getValueStack();
		String nowPage = vs.findString("#parameters.pageNum[0]");
		vs.setValue("#request.nowPage", nowPage);
		ai.invoke();
		return "error";
	}
}
