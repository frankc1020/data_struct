package com.y3.javaAndAssignModel.java8.stream;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @author admin
 * @title: TestForkJoin
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/2 16:31
 */
public class TestForkJoin {

    @Test
    public void  test1(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculate calculate = new ForkJoinCalculate(0,10000000000L);
        Long sum = pool.invoke(calculate);
        System.out.println(sum);

        /**
         * 100000000L  53ms
         * 10000000000L 1960ms
         *
         */
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }

    /**
     * 普通方法
     */
    @Test
    public void test2(){
        Instant start = Instant.now();

        long sum = 0L;
        for (int i = 0; i <=  10000000000L; i++) {
            sum+=i;
        }

        /**
         * 100000000L  68ms
         *
         * 10000000000L 4407ms
         */
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }

    /**
     * 使用Java8
     */
    @Test
    public void test3(){
        Instant start = Instant.now();
        LongStream.rangeClosed(0,10000000000L)
                .parallel()
                .reduce(Long::sum);

        /**
         * 100000000L  127ms
         *
         * 10000000000L 4407ms
         *
         */
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }

}
