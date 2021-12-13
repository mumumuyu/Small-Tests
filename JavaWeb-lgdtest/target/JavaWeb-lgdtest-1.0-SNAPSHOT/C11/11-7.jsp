<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>11-7</title>
</head>
<body>
    <%
        ArrayList al = new ArrayList();
        al.add("张三");
        al.add("李四");
        al.add("lgd");
        session.setAttribute("all",al);
    %>
    <c:forEach items="all" var="student">
        ${student}
    </c:forEach>
</body>
</html>
