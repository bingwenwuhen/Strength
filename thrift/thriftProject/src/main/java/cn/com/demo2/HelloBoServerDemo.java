package cn.com.demo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import thrift.HelloService;

import java.util.concurrent.Executors;

/**
 * Created by xiaxuan on 16/8/25.
 */
public class HelloBoServerDemo {

    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(HelloBoServerDemo.class);

    public static final int SERVER_PORT = 9111;

    public void startServer() {
        try {
            HelloBoServerDemo.LOGGER.info("看到这句就说明thrift服务端准备工作了....");
            //服务端执行控制器(只要是调度服务的具体实现该如何运行)
            TProcessor tProcessor = new HelloService.Processor<HelloService.Iface>(new HelloWorldServiceImpl());
            //基于阻塞式同步IO模型的Thrift服务，正式生产环境不建议使用这个
            TServerSocket serverSocket = new TServerSocket(SERVER_PORT);
            //为这个服务器设置对应的IO网络模型，设置使用的消息格式封装，设置线程池参数
            TThreadPoolServer.Args targs = new TThreadPoolServer.Args(serverSocket);
            targs.processor(tProcessor);
            targs.protocolFactory(new TBinaryProtocol.Factory());
            targs.executorService(Executors.newFixedThreadPool(100));
            //启动这个thrift服务
            TThreadPoolServer server = new TThreadPoolServer(targs);
            server.serve();
        } catch (Exception e) {
            HelloBoServerDemo.LOGGER.error(e);
        }
    }

    public static void main(String[] args) {
        HelloBoServerDemo server = new HelloBoServerDemo();
        server.startServer();
    }
}
