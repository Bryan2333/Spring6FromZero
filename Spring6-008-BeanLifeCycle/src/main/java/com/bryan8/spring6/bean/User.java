package com.bryan8.spring6.bean;

/*
*   Bean的生命周期按照五步
*
*   1. 实例化Bean，即调用Bean的无参构造函数
*
*   2. 给Bean赋值，即set注入
*
*   3. 初始化Bean，调用Bean的init方法，该方法需要程序员编写
*
*   4. 使用Bean
*
*   5. 销毁Bean，调用Bean的destroy方法，该方法需要程序员编写
*
*/

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;

    public User() {
        System.out.println("第一步：Student类无参构造函数被执行");
    }

    // 需要程序员编写配置，方法名自定
    public void initBean() {
        System.out.println("第四步：初始化Bean");
    }

    public void destroyBean() {
        System.out.println("第七步：销毁Bean");
    }

    public void setName(String name) {
        System.out.println("第二步：给对象的属性赋值");
        this.name = name;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean的ClassLoader " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean的工厂是 " + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean的名字是 " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet方法被执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposalBean的Destroy方法执行");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
