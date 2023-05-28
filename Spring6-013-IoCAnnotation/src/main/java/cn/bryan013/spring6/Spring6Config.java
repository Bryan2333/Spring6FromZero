package cn.bryan013.spring6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 *   编写一个类代替Spring配置文件
 *
 */
@Configuration
@ComponentScan(value = {"cn.bryan013.spring6.dao", "cn.bryan013.spring6.service"})
public class Spring6Config {
}
