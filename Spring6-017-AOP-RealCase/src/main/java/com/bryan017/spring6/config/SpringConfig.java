package com.bryan017.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.bryan017.spring6")
@EnableAspectJAutoProxy
public class SpringConfig {
}
