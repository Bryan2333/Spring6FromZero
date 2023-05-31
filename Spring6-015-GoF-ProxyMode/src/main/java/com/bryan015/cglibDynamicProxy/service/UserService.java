package com.bryan015.cglibDynamicProxy.service;

// 目标类
public class UserService {

    // 目标方法
    public boolean login(String username, String password) {
        System.out.println("系统正在验证用户名和密码");
        return "admin".equals(username) && "admin".equals(password);
    }

    // 目标方法
    public void logout() {
        System.out.println("用户正在注销");
    }
}
