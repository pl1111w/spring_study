package com.pl1111w.mybatis;

import com.pl1111w.mybatis.entity.Employee;
import com.pl1111w.mybatis.mapper.EmployeeMapper;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @title: pl1111w
 * @description: 一个sqlsession底层就是一个connection 用完必须关闭 非线程安排
 * @author: Kris
 * @date 2022/2/23 20:51
 */
public class MybatisConnection {

    @Test
    public void test() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee employee = sqlSession.selectOne("com.pl1111w.mybatis.mapper.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test1() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectEmp(1);
            System.out.println(employee);
            Employee addEmp = new Employee();
            addEmp.setEmail("13625qq.com");
            addEmp.setLastName("www");
            addEmp.setId(3);
//            boolean b = employeeMapper.addEmp(addEmp);
//            System.out.println(b);
//            int i = employeeMapper.insertEmp(addEmp);
//            System.out.println("result:" + i);
//            System.out.println("id:" + addEmp.getId());
//            boolean b = employeeMapper.updateEmployee(addEmp);
//            int b = employeeMapper.deleteEmp(10);
            int b = employeeMapper.deleteEmployment("LY");
            System.out.println(b);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
