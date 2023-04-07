package com.bryan.spring6.dao.impl;

import com.bryan.spring6.dao.UserDao;

public class UserDaoImplForMariadb implements UserDao {

    @Override
    public void deleteById() {
        System.out.println("Mariadb正在删除用户信息");
    }
}
