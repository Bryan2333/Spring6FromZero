package com.bryan8.spring6;

import com.bryan8.spring6.bean.Student;
import com.bryan8.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLifeCycle {

    @Test
    public void testBeanLifeCycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        User userBean = applicationContext.getBean("userBean", User.class);

        System.out.println("第六步：使用Bean " + userBean);

        // 必须手动关闭Spring容器，这样才会销毁Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void TestDifferentConfig() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");

        User user = applicationContext.getBean("userBean2", User.class);

        System.out.println("第六步：使用Bean " + user);

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void testRegisterBean() {
        Student student = new Student();
        System.out.println(student);

        // 将自己new的对象纳入Spring容器的管理范围
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", student);

        // 从Spring容器中获取
        Student studentBean = factory.getBean("studentBean", Student.class);
        System.out.println(studentBean);

        System.out.println(studentBean == student);
    }
}
