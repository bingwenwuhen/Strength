package cn.com.demo3;

import cn.com.demo2.HelloWorldServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import thrift.HelloService;

import java.nio.channels.Selector;
import java.util.concurrent.Executors;

/**
 * Created by xiaxuan on 16/8/25.
 */
public class HelloNonServerDemo {

    static {
        BasicConfigurator.configure();
    }

    private static final Log LOGGER = LogFactory.getLog(HelloNonServerDemo.class);

    private static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            HelloNonServerDemo.LOGGER.info("Hello World TSimpleServer start....");
            //服务执行控制器
            TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloWorldServiceImpl());
            //非阻塞异步通讯模型(服务器端)
            TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(SERVER_PORT);
            serverSocket.registerSelector(Selector.open());
            THsHaServer.Args tArgs = new THsHaServer.Args(serverSocket);
            tArgs.processor(processor);
            //指定消息的封装格式(采用二进制流封装)
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            //指定处理器的所使用的线程池
            tArgs.executorService(Executors.newFixedThreadPool(100));
            //启动服务
            THsHaServer server = new THsHaServer(tArgs);
            server.serve();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void main(String[] args) {
        HelloNonServerDemo server = new HelloNonServerDemo();
        server.startServer();
    }
}
