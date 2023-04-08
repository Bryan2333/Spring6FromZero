package com.bryan.spring6.test;

import com.bryan.spring6.bean.User;
import com.bryan.spring6.dao.impl.UserDaoImplForMariadb;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {

    @Test
    public void testLogger() {
        // 1. 创建日志记录器对象
        // 获取对应类的日志记录器对象，只要FirstSpringTest类里的代码被执行，日志记录器就会输出相关的日志信息
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        // 2. 记录日志，根据不同的等级来输出日志
        logger.info("消息信息");
        logger.debug("调试信息");
        logger.error("错误信息");
    }

    @Test
    public void testBeginInitBean() {
        //  被Spring管理的对象，并不是在 getBean 方法被调用时才创建
        // 执行下面的代码时，该对象就会被实例化
        new ClassPathXmlApplicationContext("Spring.xml");
    }

    @Test
    public void testBeanFactory() {
        // ApplicationContext接口的超级父接口: BeanFactory bean工厂，生产Bean的工厂
        // BeanFactory 是IoC容器的顶级接口
        // Spring的IoC 底层容器使用了工厂模式
        // Spring IoC底层原理: xml解析 + 工厂模式 + 反射机制
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("Spring.xml");
//        User userBean = applicationContext.getBean("userBean", User.class);
        User userBean = beanFactory.getBean("userBean", com.bryan.spring6.bean.User.class);
        System.out.println(userBean);
    }

    @Test
    public void testFirstSpringCode() {
        // 1. 获取Spring容器对象
        // ApplicationContext: 应用上下文，Spring容器
        // ApplicationContext是一个接口，有很多的实现类
        // ClassPathXmlApplicationContext专门从类路径中加载Spring配置文件
        // 该行代码只要执行，就会启动Spring容器解析配置文件，并且实例化所有Bean对象
        // ClassPathXmlApplicationContext可以从多个xml文件中读取
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("Spring.xml", "Beans.xml");

        // 2. 根据Bean的ID，从容器中获取对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

//        Object userDaoBean = applicationContext.getBean("userDaoBean");
        UserDaoImplForMariadb userDaoBean = applicationContext.getBean("userDaoBean", UserDaoImplForMariadb.class);
        System.out.println(userDaoBean);
        userDaoBean.insert();

        Object vipBean = applicationContext.getBean("vipBean");
        System.out.println(vipBean);

//        Object dateBean = applicationContext.getBean("dateBean");
//        Date dateBean = (Date) applicationContext.getBean("dateBean");
        // 如果不想强制转换，可以用下面的代码 (通过第二个参数指定返回的Bean的类型)
        Date dateBean = applicationContext.getBean("dateBean", Date.class);
        System.out.println(dateBean);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(dateBean));


        // 如果Bean的ID不存在，Spring不会返回null，而是直接抛出异常
//        Object noExist = applicationContext.getBean("noExist");
    }
}
