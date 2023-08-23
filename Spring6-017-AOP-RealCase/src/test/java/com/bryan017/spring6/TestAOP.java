package com.bryan017.spring6;

import com.bryan017.spring6.biz.UserService;
import com.bryan017.spring6.biz.VipService;
import com.bryan017.spring6.config.SpringConfig;
import com.bryan017.spring6.service.AccountService;
import com.bryan017.spring6.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {
    @Test
    public void testTransaction() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        accountService.transfer();
        accountService.withdraw();

        orderService.generate();
        orderService.cancel();
    }

    @Test
    public void testSecurityLog() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        VipService vipService = context.getBean("vipService", VipService.class);
        UserService userService = context.getBean("userService", UserService.class);

        vipService.saveVip();
        vipService.deleteVip();
        vipService.modifyVip();
        vipService.getVip();

        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        userService.getUser();
    }
}
