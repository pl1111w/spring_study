package com.pl1111w.bean_load.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/7 17:06
 */
@Service(value = "annotation")
public class AnnotationScan {

    //@Autowired(required=false)当根据类型去找，找不到时，注入一个空。
    //@Autowired(required=true)当根据类型去找，找不到时，抛出异常信息
    @Autowired//类型注入
    private Women women;

    @Autowired//名称注入
    @Qualifier("husband")
    private Male male;

    @Resource//名称注入 非spring注解
    private Women women1;

    @Resource(name = "men")//名称注入 非spring注解
    private Male male2;

    public void annotationScan() {
        System.out.println("annotationScan method ...");
        women.printInf();
        male.maleInfo();
        women1.printInf();
        male2.maleInfo();
    }
}
