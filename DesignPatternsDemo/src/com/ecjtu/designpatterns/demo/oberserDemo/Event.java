package com.ecjtu.designpatterns.demo.oberserDemo;

import java.lang.reflect.Method;

public class Event {
    private Object srcObj;
    private Object desObj;
    private EventType evenType;
    private Method callback;

    public Event(Object desObj, Method callback) {
        this.desObj = desObj;
        this.callback = callback;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public Object getSrcObj() {
        return srcObj;
    }

    public void setSrcObj(Object srcObj) {
        this.srcObj = srcObj;
    }

    public Object getDesObj() {
        return desObj;
    }

    public void setDesObj(Object desObj) {
        this.desObj = desObj;
    }

    public EventType getEvenType() {
        return evenType;
    }

    public void setEvenType(EventType evenType) {
        this.evenType = evenType;
    }



}
