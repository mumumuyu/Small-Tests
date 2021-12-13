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
    <title>8-4</title>
</head>
<body>
    <%
        ArrayList books = new ArrayList();
        //向books中添加
        books.add("三国演义");
        books.add("西游记");
        books.add("水浒传");
        //将books放入session
        session.setAttribute("books",books);
    %>
<a href=" 8-5.jsp">查看购物车</a>
</body>
</html>
