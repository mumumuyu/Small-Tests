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
	<title>4-5</title>
</head>
<body>
<%
	//定义一个变量：
	String str = "12";
	int number = Integer.parseInt(str);
 %>
 该数字的平方为：<%=number*number %><HR>
<a href="4-6.jsp?number=<%=number %>">到达p2</a>
</body>
</html>