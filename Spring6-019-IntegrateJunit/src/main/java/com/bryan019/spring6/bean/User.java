package com.bryan019.spring6.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
    private String name;
    private Integer age;

    public User() {}

    @Value(value = "20")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Value(value = "张三")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
