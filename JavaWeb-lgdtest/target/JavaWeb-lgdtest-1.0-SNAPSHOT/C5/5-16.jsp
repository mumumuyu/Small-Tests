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
	<title>5-16</title>
</head>
<body>
	请您输入自己的信息进行注册  
	<form action="5-17.jsp" method="post">
		请您输入您的电话号码(最多4个)：<BR>
		<%for(int i=1;i<=4;i++){ %>
		    号码<%=i %>：<input name="phone" type="text"><BR>
		<%} %>
		<input type="submit" value="注册">
	</form>
</body>
</html>

