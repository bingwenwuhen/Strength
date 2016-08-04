package cn.com.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * ������Ϣ�Ļص���
 *
 * ����ʵ��MqttCallback�Ľӿڲ�ʵ�ֶ�Ӧ����ط����ӿ�CallBack�ཫʵ��MqttCallBack��
 * ÿ���ͻ�����ʶ����Ҫһ���ص�ʵ�����ڴ�ʵ���У����캯�����ݿͻ�����ʶ�����Ϊʾ�����ݡ�
 * �ڻص��У�����������ʶ�Ѿ������˸ûص����Ǹ�ʵ����
 * �����ڻص���ʵ��3��������
 *  public void messageArrived(MqttTopic topic, MqttMessage message)�����Ѿ�Ԥ���ķ�����
 *
 *  public void connectionLost(Throwable cause)�ڶϿ�����ʱ���á�
 *
 *  public void deliveryComplete(MqttDeliveryToken token))
 *  ���յ��Ѿ������� QoS 1 �� QoS 2 ��Ϣ�Ĵ�������ʱ���á�
 *  �� MqttClient.connect ����˻ص���
 */
public class PushCallback implements MqttCallback{
    public void connectionLost(Throwable throwable) {
        //���Ӷ�ʧ��һ�����������������
        System.out.println("reconnecting...... ");
    }

    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        //subscribe��õ�����Ϣ��ִ�е�������
        //������Ϣ����
        System.out.println("receive topic: " + topic);
        //������ϢQos
        System.out.println("receive message Qos: " + mqttMessage.getQos());
        //������Ϣ����
        System.out.println("receive message content: " + new String(mqttMessage.getPayload()));
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete---------" + iMqttDeliveryToken.isComplete());
    }
}
