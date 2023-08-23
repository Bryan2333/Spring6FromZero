package com.bryan017.spring6.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class SecurityLogAspect {
    // 声明通用切点表达式
    @Pointcut("execution(void com.bryan017.spring6.biz..save*(..))")
    public void savePointcut() {}

    @Pointcut("execution(void com.bryan017.spring6.biz..delete*(..))")
    public void deletePointcut() {}

    @Pointcut("execution(void com.bryan017.spring6.biz..modify*(..))")
    public void modifyPointcut() {}

    @Pointcut("execution(void com.bryan017.spring6.biz..get*(..))")
    public void getPointcut() {}

    @Before("savePointcut() || deletePointcut() || modifyPointcut() || getPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 获取当前系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(new Date());

        // 输出信息
        Signature signature = joinPoint.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        System.out.println(nowTime + "张三：" + declaringTypeName + "." + name);
    }
}
