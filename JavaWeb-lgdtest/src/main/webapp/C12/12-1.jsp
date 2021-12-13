<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/9
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>12-1</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
<body>
    <script language="JavaScript">
        $("#bto").click(function showInfo(){
            $.ajax({
                url:"${pageContext.request.contextPath}/C12/12-1.jsp",
                type: "Get",
                data:{},
                success:function () {
                        location.replace('${pageContext.request.contextPath}/C12/12-1(1).jsp');
                }
            });
        })
    </script>
        欢迎来到本系统.<hr>
    <input type="button" value="显示本公司信息" id="bto">
</body>
</html>
