package com.y3.javaAndAssignModel.java8.exer;

import com.y3.javaAndAssignModel.java8.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author admin
 * @title: TestStreamAPI
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/2 14:27
 */
public class TestStreamAPI {

    /**
     * 1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     ，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
     */

    @Test
    public void test1(){
        Integer[] nums = new Integer[]{1,2,3,4,5};

        Arrays.stream(nums)
                .map((x)-> x* x)
                .forEach(System.out::println);
    }

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );

    /**
     * 怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
     */
    @Test
    public void test2(){
        Optional<Integer> reduce = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);

        System.out.println(reduce.get());

    }

}
