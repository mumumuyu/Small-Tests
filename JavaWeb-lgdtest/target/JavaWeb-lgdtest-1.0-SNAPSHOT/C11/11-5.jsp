<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>11-5</title>
</head>
<body>
    <%
        session.setAttribute("core",5);
    %>
    <c:if test="${core >= 60}">及格</c:if>
    <c:if test="${core < 60}">不及格</c:if>
</body>
</html>
