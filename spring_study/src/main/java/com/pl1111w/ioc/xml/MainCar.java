package com.pl1111w.ioc.xml;

/**
 * @title: pl1111w
 * @description: ioc: 读取xml 工厂模式 反射
 * @author: Kris
 * @date 2022/1/4 17:53
 */
public class MainCar {
    public static void main(String[] args) throws ClassNotFoundException {
        Car car = new Car();
        car.setName("BYD");
        car.setSpeed(220);
        car.PrintMessage();

        CarFactory.getCar("com.pl1111w.ioc.xml.Car").PrintMessage();


    }
}
