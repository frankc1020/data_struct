package com.y3.javaAndAssignModel.java8.stream;

import com.y3.javaAndAssignModel.java8.Employee;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author admin
 * @title: TestStreamAPI1
 * @projectName base_thread
 * @description: TODO
 * @date 2020/8/27 10:17
 *
 * 一、Stream 的三个操作步骤
 *    1.创建 Stream
 *
 *    2. 中间操作
 *
 *    3.终止操作（终端操作）
 *
 */
public class TestStreamAPI1 {

    //创建Stream
    @Test
    public void test1(){
        //1.可以通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        
        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] ems = new Employee[10];

        Stream<Employee> stream1 = Arrays.stream(ems);
        
        //通过Stream类中的静态方法of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        stream2.forEach(System.out::println);

        System.out.println("==========================");

        //4.创建无线流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
//        iterate.limit(20).forEach(System.out::println);
        System.out.println("=====================");
//        生成：
        Stream.generate(()->Math.floor(Math.random()*10))
                .limit(10)
                .forEach(System.out::println);
    }
}
