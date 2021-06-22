<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<form method="post" action="${pageContext.request.contextPath}/deleteCustomerById">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 跟进客户</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
            <a class="button border-red" href="${pageContext.request.contextPath}/selectAllFollowPeople"> 添加</a>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 删除</button>

        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">ID</th>
        <th>姓名</th>       
        <th>电话</th>
        <th>地址</th>
        <th>跟进人员</th>
        <th width="25%">是否正式签约</th>
         <th width="120">是否终止更进</th>
        <th>操作</th>       
      </tr>
      <c:forEach items="${lcr}" var="item" >
        <tr>
          <td><input type="checkbox" name="id" value="${item.RID}" />${item.RID}</td>

          <td>${item.COMPANY_NAME}</td>
          <td>${item.TEL}</td>
          <td>${item.ADDRESS}</td>
          <td>${item.U_NAME}</td>
          <td>${item.SIGNED}</td>
          <td>${item.FOLLOW_UP}</td>
          <td>
            <div class="button-group"> <a class="button border-red" href="${pageContext.request.contextPath}/sessionSave?id=${item.RID}" onclick="return del(1)">
                <span class="icon-trash-o"></span> 修改</a>
            </div>
              <div class="button-group"> <a class="button border-red" href="${pageContext.request.contextPath}/sessionSaveCustomer?id=${item.RID}">
                  <span class="icon-trash-o"></span> 跟进</a>
              </div>
              <div class="button-group"> <a class="button border-red" href="${pageContext.request.contextPath}/selectFollowPeople?id=${item.RID}" >
                  <span class="icon-trash-o"></span> 划转客户</a>
              </div>
          </td>
        </tr>
      </c:forEach>

	    <tr>
	      <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
	    </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要修改吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}



</script>
</body></html>