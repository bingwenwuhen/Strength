package cn.com.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Client {

    public static final String HOST = "tcp://hadoop1:1883";
    public static final String TOPIC = "toclient/124";
    private static final String clientid = "client124";
    private MqttClient client;
    private MqttConnectOptions  options;
    private String userName = "";
    private String password = "";

    private ScheduledExecutorService scheduledExecutorService;

    private void start() {
        try {
            //host为主机名，clientid即为连接Mqtt的客户端id，一般以唯一标识符，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(HOST, clientid, new MqttDefaultFilePersistence());
            //MQTT的连接设置
            options = new MqttConnectOptions();
            //设置是否清空session，这里如果设置false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接服务器都以新的身份连接
            options.setCleanSession(true);
            //设置连接的用户名
            //options.setUserName("");
            //设置连接的密码
            //options.setPassword("".toCharArray());
            //设置超时时间
            options.setConnectionTimeout(10);
            //设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法没有重连机制
            options.setKeepAliveInterval(20);
            //设置回调
            client.setCallback(new PushCallback());
            MqttTopic topic = client.getTopic(TOPIC);
            //setWill方法，如果项目中需要知道客户端是否掉线是否可以调用该方法，设置最终端口的通知消息
            options.setWill(topic, "close".getBytes(), 2, true);
            client.connect(options);
            //订阅消息
            int[] Qos = {1};
            String[] topic1 = {TOPIC};
            client.subscribe(topic1, Qos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
