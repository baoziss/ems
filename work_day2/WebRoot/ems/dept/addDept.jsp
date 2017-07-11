<%@page  pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>add Dept</title>
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
						添加部门信息:
					</h1>
					<form action="<s:url value='/dept/addDept' />" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									部门名称:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="dept.name" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="保存部门" />
							<input type="button" onclick="javascript:location.href='<s:url value='/dept/queryAll' />'" class="button" value="返回部门列表" />
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
