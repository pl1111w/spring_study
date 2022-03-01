package com.pl1111w.mybatis.mapper;

import com.pl1111w.mybatis.entity.Employee;

import java.util.Map;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/2/23 21:09
 */
public interface EmployeeMapper {

    Employee selectEmp(int id);

    int insertEmp(Employee employee);

    boolean addEmp(Employee employee);

    int updateEmp(int id, String name);

    boolean updateEmployee(Employee employee);

    boolean deleteEmp(int id);

    int deleteEmployment(String name);

    Employee selectEmpInfo(Map<String, String> hashMap);

}
