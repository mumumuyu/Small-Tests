<%@ page language="java" pageEncoding="gb2312"%>
<html>
	<body>
	��ӭ��¼��ϵͳ<BR>
	<form action="/Prj13/servlets/ValidateServlet" method="post">
		���������˺�:<input type="text" name="account" /><BR>
		������������: <input type="password" name="password" /><BR>
		��֤��:<input type="text" name="code" size="10">
		<!-- ����֤�뵱��ͼƬ���� -->
		<img border=0 src="validate.jsp">
		<input type="submit" value="��¼">	
	</form>		
	</body>
</html>
