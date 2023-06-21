package com.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 伍六七
 * @date 2023/6/19 14:30
 */
@ConfigurationProperties(prefix = "demo.db")//导入后自定义
public class DbProperties {
    private String url;
    private String driver;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
