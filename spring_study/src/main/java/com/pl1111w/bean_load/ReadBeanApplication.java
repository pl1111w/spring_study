package com.pl1111w.bean_load;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/9/13 16:29
 */
public class ReadBeanApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("bean_load/bean.xml");
        String[] beanDefinitionNames = xmlApplicationContext.getBeanDefinitionNames();
        for(String name: beanDefinitionNames){
            System.out.println(name);
        }
    }
}
