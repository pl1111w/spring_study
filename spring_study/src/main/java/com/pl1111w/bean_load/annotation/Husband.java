package com.pl1111w.bean_load.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/7 18:09
 */
@Repository(value = "husband")
public class Husband implements Male{

    @Value("clarkson")
    private String name;

    @Override
    public void maleInfo() {
        System.out.println("this is hus");
    }
}
