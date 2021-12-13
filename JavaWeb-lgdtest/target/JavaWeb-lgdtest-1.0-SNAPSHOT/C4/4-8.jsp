<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/24
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="4-9.jsp"%>
<html>
<head>
	<title>4-8</title>
</head>
	<body>
		<%//此页面会向pageTest2_error抛出异常，让其来处理
			int num1=10;
			int num2=0;
			int num3=num1/num2;
		%>
	</body>
</html>
