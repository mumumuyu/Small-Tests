<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/25
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insert 1</title>
</head>
<body>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
        Statement stmt = connection.createStatement();    //Create a statement
        String sql = "insert into student(id, name, sex) values (?,?,?);";    //insert
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "003");
        preparedStatement.setString(2, "lgd");
        preparedStatement.setString(3, "男");
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            out.println("成功添加" + i + "行");
        }
        preparedStatement.close();
        stmt.close();
        connection.close();}
    catch (SQLException e){
            e.printStackTrace();
        }
%>
</body>
</html>
