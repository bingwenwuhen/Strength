package cn.com.time;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by Administrator on 2016/8/4.
 */
public class Timer1 {

    public static void main(String[] args) {
        Instant start = Instant.now();
        for (int i = 0;i < 30000000; i++) {

        }
        Instant end = Instant.now();
        System.out.println("start " + start + " end " + end);
        Duration timeElapsed = Duration.between(start, end);
        long millis = timeElapsed.toMillis();
        System.out.println(millis);
    }

}
