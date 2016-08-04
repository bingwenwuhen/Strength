package cn.com.testSocket1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/6/21.
 */
public class SocketServer1 {

    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log Logger = LogFactory.getLog(SocketServer1.class);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(83);

        try {
            while (true) {
                //这里JAVA通过JNI请求操作系统，并一直等待操作系统返回结果(或者出错)
                Socket socket = serverSocket.accept();
                //下面我们收取信息(这里还是阻塞式的，一直等待直到有数据可以接受)
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Integer sourcePort = socket.getPort();
                int maxLen = 2048;
                byte[] contextBytes = new byte[maxLen];
                int realLen;
                StringBuffer message = new StringBuffer();
                //read的时候，程序也会阻塞，直到操作系统把网络传来的数据准备好
                while ((realLen = in.read(contextBytes, 0, maxLen)) != -1) {
                    message.append(new String(contextBytes, 0, realLen));
                    /**
                     * 我们假设读取到“over”关键字
                     * 表示客户端所有信息在经过若干次传送后，完成
                     */
                    if (message.indexOf("over") != -1) {
                        break;
                    }
                }
                //下面打印信息
                SocketServer1.Logger.info("received from port: " + socket  + " message: " + message);
                //下面开始发送信息
                out.write("response message!".getBytes());
                //关闭
                out.close();
                in.close();
                socket.close();
            }
        } catch (Exception e) {
            SocketServer1.Logger.error(e.getMessage(), e);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

}
