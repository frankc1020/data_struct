package com.y3.javaAndAssignModel.java8.tointerface;

/**
 * @author admin
 * @title: MyFun
 * @projectName base_thread
 * @description: Java8 接口中的默认方法和静态方法
 * @date 2020/9/3 14:34
 */
public interface MyFun {

    default String getName(){
        return  "哈哈哈";
    }
}
