<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>后台管理中心</title>
		<script src="pages/js/jquery-3.4.1.js" type="text/javascript"></script>
		<link rel="stylesheet" href="pages/css/pintuer.css" type="text/css">
		<link rel="stylesheet" href="pages/css/admin.css" type="text/css">
	</head>
	<body style="background-color: #f2f9fd;">
		<div class="header bg-main">
			<div class="logo margin-big-left fadein-top">
				<h1>
					<img src="pages/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />
					后台管理中心
				</h1>
			</div>
			<div class="head-l">
				<a class="button button-little bg-green" href="" target="_blank">
				<span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;
				<a href="##" class="button button-little bg-blue">
				<span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;
				<a class="button button-little bg-red" href="login.html">
				<span class="icon-power-off"></span> 退出登录</a>
			</div>
		</div>
		<div class="leftnav">
			<div class="leftnav-title">
				<strong><span class="icon-list"></span>菜单列表</strong>
			</div>
			<h2>
				<span class="icon-user"></span>权限管理
			</h2>
			<ul style="display: block">
				<li>
					<a href="${pageContext.request.contextPath}/Author_one?parentId=1" target="right">
					<span class="icon-caret-right"></span>功能管理</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/roleAuthor_user" target="right">
					<span class="icon-caret-right"></span>当前权限</a>
				</li>

				<li>
					<a href="${pageContext.request.contextPath}/role_show" target="right">
					<span class="icon-caret-right"></span>角色管理</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/selectAll" target="right">
						<span class="icon-caret-right"></span>潜在客户</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/myCustomer" target="right">
						<span class="icon-caret-right"></span>我的客户</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/companyCustomer/selectAll" target="right">
						<span class="icon-caret-right"></span>客户资料</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/role_show" target="right">
						<span class="icon-caret-right"></span>系统管理员管理</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/role_show" target="right">
						<span class="icon-caret-right"></span>系统管理员管理</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/goods/selectAll" target="right">
						<span class="icon-caret-right"></span>商品管理</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/Order/selectAll" target="right">
						<span class="icon-caret-right"></span>订单办理列表</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/contract/selectAll" target="right">
						<span class="icon-caret-right"></span>合同管理</a>
				</li>
<%--					<a href="${pageContext.request.contextPath}/page_queryPage.action?pm.nowPage=1&pm.size=5" target="right">&ndash;%&gt;--%>
<%--						<span class="icon-caret-right"></span>客户列表</a>--%>
<%--				<li>--%>
<%--					<a href="${pageContext.request.contextPath}/selectAll" target="right"></a>--%>
<%--					<span class="icon-caret-right"></span>潜在客户</a>--%>
<%--				</li>--%>
<%--				<li>--%>
<%--					<a href="${pageContext.request.contextPath}/pages/userInfo.jsp"/>--%>
<%--					<span class="icon-caret-right"></span>我的客户</a>--%>
<%--				</li>--%>


				<li>
					<a href="${pageContext.request.contextPath}/user/TUsers" target="right">
					<span class="icon-caret-right"></span>管理员列表</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/pages/login.jsp" target="right">
						<span class="icon-caret-right"></span>登陆(测试)</a>
				</li>

			</ul>
		</div>

		<ul class="bread">
			<li>
				<a href="{:U('Index/info')}" target="right" class="icon-home">
					首页</a>
			</li>
			<li>
				<a href="##" id="a_leader_txt">网站信息</a>
			</li>
			<li>
				<b>当前语言：</b><span style="color: red;">中文</php>
				</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：
				<a href="##">中文</a> &nbsp;&nbsp;
				<a href="##">英文</a>
			</li>
		</ul>
		<div class="admin">
			<iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath}/pages/welcom.jsp" name="right" width="100%" height="100%"></iframe>
		</div>
		<div style="text-align: center;">
			<p>
				来源:<a href="###" target="_blank">源码之家</a>
			</p>
		</div>

	</body>
</html>
<script type="text/javascript">
	$(function() {
		$(".leftnav h2").click(function() {
			$(this).next().slideToggle(200);
			$(this).toggleClass("on");
		})
		$(".leftnav ul li a").click(function() {
			$("#a_leader_txt").text($(this).text());
			$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
		})
	});
</script>