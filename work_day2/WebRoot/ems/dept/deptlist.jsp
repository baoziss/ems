<%@ page pageEncoding="utf-8" errorPage="/ems/error/catchError.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href='<s:url value='/ems/css/style.css' />'" />
		<link href="<s:url value='/ems/css/common.css' />" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						<jsp:include page="/ems/user/uname.jsp" />
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								部门ID
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<s:if test="deptlist.size()==0">
							<tr>
								<td rowspan="3" text-align="middle">部门为空！</td>
							</tr>
						</s:if>
						<s:else>
						<s:iterator value="deptlist" status="d">
						<s:if test="#d.odd">
						<tr class="row1">
							<td><s:property value="id"/></td><td><s:property value="name" /></td>
							<td>
								<a href="<s:url value='/dept/dropDept'/>?dept.id=<s:property value="id"/>">删除部门</a>&nbsp;<a href="<s:url value='/dept/getDeptChange' />?dept.id=<s:property value='id' />">更新部门</a>&nbsp;<a href="<s:url value='/emp/queryAll' />?emp.dept.id=<s:property value='id' />">展示当前部门的员工信息</a>
							</td>
						</tr>
						</s:if>
						<s:else>
						<tr class="row2">
							<td><s:property value="id" /></td><td><s:property value="name" /></td>
							<td>
								<a href="<s:url value='/dept/dropDept' />?dept.id=<s:property value='id' />">删除部门</a>&nbsp;<a href="<s:url value='/dept/getDeptChange' />?dept.id=<s:property value='id' />">更新部门</a>&nbsp;<a href="<s:url value='/emp/queryAll' />?emp.dept.id=<s:property value='id' />">展示当前部门的员工信息</a>
							</td>
						</tr>
						</s:else>
						</s:iterator>
						</s:else>
					</table>
					<p>
						<input type="button" class="button" value="添加部门" onclick="location='<s:url value='/ems/dept/addDept.jsp' />'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
