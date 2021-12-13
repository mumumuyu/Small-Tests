<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/9/17
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>2-16</title>
</head>
<body>
    欢迎注册<BR>
    <form>
        输入账号(文本框):<input type="text" ><BR>
        输入密码(密码框):<input type="password" ><BR>
        选择性别(单选按钮):
        <input type="radio" name="sex" checked>男
        <input type="radio" name="sex">女<br>
        选择爱好(复选框):
        <input type="checkbox">唱歌
        <input type="checkbox">跳舞
        <input type="checkbox" checked>打球
        <input type="checkbox">打游戏<br>
        <input type="submit" value="注册">
        <input type="reset" value="清空">
        <input type="button" value="普通按钮">
    </form>
</body>
</html>
