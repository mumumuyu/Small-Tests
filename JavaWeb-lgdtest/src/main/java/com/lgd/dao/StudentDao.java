package com.lgd.dao;

import com.lgd.pojo.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    public ArrayList queryAllStudents() throws Exception {
        Connection connection = null;
        ArrayList students = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
            System.out.println("Database connected");//Create a statement
            Statement stmt = connection.createStatement();
            String sql = "select id,name from student";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Student student = new Student();
                student.setId(rset.getString("id"));
                student.setName(rset.getString("name"));
                students.add(student);
            }
            rset.close();
            stmt.close();
            connection.close();
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
        return students;
    }
}
