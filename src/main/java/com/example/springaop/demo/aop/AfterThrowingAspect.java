package com.example.springaop.demo.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP的AfterThrowing处理虽然可以对目标方法的异常进行处理，
 * 但这种处理与直接使用catch捕捉不同，catch捕捉意味着完全处理该异常，
 * 如果catch块中没有重新抛出新的异常，则该方法可能正常结束；
 * 而AfterThrowing处理虽然处理了该异常，但它不能完全处理异常，该异常依然会传播到上一级调用者，即JVM。
 */
@Component
@Aspect
public class AfterThrowingAspect extends BaseAspect {



    @AfterThrowing(pointcut = "@annotation(com.example.springaop.demo.annotion.TestAopAnnotion)",throwing = "ex")
    public void afterThrow(Throwable ex){

        System.out.println("ex:");

    }


}
