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
    <title>8-5</title>
</head>
<body>
购物车中内容为：
<HR>
    <%
        //从购物车中取出books
        ArrayList books = (ArrayList)session.getAttribute("books");
        //遍历books
        for(int i=0;i<books.size();i++){
            String book = (String)books.get(i);
            out.println(book + "<BR>");
        }
    %>
</body>
</html>
