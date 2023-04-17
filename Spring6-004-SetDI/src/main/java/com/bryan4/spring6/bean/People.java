package com.bryan4.spring6.bean;

public class People {
    private String name;
    private int age;
    private String gender;

    // c命名空间是简化构造注入，因此需要提供构造器
    public People(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
