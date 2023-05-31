package com.bryan015.utils;

import com.bryan015.jdkDynamicProxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyEncapsulation {

    // 封装一个工具方法获取代理对象
    public static Object newProxyInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }
}
