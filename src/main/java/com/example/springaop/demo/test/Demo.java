package com.example.springaop.demo.test;

import org.springframework.stereotype.Component;

@Component
public class Demo {

    public String play(String name,String gameName){

        System.out.println("name:"+name);

        System.out.println("gameName:"+gameName);

        return "o98k";

    }



}
