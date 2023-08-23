package com.bryan016.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("securityAspect")
@Order(1) // 切面顺序
public class SecurityAspect {
//    @Before("execution(* com.bryan016.spring6.service.UserService.login(..))")
    @Before("com.bryan016.spring6.service.LogAspect.generalPointcut()")
    public void beforeAdvice() {
        System.out.println("安全 前置通知");
    }
}
