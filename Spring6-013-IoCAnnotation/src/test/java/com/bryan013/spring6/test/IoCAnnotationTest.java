package com.bryan013.spring6.test;

import cn.bryan013.spring6.Spring6Config;
import cn.bryan013.spring6.service.StudentService;
import com.bryan013.spring6.bean.*;
import com.bryan013.spring6.bean3.MyDataSource;
import com.bryan013.spring6.dao.OrderDao;
import org.bryan013.spring6.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {
    // 测试实例化Bean的注解
    @Test
    public void testBeanComponent() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);

        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);

        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);

        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);

//        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
//        System.out.println(orderService);

        OrderDao orderDao = applicationContext.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);

    }

    // 测试按照注解选择性实例化Bean
    @Test
    public void testBeanSelective() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-selective.xml");
    }

    // 测试@Value注解进行依赖注入
    @Test
    public void testDIByAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");

        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);

        com.bryan013.spring6.bean3.User user = applicationContext.getBean("user", com.bryan013.spring6.bean3.User.class);
        System.out.println(user);
    }

    // 测试@Autowired根据类型/名称自动装配
    @Test
    public void testAutoWired() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        orderService.generateOrder();
    }

    // 测试@Resource注解
    @Test
    public void testResourceAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource-annotation.xml");

        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);

        studentService.deleteStudent();
    }

    // 使用有@Configuration注解修饰的类来代替Spring配置文件
    @Test
    public void testNoXML() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);

        StudentService studentService = context.getBean("studentService", StudentService.class);

        studentService.deleteStudent();
    }
}
