package com.bryan8.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
*   日志Bean后置处理器
*
*/
public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步：执行Bean后处理器的Before方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /*
    *   第一参数：刚创建的Bean对象
    *
    *   第二个参数：Bean对象的名字
    *
    */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步：执行Bean后处理器的After方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
