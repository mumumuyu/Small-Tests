package com.lgd.servlet.vote;

import com.lgd.dao.VoteDao;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VotesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("ids");
        VoteDao voteDao = new VoteDao();
        int num = voteDao.updateVote(ids);
        System.out.println("成功给"+num+"位老师投票");
        PrintWriter out = resp.getWriter();
        out.print("<script>window.location.href='"+getServletContext().getContextPath()+"/C17/display.jsp'</script>");
    }
}
