package spring.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author 伍六七
 * @date 2023/7/26 14:54
 */
@SpringBootApplication
@EnableCaching
public class CacheApplication {


    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

}
