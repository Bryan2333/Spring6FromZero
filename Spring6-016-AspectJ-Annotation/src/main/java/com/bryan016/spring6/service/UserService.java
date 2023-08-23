package com.bryan016.spring6.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService { // 目标类
    public void login() {
        System.out.println("用户正在登陆...."); // 目标方法
    }

    public void logout() {
        System.out.println("用户正在退出系统...");
    }
}
