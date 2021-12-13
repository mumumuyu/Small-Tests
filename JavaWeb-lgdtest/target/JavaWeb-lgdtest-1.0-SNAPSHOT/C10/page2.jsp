<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/26
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="com.lgd.pojo.Student" scope="page"></jsp:useBean>
<html>
<head>
    <title>page2</title>
</head>
<body>
学生姓名：<jsp:getProperty name="student" property="name"/>
</body>
</html>
