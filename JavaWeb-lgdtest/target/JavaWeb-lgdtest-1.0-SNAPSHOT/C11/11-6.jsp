<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>11-6</title>
</head>
<body>
    <%
        session.setAttribute("score",5);
    %>
    <c:choose>
        <c:when test="${score>=60}">及格</c:when>
        <c:when test="${score< 60}">不及格</c:when>
    </c:choose>
</body>
</html>
