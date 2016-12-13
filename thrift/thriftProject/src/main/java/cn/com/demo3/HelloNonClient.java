package cn.com.demo3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientFactory;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingSocket;
import thrift.HelloService;
import thrift.Reponse;
import thrift.Request;

import java.io.IOException;

/**
 * Created by xiaxuan on 16/8/25.
 */
public class HelloNonClient {

    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(HelloNonClient.class);

    private static Object WAITOBJECT = new Object();

    public static void main(String[] args) throws IOException, TException, InterruptedException {
        TNonblockingSocket transport = new TNonblockingSocket("127.0.0.1", 8090);
        TAsyncClientManager clientManager = new TAsyncClientManager();
        //准备调用参数
        Request request = new Request("{\"param\":\"field1\"}", "\\mySerivce\\queryService");
        //这是客户端对非阻塞异步网络t通信方式的支持
        //注意使用的消息封装格式，一定要和服务端使用的一致
        HelloService.AsyncClient client = new HelloService.AsyncClient.Factory(clientManager, new TBinaryProtocol.Factory()).getAsyncClient(transport);
        //既然是非阻塞异步模式，所以客户端一定是通过“事件回调”方式，接收到服务器的响应通知的
        client.send(request, new AsyncMethodCallback<HelloService.AsyncClient.send_call>() {
            /**
             * 当服务端正确响应了客户端的请求后，这个事件被触发
             * @param o
             */
            @Override
            public void onComplete(HelloService.AsyncClient.send_call call) {
                Reponse reponse = null;
                try {
                    reponse = call.getResult();
                } catch (TException e) {
                    e.printStackTrace();
                }
                LOGGER.info("reponse " + reponse);
            }

            /**
             * 当服务器没有正确响应客户端的请求，或者其中过程中出现了不可控制的情况
             * 那么这个事件会被触发
             * @param e
             */
            @Override
            public void onError(Exception e) {
                LOGGER.error("exception " + e);
            }
        });

        //这段代码保证客户端在得到服务器回复前，应用程序本身不会终止
        synchronized (HelloNonClient.WAITOBJECT) {
            HelloNonClient.WAITOBJECT.wait();
        }
    }
}
