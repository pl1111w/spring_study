package com.pl1111w.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/13 21:48
 */
@Component
@Aspect
@Order(1)
public class User1Proxy {

    @Pointcut("execution(* com.pl1111w.aop.xml.User.add(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("order before....");
    }

}
