<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/25
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insertForm</title>
</head>
<body>
<form action="insert2(3).jsp" method="post">
输入学号:<input type="text" name="id"><br>
输入姓名:<input type="text" name="name"><br>
选择性别:<select name = "sex">
    <option value="男">男</option>
    <option value="女">女</option>
    <input type="submit" value="提交">
</select>
</form>
</body>
</html>
