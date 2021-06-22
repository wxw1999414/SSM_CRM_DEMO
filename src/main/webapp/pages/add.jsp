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
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加功能模块</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/addAuthority">
      <div class="form-group">
        <div class="label">
          <label>编号：</label>
        </div>
        <div>
          <input type="text" class="input w50" value="" name="num" data-validate="required:请输入标题" />
          <span>规则默认从：100开始 到 999，下一级 为 100+001</span>
        </div>
      </div>


      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="title" data-validate="required:请输入标题" />
        </div>
      </div>
      
        <div class="form-group">
          <div class="label">
            <label>菜单等级：</label>
          </div>
          <div class="field">
            <select name="cid" class="input w50">
              <option value="">请选择</option>
              <option value="1">一级菜单</option>
              <option value="2">二级菜单</option>
              <option value="3">三级菜单</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>菜单：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
		                是<input name="isMenu" type="radio" checked="checked" value="1"/>
		                否<input name="isMenu"  type="radio" value="0"/>
          </div>
        </div>


        
        <div class="form-group">
           <div class="label">
             <label>路径：</label>
           </div>
           <div class="field">
             <input type="text" class="input w50" value="" name="path" data-validate="required:请输入标题" />
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
