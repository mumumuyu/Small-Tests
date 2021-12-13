<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>11-4</title>
</head>
<body>
    <%
        session.setAttribute("msg","<b>这是<c:out>示例</b>");
    %>
    <c:out value="${msg}"></c:out><br>
    <c:out value="${msg}" escapeXml="false"></c:out><br>
</body>
</html>
