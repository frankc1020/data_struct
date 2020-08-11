package com.y3.javaAndAssignModel.collection.linkedList;

import java.util.LinkedList;

/**
 * @author admin
 * @title: LinkedListTest
 * @projectName base_java
 * @description: TODO
 * @date 2020/7/31 16:19
 */
public class LinkedListTest {
    public static void main(String[] args) {
        //linkedList空参构造
        LinkedList list = new LinkedList();
        System.out.println(list.add(10));
        System.out.println(list.add(20));
        System.out.println(list.add(30));
        System.out.println(list.add(40));

        System.out.println(list);

        list.remove(new Integer(20));
        System.out.println(list);

        System.out.println(list.get(2));


        /*list.add(2,60);
        System.out.println("index=====:"+list);
        //linkedList带集合构造
        LinkedList list1 = new LinkedList(list);

        System.out.println(list1);

        LinkedList list2 = new LinkedList();
        list2.add(30);
        list2.addAll(0,list);
        System.out.println(list2);*/


    }
}
