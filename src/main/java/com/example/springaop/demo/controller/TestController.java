package com.example.springaop.demo.controller;

import com.example.springaop.demo.annotion.TestAopAnnotion;
import com.example.springaop.demo.test.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 *  tangqiang
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Demo demo;


    @RequestMapping("/testaop")
    @TestAopAnnotion
    public String testAop(String test){

        // 通过requestContextHolder对象的获取请求对象的属性值
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        String sessionId = requestAttributes.getSessionId();


        HttpServletRequest request = requestAttributes.getRequest();

        System.out.println(sessionId);

/*
        List list = new ArrayList<>();

        list.get(10);
*/


        String str =  demo.play("uzi","lol");

        return "ok";
    }



}
