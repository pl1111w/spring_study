package com.pl1111w.jdbc.ConnectonDatabasePool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.pl1111w.jdbc.connection.DriverConnection;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/2/17 11:37
 */
public class DruidDatabasePool {

    private static DruidDataSource dataSource;

    public Connection getDruidConnect() throws Exception {

        Connection connection = dataSource.getConnection();
        return connection;
    }

    static {
        InputStream inputStream = DriverConnection.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void GetGoods() {
        PreparedStatement statement = null;
        try {
            Connection connection = getDruidConnect();
            String sql = "select * from goods where id <= ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 5);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement!=null) statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
