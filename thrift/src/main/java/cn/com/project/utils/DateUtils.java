package cn.com.project.utils;

import java.text.SimpleDateFormat;

/**
 * Created by xiaxuan on 16/9/5.
 * 高并发日期处理类
 */
public class DateUtils {
    public final static String FORMATE_DATE = "yyyy-MM-dd";
    public final static String FORMATE_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMATE_DATE_ZH = "yyyy年MM月dd日";
    public final static String FORMATE_DATETIME_ZH = "yyyy年MM月dd日 HH时mm分ss秒";

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
    private static final Object object = new Object();

    /**
     * 禁止实例化
     */
    private DateUtils() {}
}
