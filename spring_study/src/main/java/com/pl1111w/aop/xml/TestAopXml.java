package com.pl1111w.aop.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/13 21:27
 */
public class TestAopXml {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aopbean.xml");
        User user = context.getBean(User.class);
        user.add();
    }
}
