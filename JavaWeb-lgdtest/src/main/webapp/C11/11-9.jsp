<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/9
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>11-9</title>
</head>
<body>
    <%
        session.setAttribute("msg","这是一个@forToknens@的示例");
    %>
    <c:forTokens items="${msg}" delims="@">
        ${msg}<br>
    </c:forTokens>
</body>
</html>
