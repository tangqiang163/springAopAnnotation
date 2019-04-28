package com.example.springaop.demo.controller;

import com.example.springaop.demo.annotion.TestAopAnnotion;
import com.example.springaop.demo.test.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Demo demo;


    @RequestMapping("/testaop")
    @TestAopAnnotion
    public String testAop(String test){

        List list = new ArrayList<>();

        list.get(10);


        String str =  demo.play("uzi","lol");

        return "ok";
    }



}
