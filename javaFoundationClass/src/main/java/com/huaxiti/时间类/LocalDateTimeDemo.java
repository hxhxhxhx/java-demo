package com.huaxiti.时间类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        LocalDate now1 = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        Date date = new Date();
        System.out.println(now);
        System.out.println(date);
        //初始化时间
        LocalDateTime of = LocalDateTime.of(2022, 12, 9, 15, 22,30);
        LocalDate of1 = LocalDate.of(2020, 12, 9);
        LocalTime of2 = LocalTime.of(15, 22, 30);
        System.out.println(of);
        //Fri Dec 09 15:53:39 CST 2022
        Date date1 = new Date(1670572419255L);
        System.out.println(date1);

        String str = "2020-12-09";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(str, formatter);
        System.out.println(localDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date11 = simpleDateFormat.parse(str);
            System.out.println(date11);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Calendar
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        System.out.println(timeZone);
        System.out.println(calendar.toInstant());

    }
}
