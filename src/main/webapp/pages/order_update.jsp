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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>商品功能模块</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/Order/updateCustom">
      <div class="form-group">
        <div class="label">
          <label>订单ID：</label>
        </div>
        <div class="field">
<%--          <input type="text" id="demoTest" name="rid">--%>
          <input type="text" class="input w50" value="${orderInfo.orderId}" name="rid"  />
        </div>
      </div>
      <div class="form-group">
        <div class="label" >
            <label>原来订单发货时间：${orderInfo.ORDER_GOODS_TIME}</label><br/>
          <label>选中订单发货时间：</label>
        </div>
        <div class="field">
          <input type="date" class="measureDate" placeholder="请选择日期" value="${orderInfo.ORDER_GOODS_TIME}" name="orderGoodsTime">
        </div>
      </div>
      <div class="form-group">
        <div class="label">
            <label>原来预计收货时间：${orderInfo.CUSTOMER_GET_TIME}</label><br/>
          <label>选中卖家预计收货时间：</label>
        </div>
        <div class="field">
          <input type="date" class="measureDate" placeholder="请选择日期" value="${orderInfo.CUSTOMER_GET_TIME}" name="customerGetTime">
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>订单状态：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${orderInfo.STATE}" name="state" data-validate="required:请输入订单状态" />
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${orderInfo.REMARKS}" name="remarks" data-validate="required:请输入备注" />
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

</body>

<script type="text/javascript">
  //日期设置，不可选择今日之后的日期
  $(function() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1 < 10 ? "0" + (now.getMonth() + 1)
            : (now.getMonth() + 1);
    var day = now.getDate() < 10 ? "0" + now.getDate() : now.getDate();
    $("#startCreatetime").attr("max", year + "-" + month + "-" + day);
    $("#endCreatetime").attr("max", year + "-" + month + "-" + day);
  })
</script>

</html>


