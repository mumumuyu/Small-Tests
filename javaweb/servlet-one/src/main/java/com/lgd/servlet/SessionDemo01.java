package com.lgd.servlet;

import com.lgd.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();

        session.setAttribute("names",new Person("测试",10));

        String sessionID = session.getId();

        if(session.isNew()){
            resp.getWriter().write("session创建成功,ID为" + sessionID);
        }else{
            resp.getWriter().write("session已存在,ID为" + sessionID);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
