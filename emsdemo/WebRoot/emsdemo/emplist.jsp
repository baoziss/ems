<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<s:url value='/emsdemo/css/style.css' />" />
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
					<jsp:include page="/emsdemo/realname.jsp" />
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>
						<s:iterator value="emps" status="i">
						<s:if test="#i.odd">
						<tr class="row1">
							<td><s:property value="id" /></td><td><s:property value="name" /></td><td><s:property value="salary" /></td><td><s:property value="age" /></td>
							<td>
								<a href="<s:url value='/emp/dropEmp' />?emp.id=<s:property value='id' />">delete emp</a>&nbsp;<a href="<s:url value='/emp/getChange' />?emp.id=<s:property value='id' />">update emp</a>
							</td>
						</tr>
						</s:if>
						<s:else>
						<tr class="row2">
							<td><s:property value="id" /></td><td><s:property value="name" /></td><td><s:property value="salary" /></td><td><s:property value="age" /></td>
							<td>
								<a href="<s:url value='/emp/dropEmp' />?emp.id=<s:property value='id' />">delete emp</a>&nbsp;<a href="<s:url value='/emp/getChange' />?emp.id=<s:property value='id' />">update emp</a>
							</td>
						</tr>
						</s:else>
						</s:iterator>
						<s:property value="#parameters.mess[0]"/>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='<s:url value="/emsdemo/addEmp.jsp" />'"/>
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
