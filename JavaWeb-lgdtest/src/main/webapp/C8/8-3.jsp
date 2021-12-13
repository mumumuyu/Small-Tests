<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/3
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>8-3</title>
</head>
<body>
购物车中内容为：
<HR>
    <%
        ArrayList books = new ArrayList();
        //显示购物车中的内容
        for (int i = 0; i < books.size(); i++) {
            String book = (String) books.get(i);
            out.println(book + "<BR>");
        }
    %>
</body>
</html>
