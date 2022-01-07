package com.pl1111w.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/4 17:54
 */
public class CarFactory {

    public static Car getCar(String path) throws ClassNotFoundException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Class aClass = Class.forName(path);
        Car c = (Car) context.getBean("car",aClass);
        return c;
    }
}
