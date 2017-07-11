<%@ page pageEncoding="utf-8" errorPage="/ems/error/catchError.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<s:url value='/ems/css/style.css' />" />
		<link rel="stylesheet" type="text/css" href="<s:url value='/ems/css/common.css' />" />
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
						更新员工信息:
					</h1>
					<form action="<s:url value='/emp/changeEmp' />" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									ID:
								</td>
								<td valign="middle" align="left">
								<input type="hidden" class="inputgri" name="emp.id" value="<s:property value='emp.id'/>"/>
									<s:property value='emp.id'/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.name" value="<s:property value='emp.name'/>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.salary" value="<s:property value='emp.salary'/>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.age" value="<s:property value='emp.age'/>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									生日:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.birthday" value="<s:date name="emp.birthday" format="yyyy-MM-dd" />"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									选择部门:
								</td>
								<td valign="middle" align="left">
									<select name="emp.dept.id">
										<s:iterator value="#session.deptlist">
											<option value="<s:property value='id' />" <s:if test="id==emp.dept.id">selected</s:if>/>
												<s:property value="name" />
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="更新" />
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
