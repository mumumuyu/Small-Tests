<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/8
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>11-1</title>
</head>
<body>
    <%
        application.setAttribute("applicationMsg","Welcome to applicationMsg");
        session.setAttribute("sessionMsg","Welcome to sessionMsg");
    %>
    application中的内容为: ${applicationScope.applicationMsg}<br>
    application中的内容为: ${applicationMsg}<br>
    session中的内容为: ${sessionScope.sessionMsg}<br>
    session中的内容为: ${sessionMsg}<br>
</body>
</html>
