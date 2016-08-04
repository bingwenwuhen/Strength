package cn.com.time;

import java.time.Clock;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Timer10 {
    public static void main(String[] args) {
        //return the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("clock : " + clock.millis());
        //return time based on system clock zone clock defaultClock =
        Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);
    }
}
