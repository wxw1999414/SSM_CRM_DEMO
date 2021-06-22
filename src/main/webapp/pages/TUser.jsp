<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页查询</title>
</head>

<hr />
    查询条件：<br />
    <input type="text" name="">
<hr />
<table>
    <tr>
        <th width="50px">编号</th>
        <th width="100px">登录名</th>
        <th width="100px">昵称</th>
        <th width="100px">职位</th>
        <th width="200px">电话</th>
        <th width="120px">上级【姓名】</th>
        <th width="50px">状态</th>
        <th width="300px">创建时间</th>
        <th width="200px">备注</th>

    </tr>
    <c:forEach items="${pm.list}" var="ite">
    <tr style="text-align: center">
        <td width="50px">${ite.rid}</td>
        <td width="100px">${ite.loginName}</td>
        <td width="100px">${ite.uName}</td>
        <td width="100px">${ite.uPost}</td>
        <td width="200px">${ite.uPhone}</td>
        <td width="120px">${ite.uParentId}</td>
        <td width="50px">${ite.status}</td>
        <td width="300px">${ite.createTime}</td>
        <td width="200px">${ite.uRemark}</td>
    </tr>
    </c:forEach>
    <hr />
    <tr>
        <td colspan="4">
            当前页：${pm.nowPage}/总页数：${pm.sumPage}&nbsp;&nbsp;&nbsp;
        </td>
        <td colspan="5">
            <a href="page_queryPage.action?pm.nowPage=1&pm.size=5">首页</a>

        &nbsp;&nbsp;&nbsp;
            <a href="page_queryPage.action?pm.nowPage=${pm.nowPage==1?1:(pm.nowPage-1)}&pm.size=5">上一页</a>
        &nbsp;&nbsp;&nbsp;

            <a href="page_queryPage.action?pm.nowPage=${pm.nowPage==pm.sumPage?pm.sumPage:(pm.nowPage+1)}&pm.size=5">下一页</a>

        &nbsp;&nbsp;&nbsp;
            <a href="page_queryPage.action?pm.nowPage=${pm.sumPage}&pm.size=5">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
