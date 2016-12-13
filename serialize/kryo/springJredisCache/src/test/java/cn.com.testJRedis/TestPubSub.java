package cn.com.testJRedis;

import cn.com.cache.JRedisCache;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import redis.clients.util.SafeEncoder;

import javax.annotation.Resource;

/**
 * Created by xiaxuan on 16/11/28.
 */
@Service("testPubSub")
public class TestPubSub {

    @Resource
    private JRedisCache jRedisCache;

    private FileSystemXmlApplicationContext springContext;

    private TestPubSub testPubSub;

    @Before
    public void InitRes() {
        DOMConfigurator.configure("src/main/resources/appConfig/log4j.xml");
        System.setProperty("java.net.preferIPv4Stack", "true");
        springContext = new FileSystemXmlApplicationContext("classpath*:springConfig/spring-context.xml");
        /**
         * 初始化spring容器
         */
        testPubSub = (TestPubSub) springContext.getBean("testPubSub");
    }

    @Test
    public void publish() {
        for (int num = 0; num <= 1000; ++num) {
            testPubSub.jRedisCache.publish("xxxxsss", "123".getBytes());
            testPubSub.jRedisCache.publish("fod_2", SafeEncoder.encode("456"));
        }
    }

    @Test
    public void psubscribe() throws InterruptedException {
        //订阅 处理 指定的消息
        testPubSub.jRedisCache.psubscribe("xxx*", "fod_*");
        //testPubSub.jRedisCache.subscribe("xxxxsss", "fod_2");
    }
}
