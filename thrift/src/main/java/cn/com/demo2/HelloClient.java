package cn.com.demo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.HelloService;
import thrift.HelloWorldService;
import thrift.Reponse;
import thrift.Request;

/**
 * Created by xiaxuan on 16/8/25.
 * 同样是基于同步阻塞模型的thrift client
 */
public class HelloClient {

    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(HelloClient.class);

    public static void main(String[] args) throws TException {
        //服务器所在的ip和端口
        TSocket transport = new TSocket("127.0.0.1", 9111);
        TProtocol protocol = new TBinaryProtocol(transport);

        //准备调用参数
        Request request = new Request("{\"param\":\"field1\"}", "\\mySerivce\\queryService");
        HelloService.Client client = new HelloService.Client(protocol);
        //准备传输
        transport.open();
        //正是调用接口
        Reponse reponse = client.send(request);
        //一定记住要关闭
        HelloClient.LOGGER.info("response = " + reponse);
    }
}
