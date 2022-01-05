package com.pl1111w.ioc;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/4 17:53
 */
public class MainCar {
    public static void main(String[] args) throws ClassNotFoundException {
        Car car = new Car();
        car.setName("BYD");
        car.setSpeed(220);
        car.PrintMessage();

        CarFactory.getCar("com.pl1111w.ioc.Car").PrintMessage();


    }
}
