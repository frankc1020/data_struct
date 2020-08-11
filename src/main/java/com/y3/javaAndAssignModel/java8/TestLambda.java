package com.y3.javaAndAssignModel.java8;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @author admin
 * @title: TestLambda
 * @projectName base_java
 * @description: Lambda 表达式
 * @date 2020/7/26 11:28
 *
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 						    箭头操作符将 Lambda 表达式拆分成两部分：
 *
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 *
 * 语法格式一：无参数，无返回值
 * 		() -> System.out.println("Hello Lambda!");
 *
 * 语法格式二：有一个参数，并且无返回值
 * 		(x) -> System.out.println(x)
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * 		x -> System.out.println(x)
 *
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 *		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 *
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 *
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 			 可以检查是否是函数式接口
 *
 *
 *
 *
 */
public class TestLambda {

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    //Lambda表达式
    @Test
    public void test2(){
        Comparator<Integer> com =(x,y)->Integer.compare(x,y);
        int compare = com.compare(3, 5);
        System.out.println(compare);
        TreeSet<Integer> ts = new TreeSet<Integer>(com);
        System.out.println(ts);
    }

    //Lambda表达式 无参数--> 无返回值
    @Test
    public void test3(){
        Runnable r1 = ()-> System.out.println("线程跑起来吧！！");

        new Thread(r1).start();
        new Thread(()-> System.out.println("lalallllalall")).start();
    }

    //有参数数-->无返回值
    @Test
    public void test4(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("我是一个参数，无返回值");
    }
    //有两个参数数-->有返回值
    @Test
    public void test5(){
        Comparator<Integer> com = (x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(5,4));
    }
    //有参数-->只有一条语句
    @Test
    public void test6(){
        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);
        System.out.println(com.compare(5,4));
    }



}
