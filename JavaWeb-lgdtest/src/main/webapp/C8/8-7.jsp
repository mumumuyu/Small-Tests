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
    <title>8-7</title>
</head>
<body>
    <form action="8-7.jsp" method="post">
        请您输入书本：<input name="book" type="text">
        <input type="submit" value="添加到购物车">
    </form>
    <HR>
    <%
        //从session获取books，如果为空则实例化
        ArrayList books = (ArrayList)session.getAttribute("books");
        if(books==null){
            books = new ArrayList();
            session.setAttribute("books",books);
        }
        //获得书名
        String book = request.getParameter("book");
        if(book!=null){
            book = new String(book.getBytes("ISO-8859-1"));
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
