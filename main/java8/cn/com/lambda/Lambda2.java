package cn.com.lambda;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Lambda2 {

    public static void main(String[] args) {
        //ʹ�������ڲ���
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }).start();
        //ʹ��lambda expression
        new Thread(()->System.out.println("hello world")).start();

        //ʹ�������ڲ���
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        //ʹ��lambda expression
        Runnable race2 = () -> System.out.println("Hello World!");
        //ֱ�ӵ���run����(û�����߳�)
        race1.run();
        race2.run();
    }

}
