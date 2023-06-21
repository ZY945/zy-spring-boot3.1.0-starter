package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 伍六七
 * @date 2023/6/19 16:39
 */
@SpringBootApplication
public class DemoDBApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoDBApplication.class);
        springApplication.run(args);
    }
}
