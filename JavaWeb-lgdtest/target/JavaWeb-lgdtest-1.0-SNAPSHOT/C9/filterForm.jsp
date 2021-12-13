<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/26
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>filterForm</title>
</head>
<body>
    <form action="/servlet/dealwith" method="post">
        请输入学生信息的模糊资料：<input type="text" name="name"><br>
        <input type="submit" value="查询">
    </form>
</body>
</html>
