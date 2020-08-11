package com.y3.javaAndAssignModel.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 * @title: TestLambdaExample
 * @projectName base_java
 * @description: TODO
 * @date 2020/7/26 12:15
 */
public class TestLambdaExample {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1(){
        Collections.sort(emps,(e1,e2)->{
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        emps.forEach(System.out::println);
    }

}
