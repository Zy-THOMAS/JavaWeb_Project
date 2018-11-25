package com.ecjtu.designpatterns.demo.oberserDemo;

import com.sun.org.apache.bcel.internal.generic.ISUB;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxySubject implements InvocationHandler {

    private ISubject subject;

    public final static Map<String, EventType> methodNameMap = new HashMap<String, EventType>();

    static {
        methodNameMap.put("save", EventType.ON_SAVE);
    }

    public ISubject getSubjectProxy(ISubject subject) {
        this.subject = subject;
        return (ISubject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(subject, args);
        subject.trigger(methodNameMap.get(method.getName()));
        return null;
    }
}
