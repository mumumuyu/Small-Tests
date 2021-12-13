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
	<title>5-5</title>
</head>
<body>
	<%
		String password = request.getParameter("password");
		out.println("密码为:" + password);
	%>
</body>
</html>


