package com.lgd.controller;

import com.lgd.pojo.RequestVOTest;
import com.lgd.pojo.RequestVOTest2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @author: LGD
 * @date:2022/11/10 14:54
 */
@RestController
@Slf4j
public class TestController {


    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String test(@RequestParam String a){
        return "hello"+a;
    }

    @RequestMapping(value = "/test2", method =  RequestMethod.POST)
    public String test2(@RequestParam("list") String[] a){
        System.out.println(a.length);
        for (String b:a){
            System.out.println(b);
        }
/*        for (RequestVOTest2 requestVOTest:a.getRequestVOTest2List()){
            System.out.println(requestVOTest.getA());
            System.out.println(requestVOTest.getB());
        }*/
        return "1";
    }


}
