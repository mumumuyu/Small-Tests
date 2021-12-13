<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/25
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select1</title>
</head>
<body>
<%
    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
//    System.out.println("Driver loaded");
    Connection connection = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
//    System.out.println("Database connected");//Create a statement
    Statement stmt = connection.createStatement();
    String sql = "select id,name from student where sex = '女'";
        ResultSet rset = stmt.executeQuery(sql);
        while (rset.next()){
            out.println("id=" + rset.getString(1));
            out.println("name=" + rset.getString(2));
            out.println("sex=" + rset.getString(3));
            String id = rset.getString("id");
            String name = rset.getString("name");
            out.println(id + " " + name + "<br>");
        }
        rset.close();
        stmt.close();
        connection.close();}
    catch (SQLException e){
    e.printStackTrace();
    }
%>
</body>
</html>
