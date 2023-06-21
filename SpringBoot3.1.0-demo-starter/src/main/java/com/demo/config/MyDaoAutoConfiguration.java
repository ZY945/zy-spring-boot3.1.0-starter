package com.demo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 伍六七
 * @date 2023/6/19 14:30
 * * @ConditionalOnClass，当classpath下发现该类的情况下进行自动配置。
 * * @ConditionalOnMissingBean，当Spring Context中不存在该Bean时。
 * * @ConditionalOnProperty(prefix = "example.service",value = "enabled",havingValue = "true")，当配置文件中example.service.enabled=true时。
 */
@Configuration
@EnableConfigurationProperties(DbProperties.class)
public class MyDaoAutoConfiguration {


    @Bean(name = "mysqlConnection")
    public java.sql.Connection getConnection(DbProperties dbProperties) throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName(dbProperties.getDriver());
        // 建立链接
        return DriverManager.getConnection(dbProperties.getUrl(),
                dbProperties.getUsername(), dbProperties.getPassword());
    }
}
