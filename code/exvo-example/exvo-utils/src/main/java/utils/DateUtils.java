package utils;

import java.time.*;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.*;

/**
 * @Date: 2019/4/22
 * @Author: wu yang
 * @Description:日期工具类
 */
public class DateUtils {

    public static final String YEAR = "YEAR";
    public static final String MONTH = "MONTH";
    public static final String DAY = "DAY";
    public static final String HOUR = "HOUR";
    public static final String MINUTE = "MINUTE";
    public static final String SECOND = "SECOND";

    /**
     * Date转换成LocalDateTime，默认时区
     * @param date
     * @return
     */
    public static LocalDateTime conversionDateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * Date转换成LocalDateTime
     * @param date
     * @param zoneId 时区
     * @return
     */
    public static LocalDateTime conversionDateToLocalDate(Date date, ZoneId zoneId) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * LocalDate转换成LocalDateTime
     * @param localDate
     * @return
     */
    public static LocalDateTime conversionLocalDateToLocalDate(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MIN);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * 创建日期，通过年月日
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static LocalDate createDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    /**
     * 创建日期，通过年月日时分秒
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static LocalDateTime createDate(int year, int month, int day, int hour, int minute, int second) {
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

    /**
     * 获取年月日
     * @param localDate
     * @return
     */
    public static Map<String, Integer> getYearMonthDay(LocalDate localDate) {
        Map<String, Integer> result = new HashMap<>();
        result.put(YEAR, localDate.getYear());
        result.put(MONTH, localDate.getMonthValue());
        result.put(DAY, localDate.getDayOfMonth());
        return result;
    }

    /**
     * 获取年月日时分秒
     * @param localDateTime
     * @return
     */
    public static Map<String, Integer> getYearMonthDayHour(LocalDateTime localDateTime) {
        Map<String, Integer> result = new HashMap<>();
        result.put(YEAR, localDateTime.getYear());
        result.put(MONTH, localDateTime.getMonthValue());
        result.put(DAY, localDateTime.getDayOfMonth());
        result.put(HOUR, localDateTime.getHour());
        result.put(MINUTE, localDateTime.getMinute());
        result.put(SECOND, localDateTime.getSecond());
        return result;
    }

    /**
     * 比较两个日期大小
     * @param date1
     * @param date2
     * @return
     */
    public static int compareTo(LocalDateTime date1, LocalDateTime date2) {
        return date1.compareTo(date2);
    }

    /**
     * 日期时间增加或减少
     * @param localDateTime
     * @param param
     * @param chronoUnit
     * @return
     */
    public static LocalDateTime plus(LocalDateTime localDateTime, int param, ChronoUnit chronoUnit) {
        return localDateTime.plus(param, chronoUnit);
    }

    /**
     * String 转 LocalDate
     * @param dateStr
     * @param formatter
     * @return
     */
    public static LocalDate parseLocalDate(String dateStr, DateTimeFormatter formatter) {
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * String 转 LocalDateTime
     * @param dateStr
     * @param formatter
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String dateStr, DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateStr, formatter);
    }

    /**
     * 日期相隔天数
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(LocalDateTime startInclusive, LocalDateTime endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(LocalDateTime startInclusive, LocalDateTime endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    public static void main(String[] args) {
        System.out.println(durationHours(createDate(2018,1,2,23,23,23), createDate(2018,1,3,23,23,23)));
    }

}


