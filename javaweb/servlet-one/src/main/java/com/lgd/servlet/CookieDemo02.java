package com.lgd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            out.write("您上次访问的时间是:");
            for (int i = 0; i<cookies.length;i++){
                Cookie cookie = cookies[i];
                if(cookie.getName().equals("lastnames")){
                    out.write(URLDecoder.decode(cookie.getValue(),"GBK"));//解码
                }
            }
        }else{
            System.out.println("您是第一次访问");
        }
        Cookie cookie = new Cookie("lastnames", URLEncoder.encode("测试","GBK"));//编码
        resp.addCookie(cookie);
        //cokkie.setMaxage(24*60*60);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
