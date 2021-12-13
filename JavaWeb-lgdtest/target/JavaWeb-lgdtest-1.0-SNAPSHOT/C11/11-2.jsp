<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.lgd.pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>11-2</title>
</head>
<body>
    <%
        Student student = new Student();
        student.setId("001");
        student.setName("lgd");
        session.setAttribute("student",student);
    %>
    学号:${student.id}<br>
    姓名:${student.name}<br>
</body>
</html>
