package com.y3.javaAndAssignModel.java8.tointerface;

/**
 * @author admin
 * @title: TestDefaultInterface
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/3 14:45
 */
public class SubClass /*extends MyClass*/ implements MyFun,MyInterface {


    @Override
    public String getName() {
//        return MyFun.super.getName();
        return MyInterface.super.getName();
    }
}
