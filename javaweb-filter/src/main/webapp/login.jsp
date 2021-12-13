<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/8/20
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>&lt;%&ndash;导入core包同理xml,sql,格式化&ndash;%&gt;--%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--    <hr>--%>
<%--    <form action="login.jsp" method="get">--%>
<%--        Username: <input type="text" name="username" value="${param.username}">--%>
<%--        <input type="submit" value="Login">--%>
<%--    </form>--%>
<%--    <c:if test="${param.username.equals('admin')}" var="isAdmin">--%>
<%--        <c:out value="管理员欢迎您！"></c:out>--%>
<%--    </c:if>--%>
<%--    <c:out value="${isAdmin}"></c:out>--%>
<form action="/servlet/login"   method="post">
    <input type="text"  name="username">
    <input type="submit">
</form>
</body>
</html>
