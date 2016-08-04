package cn.com.Int;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/6/9.
 */
public class Sample2 {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void increment() {
        count.getAndIncrement();
    }

}
