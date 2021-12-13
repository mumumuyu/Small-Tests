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
	<title>5-17</title>
</head>
<body>
	<%
		String[] phone = request.getParameterValues("phone");
		out.println("号码为:");
		for(int i=0;i<phone.length;i++){
			out.println(phone[i]);
		}
	%>
</body>
</html>