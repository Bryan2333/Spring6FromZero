package com.bryan016.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // 切面类需要使用@Aspect注解标注
@Component("logAspect")
@Order(2)
public class LogAspect { // 切面
    // 切面 = 通知 + 切点
    // 通知就是要编写的增强代码
    // 这里通知Advice以方法的形式出现
    // 标注了@Before注解的方式是一个前置通知

    // 切点
//    @Before("execution(* com.bryan016.spring6.service..*(..))")
//    // 通知
//    public void enhance() {
//        System.out.println("我是一个通知，我是一段增强代码.....");
//    }

    // 通用切点表达式
    @Pointcut("execution(* com.bryan016.spring6.service.OrderService.*())")
    public void generalPointcut() {

    }

    // 前置通知
    @Before("generalPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("日志 前置通知");
        // 获取目标方法的签名
        Signature signature = joinPoint.getSignature();
        // 通过方法的签名可以获得方法的信息：方法名、方法参数
        String name = signature.getName();
        System.out.println("目标方法的方法名：" + name);
    }

    // 后置通知
    @AfterReturning("generalPointcut()")
    public void afterReturnAdvice() {
        System.out.println("后置通知");
    }

    // 环绕通知 (环绕通知是范围最广的通知，在前置通知前，在后置通知后)
    @Around("generalPointcut()")
    // ProceedingJoinPoint joinPoint表示连接点
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前环绕通知");
        joinPoint.proceed();
        System.out.println("后环绕通知");
        return null;
    }

    // 异常通知 (如果程序抛出异常，则异常通知执行，且后置通知和后环绕通知不会执行)
    @AfterReturning("generalPointcut()")
//    @AfterThrowing("execution(* com.bryan016.spring6.service.OrderService.*(..))")
    public void afterThrowingAdvice() {
        System.out.println("异常通知");
    }

    // 最终通知
//    @After("execution(* com.bryan016.spring6.service.OrderService.*(..))")
    @After("generalPointcut()")
    public void afterAdvice() {
        System.out.println("最终通知");
    }
}
