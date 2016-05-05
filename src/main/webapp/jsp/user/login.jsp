<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri='http://java.sun.com/jstl/core_rt' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<c:set var="ctx" scope="request"
	value="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}" />
</head>
<body>
	<form action="${ctx}/j_spring_security_check" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="_spring_security_remember_me" />两周之内不必登陆</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录" />
					<input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>