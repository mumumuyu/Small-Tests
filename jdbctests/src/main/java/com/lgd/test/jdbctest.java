package com.lgd.test;

import java.sql.*;

public class jdbctest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/lgdtest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
        System.out.println("Database connected");//Create a statement
        Statement stmt = connection.createStatement();
        //insert
        String sql = "insert into users(id, name, psw, time) values (?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"lgd");
        preparedStatement.setString(3,"123456");
        preparedStatement.setDate(4,new Date(new java.util.Date().getTime()));
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("插入成功@");
        }
        preparedStatement.close();

        //delete
//        String sql = "delete from users where id = '1';";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        int i = preparedStatement.executeUpdate();
//        if(i>0){
//            System.out.println("删除成功@");
//        }
//        preparedStatement.close();

        //query
//        String sql = "select * from users";
//        ResultSet rset = stmt.executeQuery(sql);
//        while (rset.next()){
//            System.out.println("id="+rset.getString(1));
//            System.out.println("name="+rset.getString(2));
//            System.out.println("psw="+rset.getString(3));
//            System.out.println("time="+rset.getString(4));
//        }
//        rset.close();

        stmt.close();
        connection.close();
    }
}
