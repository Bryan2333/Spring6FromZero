package org.bryan013.spring6.service;

import org.bryan013.spring6.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "orderService")
public class OrderService {
    private OrderDao orderDao;

    // 使用@Autowired注解是，不需要指定任何属性
    // 这个注解的作用是根据类型byType进行自动装配
    @Autowired()
    @Qualifier(value = "orderDaoImplForMariadb")
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generateOrder() {
        orderDao.insert();
    }
}
