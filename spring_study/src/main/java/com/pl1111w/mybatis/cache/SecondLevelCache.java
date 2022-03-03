package com.pl1111w.mybatis.cache;

import com.pl1111w.mybatis.entity.Employee;
import com.pl1111w.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/3/3 10:46
 */
public class SecondLevelCache {

    @Test()
    public void SecondLevelCacheTest() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectEmp(1);
            sqlSession.commit();
            EmployeeMapper employeeMapper2 = sqlSession2.getMapper(EmployeeMapper.class);
            Employee employee1 = employeeMapper2.selectEmp(1);
            System.out.println("control console only send one sql to database");
        } finally {
            sqlSession2.commit();
        }

    }
}
