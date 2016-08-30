package cn.com.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

import java.util.Set;

/**
 * Created by xiaxuan on 16/8/26.
 */
public class MainProcessor {

    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(MainProcessor.class);

    private static final Integer SERVER_PORT = 8090;

    /**
     * 专门用于锁定保证这个主线程不退出的一个object对象
     */
    private static final Object WAIT_OBJECT = new Object();

    /**
     * 标记Apache thrift是否启动成功
     * 只有Apache thrift启动成功了，才需要连接到zk
     */
    private boolean isthriftStart = false;

    /**
     * 这个私有方法用于连接到zk上，并且注册到相关服务
     */
    private void connectZk() {
        //读取这个服务提供者，需要在zk上注册服务
//        Set<String> serviceNames = Business
    }
}
