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
	<title>5-15</title>
</head>
<body>
	<%
		String[] fav = request.getParameterValues("fav");
		out.println("爱好为:");
		for(int i=0;i<fav.length;i++){
			out.println(fav[i]);
		}
	%>
</body>
</html>

