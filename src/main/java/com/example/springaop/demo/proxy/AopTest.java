package com.example.springaop.demo.proxy;

/**
 * @Author: tangqiang
 * @Date: 2019/7/3 18:15
 * @Version 1.0
 */
public class AopTest {



    public static void testJDK(){

        JKDProxyFactory jkdProxyFactory = new JKDProxyFactory();


        PersonService personService = (PersonService) jkdProxyFactory.createProxyInstance(new PersionServiceImpl());


        personService.speak("talking.....!");


    }

    public static void main(String[] args){

        testJDK();


    }





}
