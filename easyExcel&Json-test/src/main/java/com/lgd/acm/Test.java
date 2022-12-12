package com.lgd.acm;


import com.lgd.util.DateUtil;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/19 17:46
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        /*Scanner in = new Scanner(System.in);
        Integer s1 = Integer.valueOf(in.nextLine());
        String[] s = in.nextLine().split(" ");
        String[] s2 = in.nextLine().split(" ");
        System.out.println(s1);
        Arrays.stream(s).forEach(System.out::println);
        Arrays.stream(s2).forEach(System.out::println);
        */
        /*boolean before = DateUtil.parse("2022-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss").before(DateUtil.parse("2022-01-01 01:00:00", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(before);
        String in1 = "0";
        String in2 = "2";
        System.out.println(in1.compareTo(in2));
        int a= 0;*/
        /*LocalDateTime now = LocalDateTime.now();
        System.out.println(now);*/
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }
}
