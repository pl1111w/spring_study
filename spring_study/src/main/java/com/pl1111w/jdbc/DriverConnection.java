package com.pl1111w.jdbc;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @title: pl1111w
 * @description: 链接数据库
 * @author: Kris
 * @date 2022/2/8 22:34
 */
public class DriverConnection {

    @Test
    public void testDriver() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/mysql_spring";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "Weixb4818");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    @Test
    public void testDriver2() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取数据库厂商实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/mysql_spring";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "Weixb4818");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    @Test
    public void testDriver3() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取数据库厂商实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/mysql_spring";
        String user = "root";
        String password = "Weixb4818";
        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.println(connect);
    }
}
