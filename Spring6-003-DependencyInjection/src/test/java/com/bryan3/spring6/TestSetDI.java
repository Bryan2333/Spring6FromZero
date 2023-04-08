package com.bryan3.spring6;

import com.bryan3.spring6.service.CustomerService;
import com.bryan3.spring6.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetDI {

    // set方法注入
    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.saveUser();
        userService.saveVip();
    }

    // 构造方法注入
    @Test
    public void testConstructDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        CustomerService csBean = applicationContext.getBean("csBean", CustomerService.class);
        csBean.save();

        CustomerService csBean2 = applicationContext.getBean("csBean2", CustomerService.class);
        csBean2.save();

        CustomerService csBean3 = applicationContext.getBean("csBean3", CustomerService.class);
        csBean3.save();
    }
}