<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/26
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.lgd.pojo.Student" %>
<html>
<head>
    <title>useBean</title>
</head>
<body>
    <jsp:useBean id="student" class="com.lgd.pojo.Student"></jsp:useBean>
<%--    <%--%>
<%--        student.setName("lgd");--%>
<%--    %>--%>
    <jsp:setProperty property="name" name="student" value="lgd"></jsp:setProperty>
    <%= student.getName() %>
</body>
</html>
