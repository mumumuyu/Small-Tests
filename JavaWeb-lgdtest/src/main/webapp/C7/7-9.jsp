<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/2
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>7-9</title>
</head>
<body>
    <%
        //定义一个变量：
        String str = "12";
        int number = Integer.parseInt(str);
    %>
    该数字的平方为：<%=number*number %><HR>
    <%
        //将str存入Cookie
        Cookie cookie = new Cookie("number",str);
        //设置Cookie的存活期为600秒
        cookie.setMaxAge(600);
        //将Cookie保存于客户端
        response.addCookie(cookie);
    %>
    <a href="7-10.jsp">到达p2</a>
</body>
</html>
