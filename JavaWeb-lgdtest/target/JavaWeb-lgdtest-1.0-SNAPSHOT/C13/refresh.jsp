<%@ page language="java" pageEncoding="gb2312"%>
<html>
	<body>
	<script type="text/javascript">
		function refresh(){
			loginForm.imgValidate.src = "validate.jsp?id=" + Math.random();
		}
	</script>
	��ӭ��¼��ϵͳ<BR>
	<form name="loginForm" action="/Prj13/servlets/ValidateServlet" method="post">
		���������˺�:<input type="text" name="account" /><BR>
		������������: <input type="password" name="password" /><BR>
		��������֤��:<input type="text" name="code" size="10">
		<img name="imgValidate" src="validate.jsp" onclick="refresh()"><BR>
		<input type="submit" value="��¼">	
	</form>		
	</body>
</html>
