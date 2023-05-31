package com.bryan015.cglibDynamicProxy.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimerMethodInterceptor implements MethodInterceptor {
    // Object target 表示要进行增强的对象 (目标对象)
    // Method method 表示拦截的方法 (目标方法)
    // Object[] objects 表示目标方法的实参
    // MethodProxy methodProxy 表示对目标方法的代理，invokeSuper方法表示对目标对象的目标方法的调用
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long begin = System.currentTimeMillis();

        Object retValue = methodProxy.invokeSuper(target, objects);

        long end = System.currentTimeMillis();

        System.out.println("耗时" + (end - begin) + "毫秒");

        return retValue;
    }
}
