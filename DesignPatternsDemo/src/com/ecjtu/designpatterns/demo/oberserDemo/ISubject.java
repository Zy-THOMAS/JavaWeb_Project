package com.ecjtu.designpatterns.demo.oberserDemo;

import java.lang.reflect.Method;

public interface ISubject {
    void trigger(EventType eventType);
    void addLisenter(EventType eventType, Object targetObj, Method callback);
    void save();
}
