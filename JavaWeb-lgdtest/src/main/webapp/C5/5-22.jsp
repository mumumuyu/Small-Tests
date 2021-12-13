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
	<title>5-22</title>
</head>
<body>
	欢迎登录学生管理系统
	<script type="text/javascript">
		function validate(){
			if(loginForm.account.value==""){
				alert("账号不能为空!");
				return;
			}
			if(loginForm.password.value==""){
				alert("密码不能为空!");
				return;
			}
			loginForm.submit();
		}
	</script>
	<form name="loginForm" action="target.jsp " method="post">
		请您输入账号：<input name="account" type="text"><BR>
		请您输入密码：<input name="password" type="password"><BR>
		<input type="button" value="登录" onClick="validate()">	
	</form>
</body>
</html>
