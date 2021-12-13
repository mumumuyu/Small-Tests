<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/9/17
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>3-12</title>
</head>
<body>
<script type="text/javascript">
    function validate(){
        //得到这两个文本框的内容
        account = document.loginForm.account.value;
        password = document.loginForm.password.value;
        if(account==""){
            alert("账号不能为空");
            document.loginForm.account.focus();//聚焦
            return;
        }
        else if(password==""){
            alert("密码不能为空");
            document.loginForm.password.focus();
            return;
        }
        document.loginForm.submit();
    }
</script>
欢迎您登录:
<form name="loginForm">
    输入账号:<input name="account" type="text"><BR>
    输入密码:<input name="password"  type="password"><BR>
    <input type="button" onclick="validate()" value="登录">
</form>
</body>
</html>
