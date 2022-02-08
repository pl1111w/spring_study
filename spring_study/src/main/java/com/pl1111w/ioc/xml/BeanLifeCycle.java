package com.pl1111w.ioc.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/7 11:45
 */
public class BeanLifeCycle implements BeanPostProcessor {



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("前置处理器 初始化方法之前执行");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器 初始化方法之后执行");
        return bean;
    }


}
