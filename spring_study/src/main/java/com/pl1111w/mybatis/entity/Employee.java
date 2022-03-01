package com.pl1111w.mybatis.entity;

import lombok.Data;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/2/23 21:07
 */
@Data
public class Employee {

    private int id;
    private String lastName;
    private char gender;
    private String email;
    private Department department;


    public Employee(String lastName, char gender, String email) {
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Employee() {

    }
}
