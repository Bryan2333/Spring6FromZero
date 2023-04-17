package com.bryan4.spring6.service;

import com.bryan4.spring6.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    // 提供set方法
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate() {
        orderDao.insert();
    }
}
