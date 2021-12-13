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
    <title>3-10</title>
</head>
<body>
<script type="text/javascript">
    function fun(){
        document.title = "新的标题"; //设置网页标题
        window.alert(document.location);//得到当前网页的地址
    }
</script>
<input type="button" onclick="fun()" value="按钮">
</body>
</html>
