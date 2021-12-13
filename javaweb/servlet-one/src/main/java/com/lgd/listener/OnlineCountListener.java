package com.lgd.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计session，网站在线人数
public class OnlineCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sec = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) sec.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = new Integer(1);
        }else{
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }
        sec.setAttribute("OnlineCount",onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sec = se.getSession().getServletContext();
        Integer onlineCount = (Integer) sec.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = new Integer(0);
        }else{
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        sec.setAttribute("OnlineCount",onlineCount);
    }
}
