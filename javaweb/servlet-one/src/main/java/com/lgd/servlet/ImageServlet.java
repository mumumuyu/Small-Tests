package com.lgd.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
//验证码生成
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器三秒刷新一次
//        resp.setHeader("refresh","3");
        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80,30, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D pen = (Graphics2D) image.getGraphics();
        //设置背景
        pen.setColor(Color.BLACK);
        pen.fillRect(0,0,80,30);
        //图片写数据
        pen.setColor(Color.WHITE);
        pen.setFont(new Font(null,Font.BOLD,30));
        pen.drawString(YZM(),0,30);
        //告诉浏览器以图片形式打开
        resp.setContentType("image/jpg");
        //不让浏览器不缓存
        resp.setDateHeader("sxpires",-1);
        resp.setHeader("Pragma","no-cache");
        //图片给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
    //生成验证码
    private String YZM(){
        char[]Code= {'3','4','5','6','7','8','9',
                'A','B','C','D','E','F','G','H','G',
                'K','L','M','N','P','Q','R','S','T','U','V',
                'W','X','Y','a','b','c',
                'd','e','f','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y'};
        boolean []flags=new boolean[Code.length];
        int xuhao;
        char []Yzm=new char[4];
        for (int i = 0; i < Yzm.length; i++) {
            do {
                xuhao=(int)(Math.random()*Code.length);
            }while(flags[xuhao]==true);
            Yzm[i]=Code[xuhao];
            flags[xuhao]=true;
        }
        return String.valueOf(Yzm);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
