package com.pl1111w.jdbc.statement;

import com.pl1111w.jdbc.connection.DriverConnection;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/2/13 17:55
 */
public class GainData {

    @Test
    public void insertData() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //建立连接
            connection = getConnection();
            String sql = "insert into mysql_spring.admin (username,password,address,phone)" +
                    "values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            //填充字符串
            statement.setString(1, "chris");
            statement.setString(2, "0000");
            statement.setString(3, "suzhou");
            statement.setString(4, "15500941900");

            //执行
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public Connection getConnection() throws Exception {
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        DriverManager.registerDriver(driver);
        InputStream inputStream = DriverConnection.class.getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        Connection connection = DriverManager.getConnection(properties.getProperty("jdbcUrl"), properties);
        return connection;
    }

    public PreparedStatement prepareTask(String sql, Connection connection, String... args) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        //填充字符串
        for (int i = 0; i < args.length; i++) {
            ps.setString(i + 1, args[i]);
        }
        return ps;
    }

    @Test
    public void getCustomerInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询的人名：");
        String name = sc.nextLine();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //建立连接
            connection = getConnection();
            String sql = "select * from mysql_spring.admin where username= ? ";
            statement = prepareTask(sql, connection, name);
            //执行
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                String address = resultSet.getString(3);
                String phone = resultSet.getString(4);
                Customer customer = new Customer();
                customer.setAddress(address);
                customer.setPhone(phone);
                customer.setUser(username);
                customer.setPassword(password);
                System.out.println(customer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void getClassInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询的人名：");
        String name = sc.nextLine();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //建立连接
            connection = getConnection();
            String sql = "select username user,password,address,phone from mysql_spring.admin where username= ? ";
            statement = prepareTask(sql, connection, name);
            //执行
            resultSet = statement.executeQuery();
            extracted(Customer.class, resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private <T> void extracted(Class<T> clazz, ResultSet resultSet) throws SQLException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<T> list = new ArrayList<T>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();//条数
        if (resultSet.next()) {
            T t = clazz.getDeclaredConstructor().newInstance();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = resultSet.getObject(i + 1);//获取值
                String columnLabel = metaData.getColumnLabel(i + 1);//获取列
                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t,columnValue);
            }
            System.out.println(t);
            list.add(t);
        }
    }
}

class Customer {
    private String user;
    private String password;
    private String address;
    private String phone;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
