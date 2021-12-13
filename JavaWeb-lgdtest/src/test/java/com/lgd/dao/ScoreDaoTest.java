package com.lgd.dao;

import com.lgd.pojo.Student;
import com.lgd.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDaoTest {
    @Test
    public void selectTest() throws SQLException, ClassNotFoundException {
        ScoreDao scoreDao = new ScoreDao();
        ArrayList scores = scoreDao.getListByCid("1");
        for (int i = 0; i < scores.size(); i++) {
            System.out.println(scores.get(i));
        }
    }
    @Test
    public void updateTest() throws SQLException, ClassNotFoundException {
        ScoreDao scoreDao = new ScoreDao();
        int scores = scoreDao.updateScoes("1", new String[]{"期末"}, new String[]{"001"}, new String[]{"100"});
            System.out.println(scores);
    }
}
