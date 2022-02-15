package com.pl1111w.jdbc.statement;

import com.pl1111w.jdbc.connection.DriverConnection;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/2/15 16:20
 */
public class BatchJob {
    @Test
    public void insertGoods() {
        Connection connection = null;
        PreparedStatement statement = null;
        long startTime = System.currentTimeMillis();
        try {
            connection = connection();
            String sql = "INSERT GOODS (NAME) VALUES(?)";
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                statement.setString(1, "name_" + i);
                statement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSource(connection, statement);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("method 1 total time " + (endTime - startTime));
    }

    @Test
    public void insertGoods2() {
        Connection connection = null;
        PreparedStatement statement = null;
        long startTime = System.currentTimeMillis();
        try {
            connection = connection();
            String sql = "INSERT GOODS (NAME) VALUES(?)";
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                statement.setString(1, "name_" + i);
                statement.addBatch();
                if (i % 1000 == 0) {
                    statement.executeBatch();
                    statement.clearBatch();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSource(connection, statement);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("method 2 total time " + (endTime - startTime));
    }

    @Test
    public void insertGoods3() {
        Connection connection = null;
        PreparedStatement statement = null;
        long startTime = System.currentTimeMillis();
        try {
            connection = connection();
            connection.setAutoCommit(false);
            String sql = "INSERT GOODS (NAME) VALUES(?)";
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                statement.setString(1, "name_" + i);
                statement.addBatch();
                if (i % 1000 == 0) {
                    statement.executeBatch();
                    statement.clearBatch();
                }

            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSource(connection, statement);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("method 3 total time " + (endTime - startTime));
    }

    private void closeSource(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null)
                statement.close();
            if (statement != null)
                connection.close();
        } catch (Exception throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("资源关闭成功");
        }

    }

    public Connection connection() throws ClassNotFoundException, SQLException, IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取数据库厂商实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        DriverManager.registerDriver(driver);
        InputStream inputStream = DriverConnection.class.getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        Connection connection = DriverManager.getConnection(properties.getProperty("jdbcUrl"), properties);
        return connection;
    }
}
