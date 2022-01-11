package com.pl1111w.aop.base_on_dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/1/9 11:50
 */
public class ProxyInStanceMain {

    public static void main(String[] args) {

        Class[] interfaces = {Calculator.class};

//        Calculator proxyInstance = (Calculator) Proxy.newProxyInstance(ProxyInStanceMain.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        Calculator proxyInstance = (Calculator) Proxy.newProxyInstance(ProxyInStanceMain.class.getClassLoader(), interfaces, new MyInvocationHandler(new CalculatorImpl()));
        proxyInstance.printInf();
        proxyInstance.add(1,2);
    }
}
