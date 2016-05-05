<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><%@taglib uri='http://java.sun.com/jstl/core_rt'
	prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<c:set var="ctx" scope="request"
	value="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}" />

</head>
<body>
	头部结构
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<ul>
		<li><a href="${logoutUrl}">Log Out</a></li>
	</ul>
</body>
</html>