<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/24
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>4-6</title>
</head>
<body>
<%
	//获得number
	String str = request.getParameter("number");
	int number = Integer.parseInt(str);
 %>
 该数字的立方为：<%=number*number*number %><HR>
</body>
</html>
