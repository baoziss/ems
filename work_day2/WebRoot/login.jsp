<%@ page pageEncoding="utf-8" errorPage="/ems/error/catchError.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<s:url value='/ems/css/style.css'/>" />
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
						<img src="<s:url value='/ems/img/header_logo.gif'/>"/>
					</h1>
					<form action="<s:url value='/login' />" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="user.username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="user.password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码：
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="imageCode" />
									<img  src="<s:url value="/user/imageCode" />"/>
								</td>
							</tr>
						</table>
						<s:property value="#parameters.mess[0]"/>
						<p>
							<input type="submit" class="button" value="登陆&raquo;" />
							<input type="button"  onclick="javascript:location.href='<s:url value='/ems/user/regist.jsp' />'" class="button"  value="点我注册&raquo;" />
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
