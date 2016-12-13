package cn.com.demo1;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.HelloWorldService;

/**
 * Created by xiaxuan on 16/8/25.
 */
public class HelloServerDemo {

    public static final int SERVER_PORT = 8090;

    public static void main(String[] args) throws TTransportException {
        HelloServerDemo server = new HelloServerDemo();
        server.startServer();
    }

    public void startServer() throws TTransportException {
        System.out.println("HelloWorld TSimpleServer start...");
        HelloWorldService.Processor<HelloWorldService.Iface> tprocessor = new HelloWorldService.Processor<>(new HelloServiceImpl());
        //简单的单线程服务模型，一般用于测试
        TServerSocket serverSocket = new TServerSocket(SERVER_PORT);
        TServer.Args args = new TServer.Args(serverSocket);
        args.processor(tprocessor);
        args.protocolFactory(new TCompactProtocol.Factory());
        TServer server = new TSimpleServer(args);
        server.serve();
    }
}
