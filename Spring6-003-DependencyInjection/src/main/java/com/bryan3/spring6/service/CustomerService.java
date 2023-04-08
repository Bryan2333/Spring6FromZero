package com.bryan3.spring6.service;

/**
 * Bean
 * @author Bryan
 * @ClassName CustomService
 *
 * */
import com.bryan3.spring6.dao.UserDao;
import com.bryan3.spring6.dao.VipDao;

public class CustomerService {
    private UserDao userDao;
    private VipDao vipDao;

    public CustomerService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void save() {
        userDao.insert();
        vipDao.insert();
    }
}
