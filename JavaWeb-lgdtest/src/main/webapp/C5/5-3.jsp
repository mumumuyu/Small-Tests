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
	<title>5-3</title>
</head>
<body>
	<%
		String stuname = request.getParameter("stuname");
		out.println("输入的查询关键字为:" + stuname);
	%>
</body>
</html>


