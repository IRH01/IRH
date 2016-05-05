<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <c:set var="ctx" value="${pageContext.request.contextPath}" /> --%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>角色列表</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta charset="UTF-8">
<link href="${ctx}/css/common/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/js/common/jquery.min.js"></script>
<script src="${ctx}/js/common/bootstrap.min.js"></script>
</head>
<body>
	<table class="table">
		<caption>基本的表格布局</caption>
		<thead>
			<tr>
				<th width="7%">角色ID</th>
				<th width="7%">角色名称</th>
				<th width="7%">操作</th>
				<th width="7%"><a href="${ctx}/role/add.do">新增角色</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${roles}">
				<tr>
					<td><input type="hidden" value="${item.id}" class="id" />${item.id}</td>
					<td>${item.roleName}</td>
					<td><a href="javascript:void(0)" onclick="listDetail(this);"
						class="detail" style="cursor: pointer;">详情</a>|<a
						href="javascript:void(0)" class="delete" style="cursor: pointer;"
						onclick="listDelete(this)">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
