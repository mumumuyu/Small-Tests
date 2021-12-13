<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/8/18
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<html>
<head>
    <title>Success</title>
</head>
<body>
    Name <%= request.getParameter("name")%>
    Age <%= request.getParameter("age")%>
    <h2>Success!</h2>
    <%= new Date() %>
    <hr>
    <%
        int sum = 0;
        for (int i = 0;i<=100;i++){
            sum += i;
        }
        out.println("<h1>Sum为" + sum +"</h1>" );
    %>
    <%
        for (int i = 0;i<=4;i++){
    %>
    <h1>hello,world ${i}</h1>
    <%
        }
    %>
</body>
</html>
