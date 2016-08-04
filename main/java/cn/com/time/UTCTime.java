package cn.com.time;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/3.
 */
public class UTCTime {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTime());
    }

}
