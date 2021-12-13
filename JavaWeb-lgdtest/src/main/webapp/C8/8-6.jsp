<%@ page import="java.util.ArrayList" %>
<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/3
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>8-6</title>
</head>
<body>
    <form action="8-6.jsp" method="post">
        请您输入书本：<input name="book" type="text">
        <input type="submit" value="添加到购物车">
    </form>
    <HR>
    <%
        //向session中放入一个集合对象
        ArrayList books = new ArrayList();
        session.setAttribute("books",books);
        //获得书名
        String book = request.getParameter("book");
        if(book!=null){
            book = new String(book.getBytes(StandardCharsets.ISO_8859_1));
            //将book加进去
            books.add(book);
        }
    %>
    购物车中的内容是：<BR>
    <%
        //遍历books
        for(int i=0;i<books.size();i++){
            out.println(books.get(i) + "<BR>");
        }
    %>
</body>
</html>
