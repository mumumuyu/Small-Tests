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
	<title>5-9</title>
</head>
<body>
	<%
		String sex = request.getParameter("sex");
		out.println("性别为:" + sex);
	%>
</body>
</html>

