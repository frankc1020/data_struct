package com.y3.javaAndAssignModel.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author admin
 * @title: TestLambda3
 * @projectName base_thread
 * @description: TODO
 * @date 2020/8/25 12:29
 *
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T>:消费性接口
 *     void  accept(T t);
 *
 * Supplier<T>:供给型接口
 *    T get();
 *
 * Function<T,R>:函数型接口
 *     R apply(T t);
 *
 * Predicate<T>: 断言型接口
 *     boolean test(T t);
 *
 *
 *
 */
public class TestLambda3 {

    //Predicate<T>: 断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","world","john","jck");
        List<String> strlList = filterStr(list,(x)->x.length() >3);
        System.out.println(strlList);
    }

    //需求：用于处理字符串
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> filterList = new ArrayList<>();
        for(String str: list){
            if(pre.test(str)){
                filterList.add(str);
            }
        }
        return filterList;
    }

    //Function<T,R>:函数型接口
    @Test
    public void test3(){
        String newStr = strHandler("\t\t\t爱德华卡萨丁巨好看   ",(str)->str.trim());
        System.out.println(newStr);

        String subStr = strHandler("爱德华卡萨丁巨好看",(str) -> str.substring(2,5));
        System.out.println(subStr);
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    //Supplier<T>:供给型接口
    @Test
    public void test2(){
        List<Integer> list = getNumList(10,()->(int)(Math.random() * 100));
        System.out.println(list);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
       List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            numList.add(n);
        }
        return numList;
    }
    //Consumer<T> 消费性接口
    @Test
    public void test1(){
        happy(10000,(m) -> System.out.println("出去找大保健一次消费"+m+"元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
