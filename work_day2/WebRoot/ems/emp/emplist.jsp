<%@ page pageEncoding="utf-8" errorPage="/ems/error/catchError.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<s:url value='/ems/css/style.css' />" />
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
								姓名
							</td>
							<td>
								薪资
							</td>
							<td>
								年龄
							</td>
							<td>
								生日
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<s:iterator value="emplist" status="e">
						<s:if test="#e.odd">
						<tr class="row1">
							<td><s:property value="name" /></td><td><s:property value="salary" /></td><td><s:property value="age" /></td><td><s:date name="birthday" format="yyyy-MM-dd" /></td><td><s:property value="dept.name" /></td>
							<td>
								<a href="<s:url value='/emp/dropEmp' />?emp.id=<s:property value='id' />">删除员工信息</a>&nbsp;<a href="<s:url value='/emp/getEmpChange' />?emp.id=<s:property value='id' />">更新员工信息</a>
							</td>
						</tr>
						</s:if>
						<s:else>
						<tr class="row2">
							<td><s:property value="name" /></td><td><s:property value="salary" /></td><td><s:property value="age" /></td><td><s:date name="birthday" format="yyyy-MM-dd" /></td><td><s:property value="dept.name" /></td>
							<td>
								<a href="<s:url value='/emp/dropEmp' />?emp.id=<s:property value='id' />">删除员工信息</a>&nbsp;<a href="<s:url value='/emp/getEmpChange' />?emp.id=<s:property value='id' />">更新员工信息</a>
							</td>
						</tr>
						</s:else>
						</s:iterator>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='<s:url value='/ems/emp/addEmp.jsp' />'"/>
						<input type="button" class="button" value="返回当前部门列表" onclick="location='<s:url value='/dept/queryAll'/>'"/>
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

