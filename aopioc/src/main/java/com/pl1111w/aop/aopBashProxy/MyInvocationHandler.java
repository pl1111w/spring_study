package com.pl1111w.aop.aopBashProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/9 11:55
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法前
        System.out.println("执行方法前："+method.getName()+"传递参数 ："+ Arrays.toString(args));
        //增强方法
        Object result = method.invoke(object, args);
        //方法之后
        System.out.println("执行方法之后执行");
        return result;
    }
}
