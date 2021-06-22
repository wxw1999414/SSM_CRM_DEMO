<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<form method="post" action="${pageContext.request.contextPath}/contract/checkContract" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head">
					<strong class="icon-reorder">合同审查</strong>
				</div>
					ID:${map.RID}<br/>
				    合同ID:${map.number}

					客户:${map.CUSTOMER_NAME}<br/>

					合同内容:${map.CONTENT}<br/>

					合同金额:${map.MONEY}<br/>

					是否分期:${map.STAGES}<br/>

					合同状态:${map.STATE}<br/>

					合同期限:${map.HT_ENDTIME}<br/>

					合同签订时间:${map.DATE}<br/>

					备注:<input type="text" name="remake" value="${map.REMARKS}"><br/>
					*审查评价
					<textarea style="width:300px;height:100px;" name="reason"></textarea><br/>

					<br/>
					<select name="state">
						<option value="审核中">==审核中==</option>
						<option value="通过">==通过==</option>
						<option value="未通过">==未通过==</option>
						<option value="完成">==完成==</option>
						<option value="未完成">==未完成==</option>
						<option value="执行中">==执行中==</option>
					</select>
					<br/>
					<button type="submit">完成</button>
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