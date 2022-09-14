package com.pl1111w.bean_load.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/7 17:10
 */
public class AnnotationScanTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_load/annotation.xml");
        AnnotationScan annotationScan = context.getBean("annotation", AnnotationScan.class);
        annotationScan.annotationScan();

        System.out.println("纯注解方式==============");
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TotallyAnnotation.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        AnnotationScan annotation = applicationContext.getBean("annotation", AnnotationScan.class);
        annotation.annotationScan();


    }
}
