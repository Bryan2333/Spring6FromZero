package com.bryan4.spring6.bean;

public class Cat {
    private String name;

    private String name2;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                ", age=" + age +
                '}';
    }
}
