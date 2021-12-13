<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/24
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
	<title>4-9</title>
</head>
	<body>
		<% //此页面会会处理pageTest2.jsp抛出的异常
		    //友好地显示错误信息
			out.println("网页出现数学运算异常!");
		%>
	</body>
</html>
