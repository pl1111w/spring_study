package com.pl1111w.jdbc.transactional;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.pl1111w.jdbc.statement.GainData.getConnection;

/**
 * @title: pl1111w
 * @description: 读未提交会存在脏读  读已提交存在不可重复读  可重复读存在幻读  序列化
 * @author: Kris
 * @date 2022/2/16 14:16
 */
public class TransactionalJDBC {

    @Test
    public void TransactionalTest() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            String sql = "update payment set wealth =50 where id = 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            System.out.println(1 / 0);

            String sql2 = "update payment set wealth =50 where id = 2";
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.executeUpdate();
            connection.commit();
            System.out.println("transactional is finished");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (preparedStatement2 != null) preparedStatement2.close();
            if (connection != null) connection.close();
        }
    }
}
