package com.example.springaop.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class TestAopAspect extends BaseAspect {


    @Around("@annotation(com.example.springaop.demo.annotion.TestAopAnnotion)")
    public Object checkRepeatSubmit(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String key = RequestContextHolder.getRequestAttributes().getSessionId() + "-" + attributes.getRequest().getServletPath();
        HttpServletRequest request = attributes.getRequest();

        String test = request.getParameter("test");
        System.out.println("key = "+key);
        System.out.println("test = "+test);
        return proceedingJoinPoint.proceed();
    }





}
