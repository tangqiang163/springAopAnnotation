package com.example.springaop.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**

    1.切点定义可以是方法也可以是注解

    2.JoinPoint对象可以获取执行方法参数

    3.执行顺序
            前置通知
            方法执行
            后置通知
            afterReturning

 */
@Component
@Aspect
public class OtherWayAspect extends BaseAspect {
    @Pointcut("execution (* com.example.springaop.demo.test..Demo.play(..))")
    public void play(){
    }




    //@Around("play()")

 /*   *//**
     * 环绕通知
     *   - 注意会获取到参数ProceedingJoinPoint proceedingJoinPoint
     *
     *//*
    @Around(value = "play()")
    public void aopMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        System.out.println("充钱才能让你变得更强！ -马化腾");
        proceedingJoinPoint.proceed();
        System.out.println("秒boss！");
    }

    @Before("play()")
    public void before(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();

        for (Object obj:args) {
            System.out.println("obj:"+obj);
        }

        System.out.println("执行前置通知！");
    }


    @After("play()")
    public void after(){
        System.out.println("执行后置通知！");
    }


    @AfterReturning(pointcut = "@annotation(com.example.springaop.demo.annotion.TestAopAnnotion)",returning = "rt")
    public void afterReturing(Object rt){

        System.out.println("returnValue:"+rt);
        System.out.println("afterReturing！");
    }



    @AfterReturning(pointcut = "execution (* com.example.springaop.demo.test..Demo.play(..))",returning = "rt")
    public void afterDemo(Object rt){

        System.out.println("returnValue:"+rt);
        System.out.println("demo afterReturning！");
    }
*/





}
