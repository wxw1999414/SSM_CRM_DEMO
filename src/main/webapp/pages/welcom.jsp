<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title></title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js">
</script>
		<script src="js/pintuer.js">
</script>
	</head>
	<body>
		<div class="panel admin-panel">
			<div class="body-content">
				欢迎登陆页面.....<br />
				<hr />
				<a href="${pageContext.request.contextPath}/pages/upload.jsp">文件上传下载操作</a>

			</div>
		</div>
	</body>
</html>