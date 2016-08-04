package cn.com.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Timer11 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2014, 1, 15);
        if (tomorrow.isAfter(today)) {
            System.out.println("Tomorrow cames after today.");
        }
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }
    }
}
