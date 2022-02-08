package com.pl1111w.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/13 21:17
 */
@Aspect
@Component
@Order(2)
public class UserProxy {


    @Before("execution(* com.pl1111w.aop.xml.User.add(..))")
    public void before(){
        System.out.println("before....");
    }

    @After("execution(* com.pl1111w.aop.xml.User.add(..))")
    public void after(){
        System.out.println("after....");
    }

    @AfterReturning("execution(* com.pl1111w.aop.xml.User.add(..))")
    public void afterReturn(){
        System.out.println("afterReturn....");
    }

    @Around("execution(* com.pl1111w.aop.xml.User.add(..))")
    public void afterAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("afterAround before....");
        joinPoint.proceed();
        System.out.println("afterAround after....");
    }
}
