package com.bryan11.myspring.test;

import com.bryan11.myspring.bean.User;
import com.bryan11.myspring.bean.UserService;
import org.junit.jupiter.api.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {

    @Test
    public void testMySpring01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");

        User user = (User) applicationContext.getBean("user");
        UserService userService = (UserService) applicationContext.getBean("userService");

        System.out.println(user);
        userService.save();
    }
}
