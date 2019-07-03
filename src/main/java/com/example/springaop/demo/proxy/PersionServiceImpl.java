package com.example.springaop.demo.proxy;

/**
 * @Author: tangqiang
 * @Date: 2019/7/3 17:46
 * @Version 1.0
 */
public class PersionServiceImpl implements PersonService {


    @Override
    public void speak(String somethings) {

        System.out.println("say:"+somethings);

    }
}
