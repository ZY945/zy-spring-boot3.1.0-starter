import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.study.CacheApplication;
import spring.study.cache.CacheService;

import java.util.Date;

/**
 * @author 伍六七
 * @date 2023/7/26 15:21
 */
@SpringBootTest(classes = {CacheApplication.class})
public class CacheTest {
    @Autowired
    private CacheService cacheService;

    @Test
    void Test() {
        System.out.println(new Date() + " " + cacheService.getByName("name1"));
        System.out.println(new Date() + " " + cacheService.getByName("name1"));
        System.out.println(new Date() + " " + cacheService.getByName("name3"));
        System.out.println(new Date() + " " + cacheService.getByName("name4"));
        System.out.println(new Date() + " " + cacheService.getByName("name5"));
    }
}
