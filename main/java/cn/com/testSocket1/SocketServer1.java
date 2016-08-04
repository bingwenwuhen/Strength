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
     * ��־
     */
    private static final Log Logger = LogFactory.getLog(SocketServer1.class);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(83);

        try {
            while (true) {
                //����JAVAͨ��JNI�������ϵͳ����һֱ�ȴ�����ϵͳ���ؽ��(���߳���)
                Socket socket = serverSocket.accept();
                //����������ȡ��Ϣ(���ﻹ������ʽ�ģ�һֱ�ȴ�ֱ�������ݿ��Խ���)
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Integer sourcePort = socket.getPort();
                int maxLen = 2048;
                byte[] contextBytes = new byte[maxLen];
                int realLen;
                StringBuffer message = new StringBuffer();
                //read��ʱ�򣬳���Ҳ��������ֱ������ϵͳ�����紫��������׼����
                while ((realLen = in.read(contextBytes, 0, maxLen)) != -1) {
                    message.append(new String(contextBytes, 0, realLen));
                    /**
                     * ���Ǽ����ȡ����over���ؼ���
                     * ��ʾ�ͻ���������Ϣ�ھ������ɴδ��ͺ����
                     */
                    if (message.indexOf("over") != -1) {
                        break;
                    }
                }
                //�����ӡ��Ϣ
                SocketServer1.Logger.info("received from port: " + socket  + " message: " + message);
                //���濪ʼ������Ϣ
                out.write("response message!".getBytes());
                //�ر�
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
