package cn.com.time;

import java.time.LocalDate;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Timer12 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.println("this year is leap year");
        } else {
            System.out.println("2014 is not a leap year");
        }
    }
}
