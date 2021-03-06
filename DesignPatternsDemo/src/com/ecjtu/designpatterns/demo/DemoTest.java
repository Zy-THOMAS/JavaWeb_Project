package com.ecjtu.designpatterns.demo;

import java.util.ArrayList;

public class DemoTest {
    public static void main(String[] args) {

        /*
        //测试原型模式（深度克隆）
        PropotypeDemo ptd = new PropotypeDemo("THOMAS", new ArrayList<Person>());
        try {
            PropotypeDemo cloneObj = (PropotypeDemo)ptd.clone();
            System.out.println(ptd == cloneObj);
            System.out.println(ptd.getPersons() == cloneObj.getPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        //测试代理模式
         ProxyDemo proxyDemo = new ProxyDemo();
         PersonOperate person = (PersonOperate) proxyDemo.getProxyInstance(new Person());
         System.out.println(person.getClass());
         person.sleep();
    }
}
