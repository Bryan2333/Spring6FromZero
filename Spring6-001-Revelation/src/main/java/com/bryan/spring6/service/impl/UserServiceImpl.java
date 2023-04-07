package com.bryan.spring6.service.impl;

import com.bryan.spring6.dao.UserDao;
import com.bryan.spring6.service.UserService;

public class UserServiceImpl implements UserService {

    // 让方法共用该对象
//    private final UserDaoImplForMariadb userDao = new UserDaoImplForMariadb();

//    private final UserDaoImplForOracle userDao = new UserDaoImplForOracle();

    private UserDao userDao;
    @Override
    // 删除用户信息逻辑
    public void deleteUser() {
        userDao.deleteById();
    }

    public void saveUser() {

    }
}
