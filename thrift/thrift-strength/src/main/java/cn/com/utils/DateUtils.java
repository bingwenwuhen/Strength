package cn.com.utils;

import cn.com.exception.BizException;
import cn.com.exception.ResponseCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * 获取SimpleDateFormat
     * @param pattern   日期格式
     * @return          SimpleDateFormat对象
     */
    private static SimpleDateFormat getDateFormat(String pattern) {
        SimpleDateFormat dateFormat = threadLocal.get();
        if (dateFormat == null) {
            synchronized (object) {
                if(dateFormat == null) {
                    dateFormat = new SimpleDateFormat(pattern);
                    dateFormat.setLenient(false);
                    threadLocal.set(dateFormat);
                }
            }
        }
        dateFormat.applyPattern(pattern);
        return dateFormat;
    }

    /**
     * 将日期字符串转化为日期，日期字符串为空返回null
     * @param dateStr   日期字符串
     * @param pattern   日期格式
     * @return          格式化后的日期
     * @throws BizException 日期格式化错误异常
     */
    public static Date parseDate(String dateStr, String pattern) throws BizException {
        Date formatDate = null;
        if (dateStr != null && !dateStr.trim().equals("")) {
            try {
                formatDate = getDateFormat(pattern).parse(dateStr);
            } catch (ParseException e) {
                throw new BizException("字符串转换成日期异常", ResponseCode._402);
            }
        }
        return formatDate;
    }

    /**
     * 将日期转化为日期字符串，日期为null返回字符串为null
     * @param date      日期
     * @param pattern   日期格式
     * @return          日期字符串
     */
    public static String formatDate(Date date, String pattern) {
        String formatDateStr = null;
        if (date != null) {
            formatDateStr = getDateFormat(pattern).format(date);
        }
        return formatDateStr;
    }

    /**
     * 将时间转换成，指定格式的日期   date
     * @param date  日期是时间戳  长整型
     * @param pattern   日期格式
     * @return          日期字符串
     */
    public static String formatDate(long date, String pattern) {
        return getDateFormat(pattern).format(date);
    }
}
