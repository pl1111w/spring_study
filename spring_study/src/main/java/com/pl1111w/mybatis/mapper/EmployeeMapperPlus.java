package com.pl1111w.mybatis.mapper;

import com.pl1111w.mybatis.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/2/28 16:16
 */
public interface EmployeeMapperPlus {

    Employee selectEmp(int id);

    List<Employee> selectEmpLikeName(String lastName);

    @MapKey("lastName")
    Map<String, Employee> selectMapName(String lastName);

    List<Employee> selectWithWhere(int id, String email, String lastName);

    List<Employee> selectWithTrim(int id, String email, String lastName);

    List<Employee> selectWithChoose(int id, String email, String lastName);

    List<Employee> selectEmpIds(List<Integer> list);

    void batchUpdate(List<Employee> employeeList);

    int batchSave(List<Employee> ems);

    void batchUpdateMap(@Param("employeeMaps") Map<Integer,Employee> employeeMaps);
}
