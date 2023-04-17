package com.bryan4.spring6;

import com.bryan4.spring6.bean.*;
import com.bryan4.spring6.dao.OrderDao;
import com.bryan4.spring6.jdbc.MyDataSource;
import com.bryan4.spring6.jdbc.MyDataSource1;
import com.bryan4.spring6.jdbc.MyDataSource2;
import com.bryan4.spring6.service.CustomerService;
import com.bryan4.spring6.service.OrderService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestSetDI {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }

    // set方法注入
    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);

        orderService.generate();

        OrderService orderService2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderService2.generate();
    }

    // 简单数据类型赋值
    @Test
    public void testSimpleType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);

        SimpleValueType svtBean = applicationContext.getBean("svtBean", SimpleValueType.class);
        System.out.println(svtBean);
    }

    // 让Spring管理数据源
    @Test
    public void testMyDataSource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDateSourceBean", MyDataSource.class);
        System.out.println(myDataSource);
    }

    // 级联属性赋值
    @Test
    public void testCascade() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Clazz clazz = applicationContext.getBean("clazzBean", Clazz.class);
        System.out.println(clazz);
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
    }

    // 数组属性赋值
    @Test
    public void testArray() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        ZhangSan zhangSan = applicationContext.getBean("zhangSan", ZhangSan.class);
        System.out.println(zhangSan);
    }

    // 集合属性赋值
    @Test
    public void testCollection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person person = applicationContext.getBean("personBean", Person.class);

        System.out.println(person);
    }

    // 给属性赋null
    @Test
    public void testNull() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Cat cat = applicationContext.getBean("catBean", Cat.class);

        System.out.println(cat);
    }

    // 注入特殊字符
    @Test
    public void testSpecial() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }

    // p命名空间注入
    @Test
    public void testPNamespace() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dog = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dog);
    }

    // c命名空间注入
    @Test
    public void testCNamespace() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People people = applicationContext.getBean("peopleBean", People.class);
        System.out.println(people);
    }

    @Test
    // util命名空间注入
    public void testUtilNamespace() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);

        System.out.println(ds1);
        System.out.println(ds2);
    }

    // 测试基于[名字]的自动装配
    @Test
    public void testAutowireByName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);

        orderService.generate();
    }

    // 测试基于[类型]的自动封装
    @Test
    public void testAutowireByType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        CustomerService customerService = applicationContext.getBean("customerServiceBean", CustomerService.class);

        customerService.save();
    }

    // 测试引入外部配置文件
    @Test
    public void testProperties() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSourceBean", MyDataSource.class);

        System.out.println(dataSource);
    }
}
