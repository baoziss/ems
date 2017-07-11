<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<s:url value='/page-download-ems/css/style.css' />" />
		<link href="<s:url value='/page-download-ems/css/common.css' />" type="text/css" rel="stylesheet" />
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
					<jsp:include page="/page-download-ems/user/uname.jsp" />
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
								Bir
							</td>
							<td>
								Operation
							</td>
						</tr>
						<s:if test="emps.size==0">
							<tr>
								<td>列表为空！</td>
							</tr>
						</s:if>
						<s:else>
							<s:iterator value="emps" status="i">
							<s:if test="#i.odd">
								<tr class="row1">
									<td><s:property value="id" /></td><td><s:property value="name" /></td><td><s:property value="salary" /></td><td><s:property value="age" /></td><td><s:date name="birthday" format="yyyy-MM-dd"/></td>
									<td>
										<a href="<s:url value='/emp/dropEmp' />?emp.id=<s:property value='id' />">delete emp</a>&nbsp;<a href="<s:url value='/emp/getChangeEmp' />?emp.id=<s:property value='id' />">update emp </a><a href="<s:url value='/emp/downLoadEmp' />?emp.id=<s:property value='id' />&opentype=attachment">down emp info</a>
									</td>
								</tr>
							</s:if>
							<s:else>
								<tr class="row2">
									<td><s:property value="id" /></td><td><s:property value="name" /></td><td><s:property value="salary" /></td><td><s:property value="age" /></td><td><s:date name="birthday" format="yyyy-MM-dd"/></td>
									<td>
										<a href="<s:url value='/emp/dropEmp' />?emp.id=<s:property value='id' />">delete emp</a>&nbsp;<a href="<s:url value='/emp/getChangeEmp' />?emp.id=<s:property value='id' />">update emp</a>&nbsp;<a href="<s:url value='/emp/downLoadEmp' />?emp.id=<s:property value='id' />&opentype=attachment">down emp info</a>
									</td>
							</tr>
							</s:else>
							</s:iterator>
						</s:else>
					</table>
					<div class="pagination">
					<s:if test="pageNum!=1">
						<a href="<s:url value='/emp/queryAll' />?pageNum=1" class="firstPage"></a>
					</s:if>
					<s:else>
						<span class="firstPage">&nbsp</span>
					</s:else>
					<s:if test="pageNum!=1">
						<a href="<s:url value='/emp/queryAll' />?pageNum=<s:property value='pageNum-1' />" class="previousPage"></a>
					</s:if>
					<s:else>
						<span class="previousPage">&nbsp</span>
					</s:else>
					<s:iterator begin="1" end="countPage" step="1" status="i">
						<s:if test="pageNum==#i.count">
							<a href="<s:url value='/emp/queryAll' />?pageNum=<s:property value='#i.count' />" class="currentPage"><s:property value="#i.count" /></a> 
						</s:if>
						<s:else>
							<a href="<s:url value='/emp/queryAll' />?pageNum=<s:property value='#i.count' />"><s:property value="#i.count" /></a>
						</s:else>
					</s:iterator>
					<s:if test="pageNum!=countPage">
						<a href="<s:url value='/emp/queryAll' />?pageNum=<s:property value='pageNum+1' />"class="nextPage"></a>
					</s:if>
					<s:else>
						<span class="nextPage">&nbsp</span>
					</s:else>
					<s:if test="pageNum!=countPage">
						<a href="<s:url value='/emp/queryAll' />?pageNum=<s:property value='countPage' />" class="lastPage"></a>
					</s:if>
					<s:else>
						<span class="lastPage">&nbsp</span>
					</s:else>
						<span>共<s:property value="countPage" />页</span>
						<span class="pageSkip" style="float:right"> 
							<form action="<s:url value='/emp/queryAll' />" method="post">
								到第<input id="pageNumber" name="pageNum" value="<s:property value='nowPage' />" maxlength="9" >页
									<button type="submit">&nbsp;</button>
							</form>
						 </span>
					</div>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='<s:url value="/page-download-ems/emp/addEmp.jsp" />'"/>
						<input type="button" class="button" value="Down All Info" onclick="location='<s:url value='/emp/downLoadEmps' />"/>
						<%-- <a href="<s:url value='/emp/downLoadEmps' />">Down All Info</a> --%>
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
