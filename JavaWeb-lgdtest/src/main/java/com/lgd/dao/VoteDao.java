package com.lgd.dao;

import com.lgd.pojo.Vote;

import java.sql.*;
import java.util.ArrayList;

public class VoteDao {

    Connection connection = null;

    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
    }

    public ArrayList getAllVote() throws Exception {
        ArrayList votes = new ArrayList();
        try {
            init();
            Statement stmt = connection.createStatement();
            String sql = "select * from vote";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Vote vote = new Vote();
                vote.setId(rset.getString("id"));
                vote.setName(rset.getString("name"));
                vote.setVotenum(rset.getInt("vote"));
                votes.add(vote);
            }
            rset.close();
            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return votes;
    }

    public int updateVote(String[] ids) throws SQLException, ClassNotFoundException {
        int num = 0;
        init();
        String sql = "update vote set vote = vote + 1 where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < ids.length; i++) {
            preparedStatement.setString(1, ids[i]);
            preparedStatement.executeUpdate();
            num++;
        }
        preparedStatement.close();
        connection.close();
        return num;
    }

}
