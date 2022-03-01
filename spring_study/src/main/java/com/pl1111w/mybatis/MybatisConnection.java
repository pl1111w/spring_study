package com.pl1111w.mybatis;

import com.pl1111w.mybatis.entity.Employee;
import com.pl1111w.mybatis.mapper.EmployeeMapper;
import com.pl1111w.mybatis.mapper.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
//            int b = employeeMapper.deleteEmployment("LY");
//            System.out.println(b);
            Map<String, String> hashMap = new HashMap<>();
            String lastName = "xiaobo";
            String tableName = "tbl_employee";
            hashMap.put("lastName", lastName);
            hashMap.put("tableName", tableName);
            Employee empInfo = employeeMapper.selectEmpInfo(hashMap);
            System.out.println(empInfo);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = employeeMapperPlus.selectEmp(1);
            System.out.println(employee);
            List<Employee> employeeList = employeeMapperPlus.selectEmpLikeName("xiao%");
            System.out.println(employeeList);
            Map<String, Employee> employeeMap = employeeMapperPlus.selectMapName("xiao%");
            System.out.println("map: " + employeeMap);

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
            List<Employee> employees = employeeMapperPlus.selectWithWhere(1, null, null);
            List<Employee> employees1 = employeeMapperPlus.selectWithTrim(1, null, null);
            List<Employee> employees2 = employeeMapperPlus.selectWithChoose(0, null, "xiaobo");
            System.out.println(employees);
            System.out.println(employees1);
            System.out.println("emp: " + employees2);

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
//            Employee employee = employeeMapperPlus.selectEmp(2);
//            employee.setLastName("xiaonan");
//            int i = employeeMapperPlus.updateWithTrim(employee);
//            System.out.println(i);
            List<Employee> employees = employeeMapperPlus.selectEmpIds(Arrays.asList(1, 2));
            System.out.println("employees: " + employees);
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void test5() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
            List<Employee> employees = employeeMapperPlus.selectEmpIds(Arrays.asList(1, 2));
            HashMap<Integer,Employee> hashMap = new HashMap<>();
            employees.forEach(employee -> employee.setEmail("1388.qq.com"));
            employees.forEach(employee -> hashMap.put(employee.getId(),employee));
            employeeMapperPlus.batchUpdateMap(hashMap);
//            employeeMapperPlus.batchUpdate(employees);
//            List<Employee> list = new ArrayList<>();
//            list.add(new Employee("zt",'F',"27@com"));
//            list.add(new Employee("zj",'F',"25@com"));
//            int i = employeeMapperPlus.batchSave(list);
//            System.out.println(i);
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }

}
