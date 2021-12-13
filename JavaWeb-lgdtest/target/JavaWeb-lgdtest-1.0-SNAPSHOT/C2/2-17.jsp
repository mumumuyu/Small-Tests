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
    <title>2-17</title>
</head>
<body>
<form>
    填写个人信息：<BR>
    <textarea rows="5" cols="20"></textarea><BR>
    选择家乡(下拉菜单)：
    <select>
        <option>上海</option>
        <option selected>北京</option>
        <option>纽约</option>
    </select><BR>
    选择家乡(下拉列表，可以多选)：<BR>
    <select size="5" multiple>
        <option>上海</option>
        <option selected>北京</option>
        <option>纽约</option>
    </select><BR>
</form>
</body>
</html>
