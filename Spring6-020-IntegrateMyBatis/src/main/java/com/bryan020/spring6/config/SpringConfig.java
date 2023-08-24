package com.bryan020.spring6.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("com.bryan020.spring6")
@MapperScan("com.bryan020.spring6.mapper") // 代替Mapper扫描器
@EnableTransactionManagement
public class SpringConfig {
    /**
     * 配置数据源
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource source = new DruidDataSource();
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        source.setDriverClassName(properties.getProperty("jdbc.driver"));
        source.setUrl(properties.getProperty("jdbc.url"));
        source.setUsername(properties.getProperty("jdbc.username"));
        source.setPassword(properties.getProperty("jdbc.password"));
        source.setTestWhileIdle(false);
        return source;
    }

    /**
     * 配置SqlSessionFactoryBean
     * @param source
     * @return
     */
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource source) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(source);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.bryan020.spring6.entity");
        return sqlSessionFactoryBean;
    }

    /**
     * 配置Mapper扫描器
     * @return
     */
/*
    @Bean(name = "mapperScanner")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.bryan020.spring6.mapper");
        return configurer;
    }
*/

    /**
     * 配置事务管理器
     * @param source
     * @return
     */
    @Bean(name = "txManager")
    public PlatformTransactionManager platformTransactionManager(DataSource source) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(source);
        return manager;
    }
}
