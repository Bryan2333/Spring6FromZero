package com.bryan4.spring6.bean;

import java.util.Date;

public class Dog {
    private String name;
    private int age;
    private Date birth;

    // p命名空间注入底层依然是Set注入，仍需要提供Set方法
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
