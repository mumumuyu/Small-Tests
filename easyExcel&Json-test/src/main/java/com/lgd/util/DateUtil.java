package com.lgd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap<>();

    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tlSdf = sdfMap.get(pattern);

        if (tlSdf == null) {
            tlSdf = new ThreadLocal<SimpleDateFormat>() {
                @Override
                protected SimpleDateFormat initialValue() {
                    return new SimpleDateFormat(pattern);
                }
            };
            sdfMap.put(pattern, tlSdf);
        }

        return tlSdf.get();
    }

    public static String format(Date date, String pattern) {
        if (null == date) {
            return "1900-01-01";
        } else {
            return getSdf(pattern).format(date);
        }
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }

    public static Date LocalDateTimeToDate(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);

        return date;
    }

    public static Date LocalDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }

    public static LocalDateTime DateToLocalDateTime(Date date) {
        if(null==date){
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);

        return localDateTime;
    }

    public static Long getEpochSeconds() {
        LocalDateTime now = LocalDateTime.now();
        return now.toEpochSecond(ZoneOffset.ofHours(8));
    }

    public static Long getRemainSecondsOneDay(Date currentDate) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return seconds;
    }
}
