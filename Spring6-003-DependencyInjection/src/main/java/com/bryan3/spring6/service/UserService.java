package com.bryan3.spring6.service;

import com.bryan3.spring6.dao.UserDao;
import com.bryan3.spring6.dao.VipDao;

public class UserService {
    private UserDao userDao;
    private VipDao vipDao;

    // set注入，必须提供一个set方法
    // Spring容器通过该set方法，给userDao赋值
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void saveUser() {
        userDao.insert();
    }

    public void saveVip() {
        vipDao.insert();
    }
}
