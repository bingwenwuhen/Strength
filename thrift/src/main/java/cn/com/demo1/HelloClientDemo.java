package cn.com.demo1;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.HelloWorldService;

/**
 * Created by xiaxuan on 16/8/25.
 */
public class HelloClientDemo {

    public static final String SERVER_IP = "localhost";
    public static int SERVER_PORT = 8090;
    public final int TIMEOUT = 30000;

    public static void main(String[] args) throws TException {
        HelloClientDemo client = new HelloClientDemo();
        client.startClient("xiaxuan");
    }

    public void startClient(String userName) throws TException {
        TTransport tTransport = null;
        Long t1 = System.currentTimeMillis();
        tTransport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        TProtocol protocol = new TCompactProtocol(tTransport);
        HelloWorldService.Client client = new HelloWorldService.Client(protocol);
        tTransport.open();
        String result = client.sayHello(userName);
        System.out.println("spend time " + (System.currentTimeMillis() - t1));
        System.out.println("Thrift client result " + result);
        if (tTransport != null) {
            tTransport.close();
        }
    }
}
