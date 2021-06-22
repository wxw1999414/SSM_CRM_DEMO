<%--
  Created by IntelliJ IDEA.
  User: Chaun
  Date: 2021/4/28
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h3>登录成功,当前账户信息：</h3>
<br />
登录名：${loginUser.loginName}<br />
姓名：${loginUser.uName}<br />
职务：${loginUser.uPost}<br />
电话：${loginUser.uPhone}<br />
roles:${loginUser.tRole}
</body>
</html>
