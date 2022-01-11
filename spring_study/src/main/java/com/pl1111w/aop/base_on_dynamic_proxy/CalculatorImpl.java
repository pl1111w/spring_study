package com.pl1111w.aop.base_on_dynamic_proxy;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/9 11:49
 */
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        System.out.println("begin add..");
        return a+b;
    }

    @Override
    public String printInf() {
        System.out.println("printInf...");
        return null;
    }
}
