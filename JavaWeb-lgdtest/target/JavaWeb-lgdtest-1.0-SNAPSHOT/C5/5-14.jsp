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
	<title>5-14</title>
</head>
<body>
	请您输入自己的信息进行注册  
	<form action="5-15.jsp" method="post">
		请您选择您的爱好：<BR>
		<select name="fav" multiple>
			<option value="sing">唱歌</option>
			<option value="dance">跳舞</option>
			<option value="ball">打球</option>
			<option value="game">打游戏</option>
		</select>
		<input type="submit" value="注册">
	</form>
</body>
</html>

