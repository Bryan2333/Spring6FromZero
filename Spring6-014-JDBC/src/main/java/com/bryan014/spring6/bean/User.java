package com.bryan014.spring6.bean;

public class User {
    private Integer id;
    private String realName;
    private Integer age;

    public User() {}

    public User(Integer id, String realName, Integer age) {
        this.id = id;
        this.realName = realName;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                '}';
    }
}
