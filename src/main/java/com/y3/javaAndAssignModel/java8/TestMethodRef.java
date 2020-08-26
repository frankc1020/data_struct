package com.y3.javaAndAssignModel.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author admin
 * @title: TestMethodRef
 * @projectName base_thread
 * @description: TODO
 * @date 2020/8/26 10:59
 *
 * 方法引用：若Lambda体重的内容有方法已经实现了，我们可以使用"方法引用"
 *          （可以理解为方法引用Lambda表达式的另外一种表现形式）
 *
 * 主要有三种语法：
 *     对象::实例方法名
 *
 *     类::静态方法
 *
 *     类::实例方法名
 *
 * 注意：
 *   ①Lambda体中调用方法参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *   ②若Lambda参数列表中第一参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用className:method
 *
 *
 *
 *
 */
public class TestMethodRef {

    //对象::实例方法名
    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (x)-> System.out.println(x);

        con.accept("absdas");

        Consumer<String> con1 = ps::println;

        con1.accept("asjkdjakda");

        Employee e = new Employee();
        Supplier<String> sup = ()->e.getName();
        System.out.println(sup.get());

        Supplier<String> sup1 = e::getName;
        System.out.println(sup1.get());

    }

    @Test
    public void test2(){
        Comparator<Integer> com = (x, y)->Integer.compare(x,y);

        System.out.println(com.compare(5,6));

        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(6,6));
    }

    @Test
    public  void test3(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        System.out.println(bp.test("x1","x2"));
    }
}
