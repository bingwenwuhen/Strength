package cn.com.lambda;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Lambda2 {

    public static void main(String[] args) {
        //使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }).start();
        //使用lambda expression
        new Thread(()->System.out.println("hello world")).start();

        //使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        //使用lambda expression
        Runnable race2 = () -> System.out.println("Hello World!");
        //直接调用run方法(没开新线程)
        race1.run();
        race2.run();
    }

}
