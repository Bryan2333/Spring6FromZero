package com.bryan9.spring6.test;

import com.bryan9.spring6.bean.Husband;
import com.bryan9.spring6.bean.Wife;
import com.bryan9.spring6.bean2.Husband2;
import com.bryan9.spring6.bean2.Wife2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCircularDependency {

    @Test
    public void testCD() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husband = applicationContext.getBean("husbandBean", Husband.class);

        Wife wife = applicationContext.getBean("wifeBean", Wife.class);

        System.out.println(husband);
        System.out.println(wife);
    }

    @Test
    public void testCD2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Husband2 husbandBean2 = applicationContext.getBean("husbandBean2", Husband2.class);

        Wife2 wifeBean2 = applicationContext.getBean("wifeBean2", Wife2.class);

        System.out.println(husbandBean2);
        System.out.println(wifeBean2);
    }
}
