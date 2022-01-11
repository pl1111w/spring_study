package com.pl1111w.ioc.xml;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description: 工厂bean 返回的bean可以跟xml配置的bean不一样
 * @author: Kris
 * @date 2022/1/6 10:52
 */
public class FactoryBeanTest implements FactoryBean<Driver> {


    @Override
    public Driver getObject() throws Exception {
        Driver driver = new Driver();
        driver.setAge(50);
        driver.setName("kelly");
        return driver;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factoryBean.xml");
        Driver driver = (Driver) context.getBean("factoryBean",Driver.class);
        System.out.println(driver);

    }
}
