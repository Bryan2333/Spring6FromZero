package com.bryan015.cglibDynamicProxy.client;

import com.bryan015.cglibDynamicProxy.service.TimerMethodInterceptor;
import com.bryan015.cglibDynamicProxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

/*
*   CGLIB动态代理的底层原理是**继承**
*
*/

public class TestClient {
    public static void main(String[] args) {
        // 创建字节码增强器对象
        // CGLIB就是靠它创建代理类对象
        Enhancer enhancer = new Enhancer();

        // 告诉CGLIB目标类是什么
        enhancer.setSuperclass(UserService.class);

        // 设置回调 (等同于JDK动态代理中的调用处理器 InvocationHandler)
        // CGLIB中的方法接口是 MethodInterceptor
        enhancer.setCallback(new TimerMethodInterceptor());

        // 创建代理对象 (包含两步)
        // 1. 在内存中生成UserService的子类，即代理类的字节码
        // 2. 创建代理类对象
        UserService userServiceProxy = (UserService) enhancer.create();

        boolean result = userServiceProxy.login("admin", "admin");
        System.out.println(result ? "登陆成功" : "登陆失败");

        userServiceProxy.logout();
    }
}
