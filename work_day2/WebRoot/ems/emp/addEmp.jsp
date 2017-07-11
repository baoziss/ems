<%@ page pageEncoding="utf-8" errorPage="/ems/error/catchError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<s:url value='/ems/css/style.css' />" />
		<link type="text/css" rel="stylesheet" href="<s:url value='/ems/css/common.css' />" />
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
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						添加员工信息:
					</h1>
					<form action="<s:url value='/emp/addEmp' />" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									名称:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									生日:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.birthday" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									所属部门:
								</td>
								<td valign="middle" align="left">
									<select name="emp.dept.id">
									<s:iterator value="#session.deptlist">
										<option value="<s:property value='id' />"><s:property value="name" /></option>
									</s:iterator>
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="保存" />
							<input type="button" onclick="javascript:history.go(-1)" class="button" value="返回上级" />
						</p>
					</form>
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
