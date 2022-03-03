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
 * @date 2022/3/3 9:18
 */
public class FirstLevelCache {

    @Test
    public void testFirstLevel() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//        Employee employee = employeeMapper.selectEmp(1);
//        Employee employee1 = employeeMapper.selectEmp(2);
//        Employee employee3 = employeeMapper.selectEmp(1);
//        System.out.println(employee==employee3);
            Employee employee = employeeMapper.selectEmp(1);
            Employee employee1 = employeeMapper.selectEmp(2);
            employee1.setLastName("monkey");
            int number = employeeMapper.updateEmp(employee1);
            System.out.println(number);
            Employee employee3 = employeeMapper.selectEmp(1);
            System.out.println(employee==employee3);
        } finally {
            sqlSession.commit();
        }

    }
}
