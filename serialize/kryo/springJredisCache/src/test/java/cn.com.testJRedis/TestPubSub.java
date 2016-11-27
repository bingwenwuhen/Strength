package cn.com.testJRedis;

import cn.com.cache.JRedisCache;
import org.junit.Before;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

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

    }
}
