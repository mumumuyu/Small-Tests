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
    <title>8-1</title>
</head>
<body>
    <%
        ArrayList books = new ArrayList();
        //购物车中添加
        books.add("三国演义");
        books.add("西游记");
        books.add("水浒传");
    %>
    购物车中内容为：
    <HR>
    <%
        //显示购物车中的内容
        for (int i = 0; i < books.size(); i++) {
            String book = (String) books.get(i);
            out.println(book + "<BR>");
        }
    %>
</body>
</html>
