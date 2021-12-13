package com.lgd.servlet.score;

import com.lgd.dao.ScoreDao;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class updateScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScoreDao scoreDao = new ScoreDao();
        String[] id = req.getParameterValues("id");
        String[] type = req.getParameterValues("type");
        String[] score = req.getParameterValues("score");
        String cid = req.getParameter("cid");
        int num = scoreDao.updateScoes(cid,type,id,score);
        System.out.println("成功修改"+num+"位学生成绩");
        PrintWriter out = resp.getWriter();
        out.print("<script>window.location.href='"+getServletContext().getContextPath()+"/C17/scoreForm.jsp'</script>");
    }
}
