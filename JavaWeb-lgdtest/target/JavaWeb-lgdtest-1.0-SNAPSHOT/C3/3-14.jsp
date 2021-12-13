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
    <title>3-14</title>
</head>
<body>
欢迎您登录，3秒钟转到首页...
<script type="text/javascript">
    window.setTimeout("toIndex()","3000");
    function toIndex(){
        window.location.href = "images/test.jpg";
    }
</script>
</body>
</html>
