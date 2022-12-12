package com.lgd.util;

import com.alibaba.excel.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @author muhong
 * @description: 时间工具类
 * @date: 2018-09-18
 */
@Slf4j
public class DateUtils {

    /**
     * 完整时间：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式  hh:mm
     */
    public static final String DEFAULT_DATE_FORMAT_HH_SS = "HH:mm";
    /**
     * 时间格式：yyyy-MM-dd HH:mm
     */
    public static final String DEFAULT_DATE_NO_SECOND = "yyyy-MM-dd HH:mm";
    /**
     * 无时分秒：yyyy-MM-dd
     */
    public static final String DATE_FORMAT_NO_HOUR = "yyyy-MM-dd";

    /**
     * 年月日时分秒(无下划线)：yyyyMMddHHmmss
     */
    public static final String LONG_DATE_FORMAT = "yyyyMMddHHmmss";

    /**
     * 无日无时分秒：yyyyMM
     */
    public static final String DATE_FORMAT_NO_DAY = "yyyyMM";

    /**
     * 带毫秒时间：yyyy-MM-dd HH:mm:ss.S
     */
    public static final String MILLISECOND_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 文件工厂日期
     */
    public static final String DATE_FORMAT_FOR_FILE = "yyyyMMdd";

    /**
     * 年月日
     */
    public static final String DATE_FORMAT_FOR_YEAR_MONTH_DAY = "yyMMdd";

    /**
     * 乘车记录日期格式
     */
    public static final String DATE_FORMAT_HOUR_SECOND = "MM-dd HH:mm";

    /**
     * 开始基准时间
     */
    public static final String START_BASE_TIME = " 00:00:00";

    /**
     * 结束基准时间
     */
    public static final String END_BASE_TIME = " 23:59:59";
    /**
     * 季节月份映射数组
     */
    private final static int[] SEASON = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
    /**
     * 时间格式化对象
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtils.DEFAULT_DATE_FORMAT);
    /**
     * 时间秒的最大值    59s
     */
    private static final int SECOND_MAX_VALUE = 59;
    /**
     * 时间秒的最小值    0s
     */
    private static final int SECOND_MIN_VALUE = 0;

    /**
     * 格式化时间秒的阈值
     *
     * @param originalDate  原时间
     * @param thresholdFlag 阈值标志        true：秒的上限：59s
     *                      false:秒的下限: 00s
     *                      <p>
     *                      <code>System.out.println(originalDate)  = Thu Jan 03 15:24:51 CST 2019</code>
     *                      <code>System.out.println(secondThreshold(originalDate, true)) = Thu Jan 03 15:24:59 CST 2019</code>
     *                      <code>System.out.println(secondThreshold(originalDate, false)) = Thu Jan 03 15:24:00 CST 2019</code>
     *                      </p>
     * @return
     */
    public static Date secondThreshold(final Date originalDate, final boolean thresholdFlag) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalDate);
        if (thresholdFlag) {
            calendar.set(Calendar.SECOND, SECOND_MAX_VALUE);
        } else {
            calendar.set(Calendar.SECOND, SECOND_MIN_VALUE);
        }
        return calendar.getTime();
    }

    /**
     * long转化为Date类型
     *
     * @param dateLong long 类型的时间格式
     * @return
     */
    public static Date long2Date(Long dateLong) {
        return new Date(dateLong);
    }

    /**
     * 获取date是当年第几个月        从1到12
     * <p>
     * <code>DateUtils.getMonthofYear(new Date()) = "12"    //2017-12-25执行
     * <code>DateUtils.getMonthofYear(new Date()) = "01"    //2018-01-09执行
     * </p>
     *
     * @param date
     * @return
     */
    public static final String getMonthofYear(final Date date) {
        if (null == date) {
            return null;
        }

        String fileDate = fileDateFormat(date);
        if (null == fileDate) {
            return null;
        }
        return fileDate.substring(fileDate.length() - 4, fileDate.length() - 2);
    }

    /**
     * 获取date是当月第几天     从1到31
     * <p>
     * <code>DateUtils.getDayofMonth(new Date()) = "25"    //2017-12-25执行
     * </p>
     *
     * @param date
     * @return
     */
    public static final String getDayofMonth(final Date date) {
        if (null == date) {
            return null;
        }

        String fileDate = fileDateFormat(date);
        if (null == fileDate) {
            return null;
        }
        return fileDate.substring(fileDate.length() - 2, fileDate.length());
    }

    /**
     * 日期格式化返回String类型
     * <p>
     * <p>格式：<code>"yyyyMMdd"</code></p>
     *
     * @return String
     */
    public static final String date2String(Date date) {

        return getFormat(DATE_FORMAT_FOR_FILE).format(date);
    }

    /**
     * 时间格式化为文件工厂格式
     *
     * @param date 格式化Date
     * @returnb yyyyMMdd格式的String时间串
     */
    public static final String fileDateFormat(final Date date) {
        return getFormat(DATE_FORMAT_FOR_FILE).format(date);
    }

    /**
     * yyyyMMdd 类型的string转化为date
     *
     * @param stringDate
     * @return
     * @throws ParseException
     */
    public static final Date string2Day(final String stringDate) throws ParseException {
        return getFormat(DATE_FORMAT_FOR_FILE).parse(stringDate);
    }

    /**
     * date转换成string
     *
     * @param date    Date对象
     * @param pattern 转换格式
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null || StringUtils.isBlank(pattern)) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 通过格式化字符串获取format对象
     * <p>
     * <p>格式：<code>"yyyy-MM-dd HH:mm"</code></p>
     *
     * @param format 格式化字符串
     * @return DateFormat format对象
     */
    public static final DateFormat getFormat(final String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 将日期对象<code>Date</code>转换为字符串类型输出。
     * <p>
     * <p>
     * <code>DateUtils.simpleFormat(new Date()) = "2014-11-17 18:00:00"</code>
     * </p>
     *
     * @param date 日期对象
     * @return String 输出的字符串
     * 格式：<code>yyyy-MM-dd HH:mm:ss</code>
     */
    public static final String simpleFormat(final Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(DEFAULT_DATE_FORMAT).format(date);
    }

    /**
     * 将日期对象<code>Date</code>装换为字符串类型输出
     * <p>
     * <p>
     * <code>DateUtils.longDateFormat(new Date()) = "20141117180000"
     * </p>
     *
     * @param date 日期对象
     * @return 输出的字符串
     * 格式：<code>yyyyMM</code>
     */
    public static final String noDayDateFormat(final Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(DATE_FORMAT_NO_DAY).format(date);
    }

    /**
     * 将日期对象<code>Date</code>装换为字符串类型输出
     *
     * @param date 日期
     * @return 输出的字符串   格式：yyyy-MM-dd
     */
    public static final String noHourDateFormat(final Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(DATE_FORMAT_NO_HOUR).format(date);
    }

    /**
     * 将日期对象<code>Date</code>装换为字符串类型输出
     *
     * @param date 日期
     * @return 输出的字符串   格式：yyyy-MM-dd hh:mm
     * @version $Id: DateUtils.java, v 0.1 2016年1月5日 下午2:18:15 simon.xxm Exp $
     */
    public static final String noSecDateFormat(final Date date) {
        if (date == null) {
            return "";
        }
        return getFormat(DEFAULT_DATE_NO_SECOND).format(date);
    }

    /**
     * 将日期对象<code>Date</code>装换为字符串类型输出
     * <p>
     * <p>
     * <code>DateUtils.longDateFormat(new Date()) = "20141117180000"
     * </p>
     *
     * @param date 日期对象
     * @return 输出的字符串
     * 格式：<code>yyyyMMddHHmmss</code>
     */
    public static final String longDateFormat(final Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(LONG_DATE_FORMAT).format(date);
    }

    /**
     * 比较两个日期先后顺序,秒不考虑在内
     * <p>
     * <code>DateUtils.isBeforeByDay("2018-05-25 10:47:01","2018-05-25 10:47:11") = 0</code>
     * <code>DateUtils.isBeforeByDay("2018-05-25 10:48:00","2018-05-25 10:47:50") = 1</code>
     * <code>DateUtils.isBeforeByDay("2018-05-25 10:44:45","2018-05-25 10:45:05") = -1</code>
     * </p>
     *
     * @param startDate
     * @param endDate
     * @return 当startDate与endDate是同一年同一月同一天同一小时同一分钟时，return 0;
     */
    public static final int isBeforeByMinute(final Date startDate, final Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);

        return startCalendar.compareTo(endCalendar);
    }

    /**
     * 比较两个日期先后顺序,时分秒不考虑在内
     * <p>
     * <code>DateUtils.isBeforeByDay("2016-12-05 18:00:00","2016-12-05 18:00:00) = 0</code>
     * <code>DateUtils.isBeforeByDay("2016-12-05 18:00:00","2016-12-04 18:00:00) = 1</code>
     * <code>DateUtils.isBeforeByDay("2016-12-05 18:00:00","2016-12-06 18:00:00) = -1</code>
     * </p>
     *
     * @param startDate
     * @param endDate
     * @return 当date1与date2是同一年同一月同一天时，return 0;
     * 当date1晚于date2时,return -1;
     * 当date1早于date2时,return 1;
     */
    public static final int isBeforeByDay(final Date startDate, final Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        endCalendar.set(Calendar.HOUR_OF_DAY, 0);
        endCalendar.set(Calendar.MINUTE, 0);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);

        return startCalendar.compareTo(endCalendar);
    }

    /**
     * 将日期格式字符串转换为日期时间
     * <p>
     * <p>
     * <code>DateUtils.string2DateTime("2014-11-17 18:00:00") = Date</code>
     * </p>
     *
     * @param stringDate 时间格式字符串
     *                   格式：<code>yyyy-MM-dd HH:mm:ss</code>
     * @return 日期时间
     * 字符串空返回<code>null</code>，异常返回<code>null</code>
     */
    public static final Date string2DateTime(final String stringDate) {

        if (null == stringDate) {
            return null;
        }

        try {
            return getFormat(DEFAULT_DATE_FORMAT).parse(stringDate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将日期格式字符串转换为日期时间
     * <p>
     * <p>
     * <code>DateUtils.string2Date("2014-11-17") = Date</code>
     * </p>
     *
     * @param stringDate 时间格式字符串
     *                   格式：<code>yyyy-MM-dd</code>
     * @return 日期时间
     * 字符串空返回<code>null</code>，异常返回<code>null</code>
     */
    public static final Date string2DateNoHour(final String stringDate) {

        if (null == stringDate) {
            return null;
        }

        try {
            return getFormat(DATE_FORMAT_NO_HOUR).parse(stringDate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取日期加减(秒)的日期
     * <p>
     * <p>
     * <code>DateUtils.getDiffSecondDateTime(2014-11-17 18:00:05,1)  = 2014-11-17 18:00:06</code>
     * <code>DateUtils.getDiffSecondDateTime(2014-11-17 18:00:05,-1) = 2014-11-17 18:00:04</code>
     * </p>
     *
     * @param diffSecond 差异多少秒
     * @return 计算后日期
     */
    public static final Date getDiffSecondDateTime(final Date date, final int diffSecond) {

        Calendar c = Calendar.getInstance();

        c.setTime(date);
        c.add(Calendar.SECOND, diffSecond);

        return c.getTime();
    }

    /**
     * 将"yyyy-MM-dd HH:mm:ss"格式的字符串转换为日期
     *
     * @param formatString 日期格式字符串
     * @return 日期对象
     */
    public static final Date formatStringToDate(final String formatString) throws ParseException {
        if (null == formatString) {
            return null;
        }
        DateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return format.parse(formatString);

    }

    /**
     * 将"yyyyMMddHHmmss"格式的字符串转换为日期
     *
     * @param formatString 日期格式字符串
     * @return 日期对象
     */
    public static final Date formatLongToDate(final String formatString) {
        if (null == formatString) {
            return null;
        }
        try {
            DateFormat format = new SimpleDateFormat(LONG_DATE_FORMAT);
            return format.parse(formatString);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 获取currentDate的间隔hours的时间
     *
     * @param currentDate 当前时间
     * @param minute      间隔时间分钟
     *                    <p>
     *                    <code>Date mewDate = new Date()</code>
     *                    <code>System.out.println(simpleFormat(mewDate)) == 2018-05-11 17:20:57</code>
     *                    <code>System.out.println(simpleFormat(rollDateByMinute(mewDate,6))) == 2018-05-11 17:26:57</code>
     *                    <code>System.out.println(simpleFormat(rollDateByMinute(mewDate,-6))) == 2018-05-11 17:14:57</code>
     *                    </p>
     * @return
     */
    public static Date rollDateByMinute(final Date currentDate, final int minute) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        if (currentDate != null) {
            calendar.setTime(currentDate);
        }
        calendar.add(Calendar.MINUTE, minute);
        return new Date(calendar.getTime().getTime());
    }

    /**
     * 获取currentDate的间隔hours的时间
     *
     * @param currentDate 当前时间
     * @param hours       间隔时间小时
     *                    <p>
     *                    <code>System.out.println(longDateFormat(rollDateByHour(new Date(),-2)))  = 20180109122755</code>
     *                    <code>System.out.println(longDateFormat(rollDateByHour(new Date(),-15))) = 20180108232755</code>
     *                    <code>System.out.println(longDateFormat(rollDateByHour(new Date(),-16)))  = 20180108222755</code>
     *                    <code>System.out.println(longDateFormat(rollDateByHour(new Date(),-17))) = 20180108212755</code>
     *                    <code>System.out.println(longDateFormat(rollDateByHour(new Date(),-18)))  = 20180108202755</code>
     *                    </p>
     * @return
     */
    public static Date rollDateByHour(final Date currentDate, final int hours) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        if (currentDate != null) {
            calendar.setTime(currentDate);
        }
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return new Date(calendar.getTime().getTime());
    }

    /**
     * 根据当前日期计算出与当前日期间隔天数的日期
     *
     * @param currentDate
     * @param day
     * @return
     */
    public static Date rollDateByDay(final Date currentDate, final int day) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        if (currentDate != null) {
            calendar.setTime(currentDate);
        }
        calendar.add(Calendar.DATE, day);
        return new Date(calendar.getTime().getTime());
    }

    /**
     * 根据当前日期计算出与当前日期间隔周数的日期
     *
     * @param currentDate
     * @param week
     * @return
     */
    public static Date rollDateByWeek(final Date currentDate, final int week) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        if (currentDate != null) {
            calendar.setTime(currentDate);
        }
        calendar.add(Calendar.WEDNESDAY, week);
        return new Date(calendar.getTime().getTime());
    }

    /**
     * 根据当前日期计算出与当前日期间隔月数的日期
     *
     * @param currentDate
     * @param month
     * @return
     */
    public static Date rollDateByMonth(final Date currentDate, final int month) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        if (currentDate != null) {
            calendar.setTime(currentDate);
        }
        calendar.add(Calendar.MONTH, month);
        return new Date(calendar.getTime().getTime());
    }

    /**
     * 根据当前日期计算出与当前日期间隔年数的日期
     *
     * @param currentDate
     * @param year
     * @return
     */
    public static Date rollDateByYear(final Date currentDate, final int year) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        if (currentDate != null) {
            calendar.setTime(currentDate);
        }
        calendar.add(Calendar.YEAR, year);
        return new Date(calendar.getTime().getTime());
    }

    /**
     * 时间比较
     *
     * @param date1 第一个时间参数long型
     * @param date2 第二个时间参数long型
     * @return date1早于date2 返回false</br>
     * date1晚于date2 返回true</br>
     * 单位是秒</br>
     */
    public static final boolean greateThan(final long date1, final long date2) {
        return date1 > date2;
    }

    /**
     * 根据时间判断是否在两个时间之间
     *
     * @param nowDate   时间参数long型
     * @param startDate 开始时间参数long型
     * @param endDate   结束时间参数long型（结束时间需要大于开始时间）
     * @return nowDate在[startdate, enddate)中返回“1”</br>
     * nowDate小于等于startdate 返回“0”</br>
     * nowDate大于等于startdate 返回“2”</br>
     * 单位是秒</br>
     */
    public static final String isBetween(final long nowDate, final long startDate, final long endDate) {
        if (nowDate >= startDate && nowDate < endDate) {
            return "1";
        } else if (nowDate >= endDate) {
            return "2";
        } else {
            return "0";
        }
    }

    /**
     * 根据指定格式将日期转化为为字符串
     *
     * @param format 日期格式
     * @param date   日期
     * @return 指定格式的日期字符串
     * @author simon.xxm
     * @version $Id: DateUtils.java, v 0.1 2016年1月5日 下午7:53:33 simon.xxm Exp $
     */
    public static final String dateFormat(final String format, final Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(format).format(date);
    }

//    public static void main(String[] args) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR, 2018);
//        cal.set(Calendar.MONTH, Calendar.DECEMBER);
//        cal.set(Calendar.DATE, 31);
//        Date dayEndTime = getDayEndTime(cal.getTime());
//
//
//        System.out.println("----------");
//        System.out.println(new Date());
//        System.out.println(dayEndTime);
//        System.out.println(differentDays(new Date(),dayEndTime));
//        System.out.println(differentDays(dayEndTime,new Date()));
//        System.out.println(differentDays(new Date(),getBeginDayOfYesterday()));
//        System.out.println(differentDays(new Date(),new Date()));
//        System.out.println(differentDays(new Date(),getBeginDayOfTomorrow()));
//    }
    /**
     * date2比date1多的天数,只返回相差天数,
     * 比如:date1 = 2020-06-07 15:17:29.999,date2 = 2018-12-31 23:59:59.999,返回-524
     * 比如:date1 = 2018-12-31 23:59:59.999,date2 = 2020-06-07 15:17:29.999,返回524
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2) {
            //不在同一年
            int timeDistance = 0 ;
            boolean b = year1 > year2;
            int max = b ? year1:year2;
            int min = b ? year2:year1;

            for(int i = min ; i < max ; i ++)
            {
                //闰年
                if(i%4==0 && i%100!=0 || i%400==0)
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return b ? (timeDistance  -day2 + day1) * -1:timeDistance + (day2-day1) ;
        }
        else    //同年
        {
            return day2-day1;
        }
    }

    /**
     * 获取时间间隔天数
     *
     * @return 两个时间间隔天数
     * @author wb-sunxiangqing.a
     * @version $Id: DateUtils.java, v 0.1 2016年7月7日 上午10:53:33 wb-sunxiangqing.a Exp $
     * <p>
     * <code>DateUtils.dayDiff(2016-06-06 18:00:05,2016-06-07 18:00:05) = 1</code>
     * <code>DateUtils.dayDiff(2016-06-07 18:00:05,2016-06-06 18:00:05) = -1</code>
     * </p>
     */
    public static final int dayDiff(final Date date1, final Date date2) {
        Calendar calender1 = Calendar.getInstance();
        Calendar calender2 = Calendar.getInstance();
        calender1.setTime(date1);
        calender2.setTime(date2);
        return calender2.get(Calendar.DAY_OF_YEAR) - calender1.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取当前时间距离23:59:59还有多少秒
     * @return 秒数
     * @author wb-sunxiangqing.a
     * @version $Id: DateUtils.java, v 0.1 2016年7月7日 上午10:53:33 wb-sunxiangqing.a Exp $
     * <p>
     * <code>DateUtils.dayDiff(2016-06-06 18:00:05,2016-06-07 18:00:05) = 1</code>
     * <code>DateUtils.dayDiff(2016-06-07 18:00:05,2016-06-06 18:00:05) = -1</code>
     * </p>
     */
    public static long toDayDiffBySecond() {
        return ( DateUtils.getDayEnd().getTime()-System.currentTimeMillis()) / 1000;
    }



    /**
     * 获取系统当前时间
     *
     * @return 系统当前时间的毫秒数
     * @author wb-pengxiaobao.a
     * @version $Id: DateUtils.java, v 0.1 2016年9月29日 上午10:21:30 wb-pengxiaobao.a Exp $
     */
    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

    /** 获取当天的开始时间 */
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /** 获取当天的结束时间*/
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /** 获取昨天的开始时间*/
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /** 获取昨天的结束时间*/
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /** 获取明天的开始时间*/
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    /** 获取指定日期明天的开始时间*/
    public static Date getBeginDayOfTomorrow(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    /**获取明天的结束时间*/
    public static Date getEndDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /** 获取本周的开始时间*/
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    /** 获取本周的结束时间*/
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

   /**  获取本月的开始时间*/
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    /** 获取本月的结束时间*/
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }

    /** 获取本年的开始时间*/
    public static Date getBeginDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        // cal.set
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);

        return getDayStartTime(cal.getTime());
    }

    /**  获取本年的结束时间*/
    public static Date getEndDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }

    /** 获取某个日期的开始时间*/
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /** 获取某个日期的结束时间*/
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

   /**  获取今年是哪一年*/
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

   /**  获取本月是哪一月*/
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    /** 两个日期相减得到的天数*/
    public static int getDiffDays(Date beginDate, Date endDate) {

        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }

        long diff = (endDate.getTime() - beginDate.getTime())
                / (1000 * 60 * 60 * 24);

        int days = new Long(diff).intValue();

        return days;
    }

    /** 两个日期相减得到的毫秒数*/
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }

    /** 获取两个日期中的最大日期*/
    public static Date max(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return beginDate;
        }
        return endDate;
    }

    /** 获取两个日期中的最小日期*/
    public static Date min(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }

    /** 返回某月该季度的第一个月*/
    public static Date getFirstSeasonDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 3);
        return cal.getTime();
    }

    /** 返回某个日期下几天的日期*/
    public static Date getNextDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }

    /** 返回某个日期前几天的日期*/
    public static Date getFrontDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }

    /** 获取某年某月到某年某月按天的切片日期集合（间隔天数的日期集合）*/
    public static List<List<Date>> getTimeList(int beginYear, int beginMonth, int endYear,
                                               int endMonth, int k) {
        List<List<Date>> list = new ArrayList<>();
        if (beginYear == endYear) {
            for (int j = beginMonth; j <= endMonth; j++) {
                list.add(getTimeList(beginYear, j, k));

            }
        } else {
            {
                for (int j = beginMonth; j < 12; j++) {
                    list.add(getTimeList(beginYear, j, k));
                }

                for (int i = beginYear + 1; i < endYear; i++) {
                    for (int j = 0; j < 12; j++) {
                        list.add(getTimeList(i, j, k));
                    }
                }
                for (int j = 0; j <= endMonth; j++) {
                    list.add(getTimeList(endYear, j, k));
                }
            }
        }
        return list;
    }

    /** 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）*/
    public static List<Date> getTimeList(int beginYear, int beginMonth, int k) {
        List<Date> list = new ArrayList<>();
        Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }

    /**
     * 由于传入的是int值，精确到秒的
     * 需要转化为毫秒
     *
     * @return
     */
    public static Long convertTime(int time) {
        long millisecondTime = (long) time * 1000;
        return millisecondTime;
    }

    /**
     * by 白桦
     */
    public static String parseTimeStamp(String timeStamp) {
        if (timeStamp == null || "".equals(timeStamp)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return simpleDateFormat.format(new Date(Long.parseLong(timeStamp)));
    }

    /**
     * 取日期参数月份的第一天和最后一天日期
     *
     * @param dateParm 传入日期（yyyy-MM-dd）
     * @return
     */
    public static String[] firstDayAndLastDay(String dateParm) {
        String[] dataTime = new String[2];
        //构造日期
        LocalDate localDate = LocalDate.parse(dateParm);
        dataTime[0] = String.valueOf(localDate.with(TemporalAdjusters.firstDayOfMonth())) + START_BASE_TIME;
        dataTime[1] = String.valueOf(localDate.with(TemporalAdjusters.lastDayOfMonth())) + END_BASE_TIME;
        return dataTime;
    }

    /**
     * 获取下一天的日期
     *
     * @param date yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String getNextDate(String date) {
        Date nowDate = DateUtils.string2DateNoHour(date);
        Date nextDay = getNextDay(nowDate, 1);
        return format(nextDay, DATE_FORMAT_NO_HOUR);
    }
    /**
     * 获取前一天的日期
     *
     * @param date yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String getYesterdayDate(String date) {
        Date nowDate = DateUtils.string2DateNoHour(date);
        Date nextDay = getNextDay(nowDate, -1);
        return format(nextDay, DATE_FORMAT_NO_HOUR);
    }

    /** 获取前天的开始时间*/
    public static Date getBeginDayOfTheDayBeforeYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -2);
        return cal.getTime();
    }

    /**
     * 判断参数的格式是否为“yyyyMMdd”格式的合法日期字符串
     *
     * @param str
     * @return true/false
     */
    public static boolean isValidDate(String str) {
        try {
            if (str != null && !"".equals(str)) {
                if (str.length() == 8) {
                    /** 闰年标志*/
                    boolean isLeapYear = false;
                    String year = str.substring(0, 4);
                    String month = str.substring(4, 6);
                    String day = str.substring(6, 8);
                    int vYear = Integer.parseInt(year);
                    /** 判断年份是否合法*/
                    if (vYear < 1900 || vYear > 2200) {
                        return false;
                    }
                    /**  判断是否为闰年*/
                    if (vYear % 4 == 0 && vYear % 100 != 0 || vYear % 400 == 0) {
                        isLeapYear = true;
                    }
                   /** 判断月份*/
                   /** 1.判断月份*/
                    if (month.startsWith("0")) {
                        String units4Month = month.substring(1, 2);
                        int vUnits4Month = Integer.parseInt(units4Month);
                        if (vUnits4Month == 0) {
                            return false;
                        }
                        if (vUnits4Month == 2) {
                            /**  获取2月的天数*/
                            int vDays4February = Integer.parseInt(day);
                            if (isLeapYear) {
                                if (vDays4February > 29) {
                                    return false;
                                }
                            } else {
                                if (vDays4February > 28) {
                                    return false;
                                }
                            }

                        }
                    } else {
                        /** 2.判断非0打头的月份是否合法*/
                        int vMonth = Integer.parseInt(month);
                        if (vMonth != 10 && vMonth != 11 && vMonth != 12) {
                            return false;
                        }
                    }
                   /**  判断日期*/
                    if (day.startsWith("0")) {
                        String units4Day = day.substring(1, 2);
                        int vUnits4Day = Integer.parseInt(units4Day);
                        if (vUnits4Day == 0) {
                            return false;
                        }
                    } else {
                        /** 判断非0打头的日期是否合法*/
                        int vDay = Integer.parseInt(day);
                        if (vDay < 10 || vDay > 31) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
