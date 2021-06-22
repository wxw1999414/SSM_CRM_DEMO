<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<strong class="icon-reorder">订单列表</strong>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left: 10px;">
						<li>
							<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" id="select" style="width: 250px; line-height: 17px; display: inline-block" />
							<a href="" class="button border-main icon-search" id="sss" >搜索</a>
						</li>
					</ul>
				</div>
				<table class="table table-hover text-center">
					<tr>
						<th style="text-align: left; padding-left: 20px;">
							ID
						</th>
						<th>合同ID:</th>
						<th>驳回原因:</th>
						<th>驳回时间:</th>
						<th width="310">
							操作
						</th>
					</tr>
					<c:forEach items="${conAll}" var="item" varStatus="i">
						<tr>
							<td style="text-align: left; padding-left: 20px;">
									${i.index+1}
							</td>
							<td>
								${item.contractNumber}
							</td>
							<td>
								${item.reason}
							</td>
							<td >
									${item.time}
							</td>
							<td>
								<div class="button-group">
									<a class="button border-red" href="${pageContext.request.contextPath}/contractReject/deleteById?id=${item.rid}" >
										<span class="icon-trash-o"></span>删除
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
<script type="text/javascript">
	//搜索
	$(function (){
		$("#sss").click(function (){
			$.ajax({
				url:'${pageContext.request.contextPath}/Order/selectByName',
				type:'post',
				data:{'keywords':$('#select').val()},
				dataType:'text',
				success:function(res){
					console.log("跳转......"+res);
					location.href="${pageContext.request.contextPath}/pages/order_goodsInfoByName.jsp"


				},
				error: function(error){
					console.log(error)
				}
			});
		});
	});
	//单个删除
	function del(id, mid, iscid) {
		if (confirm("您确定要删除吗?")) {
		}
	}
	//全选
	$("#checkall").click(function() {
		$("input[name='id[]']").each(function() {
			if (this.checked) {
				this.checked = false;
			} else {
				this.checked = true;
			}
		});
	})
	
	//批量删除
	function DelSelect() {
		var Checkbox = false;
		$("input[name='id[]']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
			var t = confirm("您确认要删除选中的内容吗？");
			if (t == false)
				return false;
			$("#listform").submit();
		} else {
			alert("请选择您要删除的内容!");
			return false;
		}
	}
	
	//批量排序
	function sorts() {
		var Checkbox = false;
		$("input[name='id[]']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
	
			$("#listform").submit();
		} else {
			alert("请选择要操作的内容!");
			return false;
		}
	}
	
	//批量首页显示
	function changeishome(o) {
		var Checkbox = false;
		$("input[name='id[]']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
	
			$("#listform").submit();
		} else {
			alert("请选择要操作的内容!");
	
			return false;
		}
	}
	
	//批量推荐
	function changeisvouch(o) {
		var Checkbox = false;
		$("input[name='id[]']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
	
			$("#listform").submit();
		} else {
			alert("请选择要操作的内容!");
	
			return false;
		}
	}
	
	//批量置顶
	function changeistop(o) {
		var Checkbox = false;
		$("input[name='id[]']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
	
			$("#listform").submit();
		} else {
			alert("请选择要操作的内容!");
	
			return false;
		}
	}
	
	//批量移动
	function changecate(o) {
		var Checkbox = false;
		$("input[name='id[]']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
	
			$("#listform").submit();
		} else {
			alert("请选择要操作的内容!");
	
			return false;
		}
	}
	
	//批量复制
	function changecopy(o) {
		var Checkbox = false;
		$("input[name='id[]']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
			var i = 0;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					i++;
				}
			});
			if (i > 1) {
				alert("只能选择一条信息!");
				$(o).find("option:first").prop("selected", "selected");
			} else {
	
				$("#listform").submit();
			}
		} else {
			alert("请选择要复制的内容!");
			$(o).find("option:first").prop("selected", "selected");
			return false;
		}
	}
</script>
	</body>
</html>