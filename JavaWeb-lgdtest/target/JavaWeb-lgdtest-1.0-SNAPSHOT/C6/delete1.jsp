<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/25
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete1</title>
</head>
<body>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
        Statement stmt = connection.createStatement();    //Create a statement
        String sql = "delete from student where id = '003';";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            out.println("成功删除" + i + "行");
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
