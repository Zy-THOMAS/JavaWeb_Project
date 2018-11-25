package com.ecjtu.designpatterns.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo implements InvocationHandler {

    private PersonOperate person;

    public  Object getProxyInstance(PersonOperate person) {
        this.person = person;
        return Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("========行为前");
        Object res = method.invoke(person, args);
        System.out.println("========行为后");
        return res;
    }
}
