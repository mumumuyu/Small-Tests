<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/25
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>5-11</title>
</head>
<body>
	<%
		String home = request.getParameter("home");
		out.println("家乡为:" + home);
	%>
</body>
</html>

