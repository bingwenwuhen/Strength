package cn.com.mqtt;

/**
 * Created by Administrator on 2016/6/11.
 */
public class MqttBroker {

    private final String CONNECTION_STRING = "tcp://hadoop1:1883";
    private final static boolean CLEAN_START = true;
    private final static short KEEP_ALIVE = 30; //�ͺ����磬��������Ҫ��ʱ��ȡ���ݣ�����30��
    private final static String CLIENT_ID = "master";   //�ͻ��˱�ʶ
    private final static int[] QOS_VALUES = {0, 0, 2, 0};   //��Ӧ�������Ϣ����
    private final static String[] TOPICS = {
            "Test/TestTopics/Topic1", "Test/TestTopics/Topic2", "Test/TestTopics/Topic3",
            "client/keeplive"
    };
    private static MqttBroker instance = new MqttBroker();
    //private



}
