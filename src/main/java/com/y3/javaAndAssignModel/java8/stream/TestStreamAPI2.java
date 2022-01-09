package com.y3.javaAndAssignModel.java8.stream;

import com.y3.javaAndAssignModel.java8.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author admin
 * @title: TestStreamAPI2
 * @projectName base_thread
 * @description: TODO
 * @date 2020/8/27 10:42
 */
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55),
            new Employee(105, "田八八", 38, 5555.55),
            new Employee(105, "田四", 38, 5555.55)
    );
    /**
     * 中间操作
     * 筛选与切片
     *  filter--接收Lambda，从流中排出某些元素
     *  limit--截断流，使其元素不超过给定数量
     *  skip(n)--跳过元素，返回一个扔掉了前n个元素的流，若流中的元素不足n个，则返回一个空流，与limit(n)互补
     *  distinct--筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     *
     */
    @Test
    public void test1(){
        //中间操作
        Stream<Employee> stream = emps.stream()
                .filter((x) -> {
                    System.out.println("Lambda API 过滤");
                    return x.getAge() > 35;

                });
        //终止操作，一次性执行全部内容，即"惰性求值"
        stream.forEach(System.out::println);
    }

    @Test
    public void test2(){

        List<Employee> collect = emps.stream()
                /*.filter((x) -> {
                    System.out.println("Lambda API 过滤");
                    return x.getSalary() > 5000;

                })*/
                .skip(10)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(collect);
//                .distinct()
//                .forEach(System.out::println);

        Integer [] myArray = { 1, 2, 3 };
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList);
//基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray2 = { 1, 2, 3 };
        myList = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        System.out.println(myList);


    }

    /**
     * 映射
     *  map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     *  flatMap---接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test5(){
        List<String> list = Arrays.asList("aa","bbb","ccc","ddd","eee");
        list.stream()
                .map((x)->x.toUpperCase())
                .forEach(System.out::println);

        System.out.println("------------------------------");

        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("==============================");

        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("=======================");
        Stream<Character> stream1 = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);
        stream1.forEach(System.out::println);
    }

    @Test
    public void test6(){
        List<String> list = Arrays.asList("aa","bbb","ccc","ddd","eee");

        List list2 = new ArrayList();
        list2.add(11);
        list2.add(22);
        list2.addAll(list);

        System.out.println(list2);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for(Character ch:str.toCharArray()){
            list.add(ch);
        }

        return list.stream();
    }


    /**
     * 排序
     * sorted() ---自然排序
     * sorted(Comparator com)---定制排序
     */
    @Test
    public void test7(){
        List<String> list = Arrays.asList("ccc","aaa","bbb","ddd","eee");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-----------------------");

        emps.stream()
                .sorted((e1,e2)->{
                   if(e1.getAge() == e2.getAge()){
                       int i = e1.getName().compareTo(e2.getName());
                       System.out.println("id:"+ e1.getId()+ " : " +i);
                       return i;
                   }else{
                       return e1.getAge() > e2.getAge() ? 1:-1;
                   }
                }).forEach(System.out::println);
    }

}
