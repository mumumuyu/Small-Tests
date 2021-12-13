<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/9
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>11-8</title>
</head>
<body>
    <%
        HashMap hashMap = new HashMap();
        hashMap.put("name","rose");
        hashMap.put("age","10");
        session.setAttribute("hashMap",hashMap);
    %>
    <c:forEach items="${hashMap}" var="student">
        ${student.key},${student.value}<br>
    </c:forEach>
</body>
</html>
