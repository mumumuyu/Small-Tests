<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/25
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>transcation</title>
</head>
<body>
<%
    String url = "jdbc:mysql://localhost:3306/lgdtest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    String username = "root";
    String password = "1328910";
    Connection connection = null;
    //1.加载驱动
    Class.forName("com.mysql.cj.jdbc.Driver");
//    System.out.println("Driver loaded");
    //连接数据库
    connection = DriverManager.getConnection(url, username, password);
//    System.out.println("Database connected");//Create a statement
    //3.开始事务
    try {
        connection.setAutoCommit(false);

        String sql = "update account set money = money-100 where name = 'lgd1'";
        connection.prepareStatement(sql).executeUpdate();
        //制造错误
//            int i = 1/0;

        String sql2 = "update account set money = money+100 where name = 'lgd2'";
        connection.prepareStatement(sql2).executeUpdate();
        connection.commit();
        out.println("lgd1 用户 的 money - 100 成功");
        out.println("lgd2 用户 的 money + 100 成功");
        out.println("更新成功@");
    } catch (Exception e) {
        //发生错误，就回滚
        try{
            connection.rollback();
        }catch (SQLException e1){
            e1.printStackTrace();
        }
    } finally {
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
%>
</body>
</html>
