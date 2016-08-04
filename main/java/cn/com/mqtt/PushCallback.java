package cn.com.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * 发布消息的回调类
 *
 * 必须实现MqttCallback的接口并实现对应的相关方法接口CallBack类将实现MqttCallBack。
 * 每个客户机标识都需要一个回调实例。在此实例中，构造函数传递客户机标识以另存为示例数据。
 * 在回调中，将它用来标识已经启动了该回调的那个实例。
 * 必须在回调中实现3个方法：
 *  public void messageArrived(MqttTopic topic, MqttMessage message)接收已经预订的发布。
 *
 *  public void connectionLost(Throwable cause)在断开连接时调用。
 *
 *  public void deliveryComplete(MqttDeliveryToken token))
 *  接收到已经发布的 QoS 1 或 QoS 2 消息的传递令牌时调用。
 *  由 MqttClient.connect 激活此回调。
 */
public class PushCallback implements MqttCallback{
    public void connectionLost(Throwable throwable) {
        //连接丢失后，一般在这里面进行重连
        System.out.println("reconnecting...... ");
    }

    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        //subscribe后得到的消息会执行到这里面
        //接收消息主题
        System.out.println("receive topic: " + topic);
        //接收消息Qos
        System.out.println("receive message Qos: " + mqttMessage.getQos());
        //接收消息内容
        System.out.println("receive message content: " + new String(mqttMessage.getPayload()));
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete---------" + iMqttDeliveryToken.isComplete());
    }
}
