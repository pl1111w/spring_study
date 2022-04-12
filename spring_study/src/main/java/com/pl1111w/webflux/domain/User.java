package com.pl1111w.webflux.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/3/29 15:46
 */
@Document(collection = "user")
@Data
public class User {

    @Id
    private String id;
    @NotBlank
    private String name;
    @Range(min = 20,max = 40)
    private int age;
}
