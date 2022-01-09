package com.y3.javaAndAssignModel.java8.time;


import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @title: TestLocalDateTime
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/4 09:27
 */
public class TestLocalDateTime {

    /**
     * LocalDate LocalTime LocalDateTime
     */
    @Test
    public  void test1(){

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDate ldt1 = LocalDate.now();
        System.out.println(ldt1);

        LocalTime ldt2 = LocalTime.now();
        System.out.println(ldt2);

        LocalDateTime of = LocalDateTime.of(2020, 05, 29, 14, 15, 29);
        System.out.println(of);

        LocalDateTime ldt3 = ldt.plusMonths(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());

    }

    /**
     * Instant: 时间戳（以Unix元年：1970年1月1日 00:00:00到某个时间之间的毫秒值）
     *
     * Duration: 计算两个时间之间的间隔
     * Period：计算两个日期之间的间隔
     */
    @Test
    public void test2(){
        Instant start = Instant.now();

        System.out.println(start);

        OffsetDateTime odt = start.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(start.getEpochSecond());

        Instant ins2 = Instant.ofEpochSecond(1000);
        System.out.println(ins2);

        //暂停一会线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());

        System.out.println("------------------------------------");

        LocalTime time1 = LocalTime.now();
        //暂停一会线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        LocalTime time2 = LocalTime.now();

        System.out.println(Duration.between(time1,time2).toMillis());


    }

    @Test
    public void test3(){
        LocalDate ld1 = LocalDate.of(2015,1,1);
        LocalDate ld2 = LocalDate.now();

        System.out.println(Period.between(ld1,ld2));
    }

}
