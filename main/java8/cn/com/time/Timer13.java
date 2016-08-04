package cn.com.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Timer13 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println(java8Release.getMonthValue());
        System.out.println("Mounths left between today and java8 release : " + periodToNextJavaRelease.getMonths());
    }
}
