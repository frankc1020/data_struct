package com.y3.javaAndAssignModel.java8.stream;

import com.y3.javaAndAssignModel.java8.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 归约：
     *  reduce(T identity,BinaryOperator) / reduce(BinaryOperator)--可以将流中的元素反复结合起来，得到一个值
     */
    @Test
    public void test2(){
        Optional<Double> reduce = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
//                .reduce(0, (x, y) -> x + y);

        System.out.println(reduce.get());
    }
    /**
     * 收集：
     *    collect--将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test3(){
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("---------------------");

        HashSet<String> hashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    @Test
    public void test4(){
        Long count = emps.stream().collect(Collectors.counting());
        System.out.println(count);

        Double avg = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        Optional<Employee> maxEmp = emps.stream().collect(Collectors.maxBy((x, y) -> Integer.compare(x.getAge(), y.getAge())));
        System.out.println(maxEmp.get());

        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    /**
     * 分组
     */
    @Test
    public void test5(){
//        Map<Employee.Status, List<Employee>> collect = emps.stream()
//                .collect(Collectors.groupingBy(Employee::getStatus));
//        System.out.println(collect);
//
//        System.out.println("---------------------------------");
//
//        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
//                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((x) -> {
//                    if (((Employee) x).getAge() < 30) {
//                        return "青年";
//                    } else if (((Employee) x).getAge() < 50) {
//                        return "中年";
//                    } else {
//                        return "老年";
//                    }
//                })));
//        System.out.println(map);

        Map<Integer, List<Employee>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getId));


    }




}
