package com.lgd.test;

import org.junit.Test;

import java.sql.*;
import java.util.Date;

public class jdbctest2 {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/lgdtest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        String username = "root";
        String password = "1328910";
        Connection connection = null;
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            //连接数据库
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");//Create a statement
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
            System.out.println("更新成功@");
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
    }
}
