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
	<title>5-21</title>
</head>
<body>
	请您输入张海的语文成绩(可修改)：
    	<form <%--action="目标页面路径"--%> method="post">
			 输入成绩：<input type="text" name="score" >
			<input type="hidden" name="stuno" value="0015" >
			<input type="hidden" name="courseno" value="YW" >
			<input type="submit" value="修改">
		</form>
</body>
</html>
