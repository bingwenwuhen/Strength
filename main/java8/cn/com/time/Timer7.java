package cn.com.time;

import java.time.LocalTime;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Timer7 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2);
        System.out.println("Time after 2 hours: " + newTime);

    }
}
