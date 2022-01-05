package com.pl1111w.ioc;

/**
 * @title: pl1111w
 * @description: 什么是bean管理：
 * 1、spring创建对象
 * 2、spring注入属性
 * @author: Kris
 * @date 2022/1/4 17:47
 */
public class Car {

    private Integer speed;

    private String name;

    public Car(String name, Integer speed) {
        this.name = name;
        this.speed = speed;
    }

    public Car() {

    }

    public void PrintMessage() {
        System.out.println(name + ":" + speed);
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }
}
