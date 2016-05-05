<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri='http://java.sun.com/jstl/core_rt' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<c:set var="ctx" scope="request"
	value="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}" />
<link href="${ctx}/css/global.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/css/menu.css" type="text/css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/pages.css" />
<script type="text/javascript"
	src="${ctx}/js/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common/jquery.metadata.js"></script>
<script type="text/javascript" src="${ctx}/js/common/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/common/messages_zh.js"></script>
<script type="text/javascript" src="${ctx}/js/common/menu.js"></script>
</head>
<body>
	<input type="hidden" id="_CONTEXT_PATH" value="${ctx}">
	<!--header-->
	<div id="header" class="header">
		<tiles:insertAttribute name="header" />
	</div>
	<!--end header-->
	<!--content-->
	<div class="content">
		<!-- left -->
		<div id="cntLeft" class="cntLeft">
			<tiles:insertAttribute name="menu" />
		</div>
		<!--cntRight-->
		<div class="cntRight">
			<div class="cntRightcontent">
				<div class="cRTop">
					<div class="cRTL">
						<p class="cTnav" id="cTnav"></p>
						<div class="cRTnav" id="cRTnav"></div>
					</div>
				</div>
				<div style="padding: 10px;" id="bodyDiv">
					<tiles:insertAttribute name="body" />
				</div>
				<div style="padding: 10px;" id="footer">
					<tiles:insertAttribute name="footer" />
				</div>
			</div>
		</div>
		<!--end cntRight-->
	</div>
	<!--end content-->
</body>
</html>