package com.bryan015.jdkDynamicProxy.client;

import com.bryan015.jdkDynamicProxy.service.OrderService;
import com.bryan015.jdkDynamicProxy.service.OrderServiceImpl;
import com.bryan015.utils.ProxyEncapsulation;
import org.junit.jupiter.api.Test;

public class TestClient {
    @Test
    public void testOne() {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();

        // 创建代理对象
        /*
         *  newProxyInstance: 新建代理对象

            1. 在内存中动态地生成一个代理类的字节码class

            2. new了这个代理类的对象

            3. 三个参数

                1. ClassLoader loader: 类加载器，目标类的类加载器和代理类的类加载器使用同一个

                2. Class<?>[] interfaces: 代理类和目标类需要实现同一个或同一些接口

                3. InvocationHandler h: 调用处理器

         */

        /*OrderService proxyObj = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));*/

        // 使用工具类的静态方法封装了上述的代码
        OrderService proxyObject = (OrderService) ProxyEncapsulation.newProxyInstance(target);

        // 调用代理对象的代理方法
        // 如果需要做功能增强的话，需要保证目标对象的目标方法被执行
        proxyObject.generate();
        proxyObject.modify();
        proxyObject.detail();

        String name = proxyObject.getName();
        System.out.println(name);
    }
}
