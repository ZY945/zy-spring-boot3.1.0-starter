package com.cabin.dingtalk;

import io.github.zy945.dingtalk.util.DingTalkHelper;
import io.github.zy945.influxDB.util.InfluxDBTemplate;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 伍六七
 * @date 2023/7/19 17:03
 */
@SpringBootTest(classes = DingTalkTestSpringApplication.class)
public class TestDingTalk {

    @Resource(name = "DingTalkHelper")
    private DingTalkHelper dingTalkHelper;
    @Value("${dingding.access_token}")
    private String name;

    @Test
    void test() {
        dingTalkHelper.sendMessageByText("1",null,true);
        System.out.println(name);
    }

    @Resource(name = "InfluxDBTemplate")
    private InfluxDBTemplate template;
    @Test
    void tes1t() {
        Long cpu0Stat = template.count("Memory");
        System.out.println(cpu0Stat);
    }

}
