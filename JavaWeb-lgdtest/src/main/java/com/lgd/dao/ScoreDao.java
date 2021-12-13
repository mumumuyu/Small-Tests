package com.lgd.dao;

import com.lgd.pojo.Score;
import com.lgd.pojo.Vote;

import java.sql.*;
import java.util.ArrayList;

public class ScoreDao {

    Connection connection = null;

    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
    }

    public ArrayList getListByCid(String cid) throws SQLException, ClassNotFoundException {
        ArrayList scores = new ArrayList();
        try{
            init();
            String sql = "select score.id,student.name,score.type,score.scorenum from score,student where  score.id = student.id and score.cid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cid);
//            Statement preparedStatement = connection.createStatement();
            ResultSet rset = preparedStatement.executeQuery();
            while (rset.next()) {
                Score score = new Score();
                score.setId(rset.getString("id"));
                score.setType(rset.getString("type"));
                score.setName(rset.getString("name"));
                score.setScorenum(rset.getString("scorenum"));
                scores.add(score);
            }
            rset.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e){
        e.printStackTrace();
        }
        return scores;
    }

    public int updateScoes(String cid,String[] type,String[] id,String[] score) throws SQLException, ClassNotFoundException {
        int num = 0;
        init();
        String sql = "update score set scorenum = ? where id = ? and type = ? and cid = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < id.length; i++) {
            preparedStatement.setString(1, score[i]);
            preparedStatement.setString(2, id[i]);
            preparedStatement.setString(3, type[i]);
            preparedStatement.setString(4, cid);
            preparedStatement.executeUpdate();
            num++;
        }
        preparedStatement.close();
        connection.close();
        return num;
    }

}
