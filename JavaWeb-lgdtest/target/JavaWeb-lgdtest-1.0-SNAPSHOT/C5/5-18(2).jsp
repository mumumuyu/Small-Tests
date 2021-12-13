<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>5-18(2)</title>
</head>
<body>
    <%
        String number = request.getParameter("number");
        int num = Integer.parseInt(number);
    %>
    您输入的数字的立方为:<%=num * num * num%><hr>
</body>
</html>
