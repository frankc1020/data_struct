package com.y3.javaAndAssignModel.java8.tointerface;

/**
 * @author admin
 * @title: TestDefaultInterface
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/3 14:46
 *
 * 接口默认方法的”类优先”原则
    若一个接口中定义了一个默认方法，而另外一个父类或接口中 又定义了一个同名的方法时
     选择父类中的方法。如果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略。
     接口冲突。如果一个父接口提供一个默认方法，而另一个接 口也提供了一个具有相同名称和参数列表的方法(不管方法
    是否是默认方法)，那么必须覆盖该方法来解决冲突
 *
 */
public class TestDefaultInterface {

    public static void main(String[] args) {
        SubClass sub = new SubClass();
        System.out.println(sub.getName());
    }
}
