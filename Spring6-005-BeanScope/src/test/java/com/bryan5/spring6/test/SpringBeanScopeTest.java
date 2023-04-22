package com.bryan5.spring6.test;

import com.bryan5.spring6.bean.SpringBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {

    /*
    1.
        默认情况下，Bean是单例的
        在Spring上下文初始化时被实例化
        每一次调用getBean方法，返回的都是同一个单例对象

    2.
        将Bean的scope属性设置为prototype时，Bean是多例的
        Spring上下文初始化时，并不会实例这些prototype的Bean
        每次调用getBean方法时，实例化该Bean对象
    */
    @Test
    public void testBeanScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean1);

        SpringBean springBean2 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean2);

        SpringBean springBean3 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean3);
    }

    @Test
    public void testThreadScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean springBean = applicationContext.getBean("springBean2", SpringBean.class);
        System.out.println(springBean);

        SpringBean springBean1 = applicationContext.getBean("springBean2", SpringBean.class);
        System.out.println(springBean1);

        // 启动一个新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean springBean2 = applicationContext.getBean("springBean2", SpringBean.class);
                System.out.println(springBean2);

                SpringBean springBean3 = applicationContext.getBean("springBean2", SpringBean.class);
                System.out.println(springBean3);

            }
        }).start();

    }
}
