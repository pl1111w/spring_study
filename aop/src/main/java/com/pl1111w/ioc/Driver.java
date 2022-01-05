package com.pl1111w.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/5 11:33
 */
public class Driver {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private String name;

    private Car car;

    @Override
    public String toString() {
        return "Driver{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Class aClass = Class.forName("com.pl1111w.ioc.Driver");
        Driver driver = (Driver) context.getBean("driver",aClass);
        System.out.println(driver);
    }
}
