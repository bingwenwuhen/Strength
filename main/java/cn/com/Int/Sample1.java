package cn.com.Int;

/**
 * Created by Administrator on 2016/6/9.
 */
public class Sample1 {

    private static Integer count = 0;

    synchronized public static void increment() {
        count++;
    }

}
