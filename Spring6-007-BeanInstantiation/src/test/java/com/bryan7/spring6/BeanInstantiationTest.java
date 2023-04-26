package com.bryan7.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanInstantiationTest {

    // 第一种实例化方法：类的全路径
    @Test
    public void testInstantiation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean = applicationContext.getBean("springBean", SpringBean.class);

        System.out.println(springBean);
    }

    // 第二种实例化方法：简单工厂模式
    @Test
    public void testInstantiation2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star starBean = applicationContext.getBean("starBean", Star.class);

        System.out.println(starBean);
    }

    // 第三种实例化方法：工厂方法模式
    @Test
    public void testInstantiation3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gunBean = applicationContext.getBean("gunBean", Gun.class);

        System.out.println(gunBean);
    }

    // 第四种实例化方法：FactoryBean接口
    @Test
    public void  testInstantiation4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("personBean", Person.class);
        System.out.println(person);
    }

    // 测试日期类变量注入
    @Test
    public void testInjectDate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("studentBean", Student.class);

        System.out.println(student);
    }
}
