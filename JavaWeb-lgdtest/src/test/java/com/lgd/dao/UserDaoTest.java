package com.lgd.dao;

import com.lgd.pojo.Student;
import com.lgd.pojo.User;
import com.lgd.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void studentSelectByPrimaryKey() {
        SqlSession sqlSession = MybatisUtils.getsqlSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByPrimaryKey("001");
            System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void userSelectByPrimaryKey() {
        SqlSession sqlSession = MybatisUtils.getsqlSession();

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById("001");
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getsqlSession();

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        int user = userMapper.addUser(new User("002","lgd","123456"));
        if(user>0) {
            System.out.println("success!");
        }else{
            System.out.println("failed");
        }
        sqlSession.commit();//Ç§Íò±ğÍüÁË£¡£¡£¡
        sqlSession.close();
    }

}
