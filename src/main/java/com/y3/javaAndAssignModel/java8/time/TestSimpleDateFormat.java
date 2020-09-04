package com.y3.javaAndAssignModel.java8.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author admin
 * @title: TestSimpleDateFormat
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/3 16:34
 */
public class TestSimpleDateFormat {

    public static void main(String[] args) throws Exception {
        test3();
    }

    public static void test1() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20161121");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for(Future<Date> future : results){
            System.out.println(future.get());
        }

        pool.shutdown();

    }

    /**
     * 解决线程安全问题
     * @throws Exception
     */
    public static void test2() throws Exception {

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("20161121");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for(Future<Date> future : results){
            System.out.println(future.get());
        }

        pool.shutdown();

    }

    /**
     * java8模式
     * @throws Exception
     */
    public static void test3() throws Exception {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20161121",dtf);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for(Future<LocalDate> future : results){
            System.out.println(future.get());
        }

        pool.shutdown();

    }
}
