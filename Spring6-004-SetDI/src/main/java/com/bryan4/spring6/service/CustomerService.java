package com.bryan4.spring6.service;

import com.bryan4.spring6.bean.User;
import com.bryan4.spring6.dao.UserDao;
import com.bryan4.spring6.dao.VipDao;

public class CustomerService {
    private UserDao userDao;

    private VipDao vipDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void save() {
        userDao.insert();
        vipDao.insert();
    }
}
