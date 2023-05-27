package org.myspringframework.core;

/*
*   MySpring框架应用上下文接口
*
*/
public interface ApplicationContext {

    // 根据Bean的名称获得对应的bean对象
    Object getBean(String beanName);
}
