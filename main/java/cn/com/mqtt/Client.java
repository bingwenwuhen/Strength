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
            //hostΪ��������clientid��Ϊ����Mqtt�Ŀͻ���id��һ����Ψһ��ʶ����MemoryPersistence����clientid�ı�����ʽ��Ĭ��Ϊ���ڴ汣��
            client = new MqttClient(HOST, clientid, new MqttDefaultFilePersistence());
            //MQTT����������
            options = new MqttConnectOptions();
            //�����Ƿ����session�������������false��ʾ�������ᱣ���ͻ��˵����Ӽ�¼����������Ϊtrue��ʾÿ�����ӷ����������µ��������
            options.setCleanSession(true);
            //�������ӵ��û���
            //options.setUserName("");
            //�������ӵ�����
            //options.setPassword("".toCharArray());
            //���ó�ʱʱ��
            options.setConnectionTimeout(10);
            //���ûỰ����ʱ�� ��λΪ�� ��������ÿ��1.5*20���ʱ����ͻ��˷��͸���Ϣ�жϿͻ����Ƿ����ߣ����������û����������
            options.setKeepAliveInterval(20);
            //���ûص�
            client.setCallback(new PushCallback());
            MqttTopic topic = client.getTopic(TOPIC);
            //setWill�����������Ŀ����Ҫ֪���ͻ����Ƿ�����Ƿ���Ե��ø÷������������ն˿ڵ�֪ͨ��Ϣ
            options.setWill(topic, "close".getBytes(), 2, true);
            client.connect(options);
            //������Ϣ
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
