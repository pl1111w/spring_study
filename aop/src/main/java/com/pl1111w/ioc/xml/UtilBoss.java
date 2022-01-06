package com.pl1111w.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/5 16:13
 */
public class UtilBoss {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("bean5.xml");
        Boss boss = (Boss) xmlApplicationContext.getBean("boss");
        System.out.println(boss);
    }
}
