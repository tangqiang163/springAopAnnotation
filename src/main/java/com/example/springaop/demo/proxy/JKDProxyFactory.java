package com.example.springaop.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: tangqiang
 * @Date: 2019/7/3 18:02
 * @Version 1.0
 */
public class JKDProxyFactory implements InvocationHandler {

    private Object targetObj;

    public Object createProxyInstance(Object targetObject){
        this.targetObj = targetObject;

        // 返回代理的对象
        return Proxy.newProxyInstance(this.targetObj.getClass().getClassLoader(),this.targetObj.getClass().getInterfaces(),this);
    }


    /**
     * 代理的具体处理逻辑
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        try {
            // 前置通知
            System.out.println("hello哇 树哥！");

            method.invoke(this.targetObj,args);

            // 后置通知
            System.out.println("bay bay! 树哥！");

        }catch (Exception ex){

            // 异常通知
            System.out.println("异常通知！");
            ex.printStackTrace();

        }finally {

        }


        return result;
    }
}
