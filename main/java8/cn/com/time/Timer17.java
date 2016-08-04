package cn.com.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Timer17 {
    public static void main(String[] args) {
        LocalDate arrivalDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
        String loading = arrivalDate.format(format);
        System.out.printf("Arriving at : %s %n" , arrivalDate);
    }
}
