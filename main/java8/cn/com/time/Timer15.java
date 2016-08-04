package cn.com.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Timer15 {
    public static void main(String[] args) {
        String dayAfterTommrow = "20140116";
        LocalDate formatted =LocalDate.parse(dayAfterTommrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from string %s is %s %n", dayAfterTommrow, formatted);
    }
}
