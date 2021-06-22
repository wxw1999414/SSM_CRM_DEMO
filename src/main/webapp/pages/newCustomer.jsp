<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/admin.css">
		<script src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/pages/js/pintuer.js"></script>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/newCoustomer" id="listform">
			<div class="panel admin-panel">
				<table class="table table-hover text-center">
					<div class="form-group">
<%--						序号：<input type="text"  value="${sessionScope.pl.rid}" name="id"  /><br><br>--%>
						客户名：<input type="text"  value="${sessionScope.pl.companyName}" name="name" data-validate="required:请输入客户名" /><br><br>
						客户类型：<input type="text"  value="" name="type" data-validate="required:请输入客户类型" /><br><br>
						法人：<input type="text"  value="" name="illName" data-validate="required:请输入法人" /><br><br>
						联系电话：<input type="text"  name="tel" value="${sessionScope.pl.tel}" data-validate="required:请输入联系电话" /><br><br>
						邮箱：<input type="text"  value="" name="email" data-validate="required:请输入邮箱" /><br><br>
						公司地址：<input type="text"  value="${sessionScope.pl.address}" name="address" data-validate="required:请输入公司地址" /><br><br>
						跟进人：<input type="text"  name="followPeople" value="${sessionScope.pl.followPerson}" data-validate="required:请输入跟进人" /><br><br>
						备注：<input type="text"  value="" name="remake" data-validate="required:请输入备注" />
					</div>
				</table>
				<div class="field">
					<button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
				</div>
			</div>
		</form>
	</body>
</html>

<script type="text/javascript">
		$(function (){
		$("#sss").click(function (){
			//异步请求
			alert($('#select').val());
			// console.log($('#select').val());
			$.ajax({
				url:'${pageContext.request.contextPath}/parentId',
				type:'post',
				data:{'keywords':$('#select').val()},
				dataType:'text',
				success:function(ret_str){
				}
			});
		});
	});
</script>