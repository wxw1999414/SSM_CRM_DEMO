<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加潜在客户模块</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/companyCustomer/companyCustomerAdd">
      <div class="form-group">
        <div class="label">
          <label>客户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="customerName">
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>客户类型：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="customerType"  />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>法人：</label>
        </div>
        <div class="field" style="padding-top:8px;">
          <input type="text" class="input w50" value="" name="legalPerson"  />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>联系电话：</label>
        </div>
        <div class="field" style="padding-top:8px;">
          <input type="text" class="input w50" value="" name="tel"  />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="email" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="address" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>跟进人员：</label>
        </div>
        <div class="field" style="padding-top:8px;">
          <label>
            <select name="followPerson" >
              <option  >==选中跟进人员==</option>
              <c:forEach items="${tuser}" var="i">
                <option value="${i.RID}">${i.U_NAME}</option>
              </c:forEach>
            </select>
          </label>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="remarks" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>
