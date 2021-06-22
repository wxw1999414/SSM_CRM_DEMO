<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/admin.css">
		<script src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/pages/js/pintuer.js"></script>
	</head>
	<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder">功能列表</strong>
			<a href="" style="float: right; display: none;">添加字段</a>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left: 10px;">
				<li>
					<a class="button border-main icon-plus-square-o" href="pages/add.jsp">添加</a>
				</li>

			</ul>
		</div>
		<div class="padding border-bottom">
			<form method="post" class="form-x" action="${pageContext.request.contextPath}/add">
				<table>
					<tr>
						<td>编号</td>
						<td><input type="text" name="num"> </td>
						<td>标题</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td>等级</td>
						<td><input type="text" name="type"></td>
						<td>菜单</td>
						<td>
							<div class="field" style="padding-top:8px;">
								是<input name="isMenu" type="radio" checked="checked" value="1"/>
								否<input name="isMenu"  type="radio" value="0"/>
							</div>
						</td>
					</tr>
					<tr>
						<td>路径</td>
						<td colspan="3"><input type="text" name="path"></td>
					</tr>
					<tr>
						<td><input type="submit" value="提交"/></td>
						<td><input type="reset" value="重置"/></td>
					</tr>
				</table>
			</form>
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
					<c:forEach items="${list}" var="item" varStatus="i">
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
								${item.isMenu==1?"是":"否"}
							</td>
							<td>
								${item.menuType==null?" ":item.menuType}
							</td>
							<td>
								${item.url}
							</td>
							<td>
								<div class="button-group">
									<a class="button border-main" href="${pageContext.request.contextPath}/pages/add.jsp">
										<span class="icon-edit"></span>修改
									</a>
									<a class="button border-red" href="${pageContext.request.contextPath}/deleteAuthorityThree?id=${item.id}">
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