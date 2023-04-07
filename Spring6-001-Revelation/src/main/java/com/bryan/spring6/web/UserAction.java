package com.bryan.spring6.web;

import com.bryan.spring6.service.UserService;

/**
 *  表示层
 */
public class UserAction {
//    private final UserServiceImpl userService = new UserServiceImpl();

    private UserService userService;
    /**
     *  删除用户信息的请求
     *
     */

    public void deleteRequest() {
        userService.deleteUser();;
    }
}
