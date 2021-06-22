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
		<form method="post" action="" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head">
					<strong class="icon-reorder"><br>功能列表</strong>
					<a href="" style="float: right; display: none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left: 10px;">
						<li>
							<a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath}/pages/add.jsp">添加</a>
						</li>
						<li>
							<input type="text" placeholder="请输入搜索关键字" name="kid" class="input" style="width: 250px; line-height: 17px; display: inline-block" id="select" />
							<a href="" class="button border-main icon-search" id="sss">搜索</a>
						</li>
					</ul>
				</div>
				<table class="table table-hover text-center">
					<tr>
						<th width="100" style="text-align: left; padding-left: 20px;">序号</th>
						<th width="10%">编号</th>
						<th>模块名称</th>
						<th>菜单</th>
						<th>菜单等级</th>
						<th>路径</th>
						<th width="310">
							操作
						</th>
					</tr>

					<c:forEach items="${th}" var="item" varStatus="i">
						<tr>
							<td style="text-align: left; padding-left: 20px;">
								${i.index+1}
							</td>
							<td>
								${item.id}
							</td>
							<td>
								${item.name}
							</td>
							<td>
								${item.isMenu}
							</td>
							<td>
								${item.menuType}
							</td>
							<td>
								${item.url}
							</td>
							<td>
								<div class="button-group">
									<a class="button border-main" href="${pageContext.request.contextPath}/Author_two?parentId=${item.id}">添加二级菜单</a>
									<a class="button border-main" href="${pageContext.request.contextPath}/updateAuthority?id=${item.id}/pages/add.jsp">
										<span class="icon-edit"></span>修改
									</a>
									<a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)">
										<span class="icon-trash-o"></span>删除
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
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