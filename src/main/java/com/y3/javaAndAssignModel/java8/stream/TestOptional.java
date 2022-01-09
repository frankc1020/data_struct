package com.y3.javaAndAssignModel.java8.stream;

import com.y3.javaAndAssignModel.java8.Employee;
import com.y3.javaAndAssignModel.java8.Godness;
import com.y3.javaAndAssignModel.java8.Man;
import com.y3.javaAndAssignModel.java8.NewMan;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author admin
 * @title: TestOptional
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/3 13:51
 * 
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 * 
 * 
 */
public class TestOptional {
    
    @Test
    public void test1(){
        Optional<Employee> op1 = Optional.of(new Employee());
        System.out.println(op1.get());

        Optional<Object> op2 = Optional.ofNullable(null);
        System.out.println(op2);

        Optional<Employee> empty = Optional.empty();
        System.out.println(empty);
    }
    @Test
    public void test2(){
        Employee e1 = new Employee();
        Employee e2 = new Employee(102, "李四", 59, 6666.66);
        Optional<Employee> op1 = Optional.of(new Employee(101, "张三", 18, 9999.99));
        Optional<Employee> op2 = Optional.ofNullable(null);
        System.out.println(op2.isPresent());

        System.out.println(op2.orElse( new Employee(102, "李四", 59, 6666.66)));
        System.out.println(op2.orElse(new Employee()));

        System.out.println(op2.orElseGet(() -> new Employee(103,"王五",20,88888)));
    }

    @Test
    public void test3(){
        Optional<Employee> op1 = Optional.of(new Employee(101, "张三", 18, 9999.99));
        Optional<String> name = op1.map(Employee::getName);
        System.out.println(name.get());

        Optional<Integer> age = op1.flatMap((e) -> Optional.ofNullable(e.getAge()));
        System.out.println(age.get());
    }

    @Test
    public void test4(){
        Man man = new Man();

        String name = getGodnessName(man);
        System.out.println(name);
    }

    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man){
        if(man != null){
            Godness g = man.getGod();

            if(g != null){
                return g.getName();
            }
        }

        return "苍老师";
    }


    @Test
    public void test5(){
//        Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));
        Optional<Godness> godness = Optional.ofNullable(null);

        Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
        String name = getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }


}
