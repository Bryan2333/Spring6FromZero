package com.bryan015.jdkDynamicProxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/*
*   专门负责计时的一个调用处理器对象
*
*   在这个处理器当中编写计时相关的增强代码
*
*   这个调用处理器编写一次即可
*
*   当代理对象调用代理方法时，注册在InvocationHandler调用处理器中的invoke()方法被调用
*
*   invoke的三个参数
*
*       1. Object proxy: 代理对象的引用
*
*       2. Method method: 目标对象的目标方法 (要被执行的目标方法)
*
*       3. Object[] args: 目标方法的实参
*
*/
public class TimerInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 增强
        long begin = System.currentTimeMillis();
        Object retValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");

        // 如果代理对象调用代理方法之后，需要返回结果，invoke方法必须将目标对象的目标方法的结果继续返回
        return retValue;
    }
}
