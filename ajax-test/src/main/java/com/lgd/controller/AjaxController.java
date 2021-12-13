package com.lgd.controller;

import com.lgd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

    @GetMapping("/ajax2")
    public String index() {
        return "ajax2";
    }

    @GetMapping("/ajax")
    public String index2() {
        return "ajax";
    }

    @GetMapping("/ajaxtest")
    public String index3() {
        return "ajaxtest";
    }

    @GetMapping("/index")
    public String index4() {
        return "index";
    }

    //第一种方式，服务器要返回一个字符串，直接使用response
    @RequestMapping("/a1")
    public void ajax(String name, HttpServletResponse response) throws IOException {
        if("admin".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    @ResponseBody
    public List<User> ajax2(){
        List<User> list =new ArrayList<>();
        User user1 =new User("lgd",1,"男");
        User user2=new User("lgd",1,"男");
        list.add(user1);
        list.add(user2);
        return list; //由于加了@ResponseBody注解，他会返回一个字符串
    }

    @RequestMapping("/a3")
    @ResponseBody
    public String ajax3(String name,String pwd){
        String msg="";
        if(name!=null){
            if("admin".equals(name)){
                msg="ok";
            }else{
                msg="用户名有误";
            }
        }
        if(pwd != null){
            if("123456".equals(pwd)){
                msg="ok";
            }else{
                msg="密码输入有误";
            }

        }
        return msg;
    }

    @RequestMapping("/a4")
    @ResponseBody
    public String ajax4() {
        return "[\n" +
                "    {\n" +
                "        \"name\":lgd,\n" +
                "        \"age\":1,\n" +
                "        \"sex\":male\n" +
                "    }\n" +
                "]";
    }

    @RequestMapping("/a5")
    @ResponseBody
    public String ajax4(String name,String pwd){
        String msg="";
        if(name!=null){
            if("admin".equals(name)){
                msg="ok";
            }else{
                msg="用户名有误";
            }
        }
        if(pwd != null){
            if("123456".equals(pwd)){
                msg="ok";
            }else{
                msg="密码输入有误";
            }

        }
        return msg;
    }
}
