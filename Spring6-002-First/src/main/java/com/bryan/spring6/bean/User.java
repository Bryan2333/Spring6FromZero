package com.bryan.spring6.bean;
/**
*   这是一个Bean，封装了用户的信息
*/

public class User {

    // Spring默认默认情况下会通过反射机制，调用无参构造函数来实例化对象
    public User() {
        System.out.println("User无参构造函数被执行");
    }
}
