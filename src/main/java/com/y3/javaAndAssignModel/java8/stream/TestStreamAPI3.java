package com.y3.javaAndAssignModel.java8.stream;

import com.y3.javaAndAssignModel.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author admin
 * @title: TestStreamAPI3
 * @projectName base_thread
 * @description: TODO
 * @date 2020/8/28 09:22
 */
public class TestStreamAPI3 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(102, "李四", 59, 6666.66,Employee.Status.BUSY),
            new Employee(103, "王五", 28, 3333.33,Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77,Employee.Status.BUSY),
            new Employee(105, "田七", 38, 5555.55,Employee.Status.VOCATION)
    );

    /**
     * 查找与匹配
     * allMatch--检查是否匹配所有元素
     * anyMatch--检查是否至少匹配一个元素
     * noneMatch--检查是否没有匹配所有元素
     * findFirst--返回第一个元素
     * findAll--返回当前流中的任意元素
     * count--返回流中元素的总各个数
     * max--返回流中最大值
     * min--返回流中最小值
     */

    @Test
    public void test1(){
        boolean b = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        System.out.println("------------------------");

        boolean b1 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        Optional<Employee> first = emps.stream().findFirst();
        System.out.println(first);

        Optional<Employee> any = emps.stream().findAny();
        System.out.println(any);

        long count = emps.stream().count();
        System.out.println(count);
    }
}
