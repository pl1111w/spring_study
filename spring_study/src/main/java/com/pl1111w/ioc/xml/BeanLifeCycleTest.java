package com.pl1111w.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/7 16:05
 */
public class BeanLifeCycleTest {

    private String name;

    private Date date;

    public BeanLifeCycleTest() {
        System.out.println("first 执行无参构造创建bean实例");
    }

    public void setName(String name) {
        System.out.println("second 调用set方法设置属性值");
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void initMethod(){
        System.out.println("third 执行初始化方法");
    }

    public void destroyMethod(){
        System.out.println("fifth destroy method!");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
        BeanLifeCycleTest beanLifeCycle = (BeanLifeCycleTest) context.getBean("beanLifeCycle",BeanLifeCycleTest.class);
        System.out.println("forth  获取bean实例："+beanLifeCycle);
        context.close();
    }
}
