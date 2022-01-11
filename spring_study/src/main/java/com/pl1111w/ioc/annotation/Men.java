package com.pl1111w.ioc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/7 18:12
 */
@Controller
public class Men implements Male {
    @Override
    public void maleInfo() {
        System.out.println("this is a men");
    }
}
