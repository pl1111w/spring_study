package com.pl1111w.bean_load.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/7 18:34
 */
@Configuration
@ComponentScan( {"com.pl1111w.bean_load.annotation", "com.pl1111w.ioc.xml"})
public class TotallyAnnotation {
}
