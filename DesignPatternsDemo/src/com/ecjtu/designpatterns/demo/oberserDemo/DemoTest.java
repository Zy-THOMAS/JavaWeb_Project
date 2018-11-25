package com.ecjtu.designpatterns.demo.oberserDemo;

import java.lang.reflect.Method;

public class DemoTest {
    public static void main(String[] args) {
        //创建订阅者（观察者）
        final Observer observer = new Observer();
        Method callback = null;
        try {
            callback = observer.getClass().getMethod("save", Event.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取主题代理对象
        final ISubject subject = new Subject();
        subject.addLisenter(EventType.ON_SAVE, observer, callback);
        final ProxySubject proxySubject = new ProxySubject();
        final ISubject subjectProxy = proxySubject.getSubjectProxy(subject);

        //开始推送数据
        subjectProxy.save();
    }
}
