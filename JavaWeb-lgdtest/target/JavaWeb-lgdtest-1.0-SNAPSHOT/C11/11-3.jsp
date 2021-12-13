<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>11-3</title>
</head>
<body>
    <%
        session.setAttribute("msg","这是<c:out>示例");
    %>
    <c:out value="${msg}"></c:out>
</body>
</html>
