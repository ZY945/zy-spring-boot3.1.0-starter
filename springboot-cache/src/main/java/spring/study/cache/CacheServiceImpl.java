package spring.study.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author 伍六七
 * @date 2023/7/26 14:58
 */
@Service
public class CacheServiceImpl implements CacheService {
    /**
     * <p>@Cacheable(value = "booksCache", key = "#name")<br/>
     * value和CacheConfig里的对应,key是#+参数,<br/>
     * 当击中缓存时,会直接返回,而不是调用方法
     */
    @Override
    @Cacheable(value = "booksCache", key = "#name")//开启缓存
    public CacheBook getByName(String name) {
        waitTask();
        return new CacheBook(name, "this is book");
    }

    private void waitTask() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
