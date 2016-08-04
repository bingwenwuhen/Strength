package cn.com.time;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * Created by Administrator on 2016/8/4.
 */
public class Timer5 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2010, 7, 31);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day!");
        } else {
            System.out.println("Sorry, today is not your birthday!");
        }
    }
}
