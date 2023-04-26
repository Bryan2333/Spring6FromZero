package com.bryan7.spring6;

import org.springframework.beans.factory.FactoryBean;

// PersonFactoryBean也是一个Bean，叫做工厂Bean
// 通过工厂Bean可以获取普通Bean
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        // Bean的创建还是程序员自己new
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    // 该方法在接口中有默认实现，返回true
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
