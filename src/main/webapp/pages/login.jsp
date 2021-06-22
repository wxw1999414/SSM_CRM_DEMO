<%--
  Created by IntelliJ IDEA.
  User: Chaun
  Date: 2021/4/28
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style>
        #log{
            margin: auto;
            padding: 50px;
            position: relative;
            top: 100px;
            width: 400px;
            height: 200px;
            background-color: lightcyan;
            border: 1px solid black;
            line-height: 50px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div id="log">
        <form action="${pageContext.request.contextPath}/login" method="post">
            username:<input type="text" name="loginName" value="libai" ><br/>
            password:<input type="password" name="password" value="1234"><br />
            <input type="submit" value="登录">
            <input type="reset" value="重置">
        </form>
    </div>
</body>
</html>
