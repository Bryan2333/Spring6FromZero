package com.bryan016.spring6.test;

import com.bryan016.spring6.config.SpringConfig;
import com.bryan016.spring6.service.OrderService;
import com.bryan016.spring6.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAspect {
    @Test
    public void testBefore() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
        userService.logout();

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }
}
