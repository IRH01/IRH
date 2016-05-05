<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:set var="ctx" value="${pageContext.request.contextPath}" /> --%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>角色添加</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<script type="text/javascript" src="${ctx}/js/common/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/role/add.js"></script>
</head>
<body>
	<form:form commandName="role" action="${ctx}/role/add.do"
		modelAttribute="role" method="post" cssClass="validate">
		角色名称：<form:input id="input1" class="input1" path="roleName" />
		<input type="submit" class="" value="添加" />
	</form:form>
	<input id="ctx" type="hidden" class="ctx" value="${ctx}" />
</body>
</html>
