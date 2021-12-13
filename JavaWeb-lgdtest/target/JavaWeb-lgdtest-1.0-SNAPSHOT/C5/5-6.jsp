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
	<title>5-6</title>
</head>
<body>
	请您输入自己的信息进行注册
	<form action="5-7.jsp" method="post">
		请您输入账号：<input name="account" type="text"><BR>
		请您输入密码：<input name="password" type="password"><BR>
		请您输入个人信息：<BR>
		<textarea name="info" rows="5" cols="30"></textarea>
		<input type="submit" value="注册">
	</form>
</body>
</html>

