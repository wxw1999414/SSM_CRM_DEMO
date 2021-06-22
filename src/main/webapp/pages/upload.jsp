<%@ page import="java.io.File" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chaun
  Date: 2021/5/24
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <h3>文件上传</h3>
    <form action="${pageContext.request.contextPath}/upload/uploadFiles" method="post" enctype="multipart/form-data">
        <input type="file" name="fileName" multiple="multiple"><br />
        <input type="submit" value="文件上传">
    </form>
<hr />
    <h3>文件显示:</h3>
    <ul>
        <c:forEach items="${files}" var="e">
        <li> <a href="${pageContext.request.contextPath}/upload/download?filePathName=${e} ">下载文件：${e}</a></li>
        </c:forEach>

        <%
            String appPath = application.getRealPath("/up_file");
            File f=new File(appPath);

            File[] fs = f.listFiles();
        %>

        <%
            for (File fi:fs){
        %>
        <a href="${pageContext.request.contextPath}/upload/download?fileName=<%=fi.getName() %>">下载文件：<%=fi.getName() %></a><br/>
        <%
            }
        %>
    </ul>

<hr />
    <h3>异步请求</h3>
    <hr/>
    姓名：<input type="text" id="name_id" value="">
    <input type="button" value="异步请求">
    <hr/>
    <script>
        $(function (){
            $(":button:first").click(function (){

                //异步请求
                $.ajax({
                    url:'${pageContext.request.contextPath}/upload/checking',
                    type:'post',
                    data:'checkName='+$('#name_id').val(),
                    dataType:'text',
                    success:function(ret_str){
                        //显示位置
                        alert("===>"+ret_str);
                        console.log(ret_str)
                    }
                });
            });
        });

    </script>
    <hr/>
</body>
</html>
