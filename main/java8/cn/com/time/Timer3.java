package cn.com.time;

import java.time.LocalDate;

/**
 * Created by Administrator on 2016/8/4.
 */
public class Timer3 {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int mounth = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Mounth : %d day : %d \t%n", year, mounth, day);
    }
}
