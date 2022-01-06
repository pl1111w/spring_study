package com.pl1111w.ioc.xml;

import lombok.Setter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/5 14:58
 */
@Setter
public class Boss {

    private String [] name;

    private List<Car> cars;

    private Set<String> com;

    private HashMap<String,Double> account;

    @Override
    public String toString() {
        return "Boss{" +
                "name=" + Arrays.toString(name) +
                ", cars=" + cars +
                ", com=" + com +
                ", account=" + account +
                '}';
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("bean3.xml");
        Boss boss = (Boss) xmlApplicationContext.getBean("boss");
        System.out.println(boss);
    }
}
