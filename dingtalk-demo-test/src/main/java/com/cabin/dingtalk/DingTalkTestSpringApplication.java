package com.cabin.dingtalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 伍六七
 * @date 2023/7/19 17:01
 */
@SpringBootApplication
public class DingTalkTestSpringApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DingTalkTestSpringApplication.class);
        springApplication.run(args);
    }
}
