package com.ecjtu.designpatterns.demo.oberserDemo;

public class Subject extends EventLisenter implements ISubject {

    public void save() {
        System.out.println("事件源出发Save事件");
    }
}
