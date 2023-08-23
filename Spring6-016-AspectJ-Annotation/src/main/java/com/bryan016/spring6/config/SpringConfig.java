package com.bryan016.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.bryan016.spring6.service")
/*
开启Aspect的自动代理
有了该注释后，spring容器会给标注了@Aspect注解的类生成代理对象
    proxy-target-class="true" 表示强制使用CGLIB进行动态代理
    proxy-target-class="false" 表示接口使用JDK动态代理，反之使用CGLIB动态代理
*/
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
