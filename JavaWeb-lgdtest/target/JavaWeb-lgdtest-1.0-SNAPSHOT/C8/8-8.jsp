<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/3
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>8-8</title>
</head>
<body>
    <%
        String id = session.getId();
        out.println("当前sessionId为:" + id);
    %>
    <HR>
    <a href="8-9.jsp">到达下一个页面</a>
</body>
</html>
