package com.bryan4.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
    public static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert() {
       logger.info("数据库正在保存普通用户信息");
    }
}
