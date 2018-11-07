package com.example.demo.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Date: 2018/11/6
 * @Author: wu yang
 * @Description:
 */
public class DateTest {

    /**
     * 日期格式:完整日期(yyyy-MM-dd HH:mm:ss,S)
     */
    public static final SimpleDateFormat DATE_TIME_FORMAT_EXAC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");

    /**
     * 日期格式:完整日期(yyyy-MM-dd 00:00:00)
     */
    public static final SimpleDateFormat DATE_TIME_FORMAT_ZERO = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

    /**
     * 日期格式:完整日期(yyyy-MM-dd 23:59:59)
     */
    public static final SimpleDateFormat DATE_TIME_FORMAT_LAST = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

    public static void main(String[] args) {

        String startDate = "2018-11-01 00:00:00";
        String startTimeStamp = "1541001600000";

        String endDate = "2018-11-06 23:59:59";
        String endTimeStamp = "1541433600000";

        System.out.println(startDate + "  转成时间戳： " + dateToTimeStamp(startDate, DATE_TIME_FORMAT_ZERO));
        System.out.println(endDate + "  转成时间戳： " + dateToTimeStamp(endDate, DATE_TIME_FORMAT_LAST));

        System.out.println(startTimeStamp + "  转成时间： " + timeStampToDate(startTimeStamp, DATE_TIME_FORMAT_EXAC));
        System.out.println(endTimeStamp + "  转成时间： " + timeStampToDate(endTimeStamp, DATE_TIME_FORMAT_EXAC));
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStampToDate(String seconds, DateFormat format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        return format.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateToTimeStamp(String date_str, DateFormat format) {
        try {
            return String.valueOf(format.parse(date_str).getTime() /10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 日期转换成时间戳
     *
     * @param date 日期
     * @return
     */
    public static String dateToTimeStamp(Date date) {
        try {
            return String.valueOf(date.getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 两个日期之间相差天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int differentDays(Date startDate, Date endDate) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endDate);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        //同一年
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                //闰年
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            return day2 - day1;
        }
    }

}
