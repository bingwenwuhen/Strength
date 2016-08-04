package cn.com.mqtt;

/**
 * Created by Administrator on 2016/6/11.
 */
public class MqttBroker {

    private final String CONNECTION_STRING = "tcp://hadoop1:1883";
    private final static boolean CLEAN_START = true;
    private final static short KEEP_ALIVE = 30; //低耗网络，但是又需要及时获取数据，心跳30秒
    private final static String CLIENT_ID = "master";   //客户端标识
    private final static int[] QOS_VALUES = {0, 0, 2, 0};   //对应主题的消息级别
    private final static String[] TOPICS = {
            "Test/TestTopics/Topic1", "Test/TestTopics/Topic2", "Test/TestTopics/Topic3",
            "client/keeplive"
    };
    private static MqttBroker instance = new MqttBroker();
    //private



}
