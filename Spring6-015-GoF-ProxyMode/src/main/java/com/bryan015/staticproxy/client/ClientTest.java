package com.bryan015.staticproxy.client;

import com.bryan015.staticproxy.service.OrderService;
import com.bryan015.staticproxy.service.OrderServiceImpl;
import com.bryan015.staticproxy.service.OrderServiceImplSub;
import com.bryan015.staticproxy.service.OrderServiceProxy;
import org.junit.jupiter.api.Test;

public class ClientTest {
    @Test
    public void testOne() {
        OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();
    }

    @Test
    public void testTwo() {
        OrderService orderService = new OrderServiceImplSub();
        orderService.generate();
        orderService.modify();
        orderService.detail();
    }

    @Test
    public void testThree() {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();

        // 创建代理对象
        OrderService orderServiceProxy = new OrderServiceProxy(target);

        //调用代理对象的代理方法
        orderServiceProxy.generate();
        orderServiceProxy.modify();
        orderServiceProxy.detail();
    }
}
