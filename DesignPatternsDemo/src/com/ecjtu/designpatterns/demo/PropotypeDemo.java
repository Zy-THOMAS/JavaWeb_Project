package com.ecjtu.designpatterns.demo;

import java.io.*;
import java.util.List;

/**
 * 原型模式.
 */
public class PropotypeDemo implements Cloneable, Serializable {
    private String name;
    private List<Person> persons;

    public PropotypeDemo(String name, List<Person> persons) {
        this.name = name;
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();//此种克隆即为浅克隆
        return deepClone();
    }

    /**
     * 利用序列化和反序列化实现深度克隆.
     * @return
     */
    private PropotypeDemo deepClone() {
        try{
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            final ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            final ObjectInputStream ois = new ObjectInputStream(bis);
            return (PropotypeDemo)ois.readObject();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
