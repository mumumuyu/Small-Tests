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
    <title>5-18</title>
</head>
<body>
<%
	//定义一个变量：
	String str = "12";
	int number = Integer.parseInt(str);
 %>
 该数字的平方为：<%=number*number %><HR>
 <form action="5-18(2).jsp" method="get">
    <input type="text" name="number" value="<%=number %>">
 	<input type="submit" value="到达p2">
 </form>
</body>
</html>
