package com.y3.javaAndAssignModel.collection.list;

import java.util.ArrayList;

/**
 * @author admin
 * @title: ArrayListTest
 * @projectName base_java
 * @description: TODO
 * @date 2020/7/29 14:25
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);

        list.set(2,22);

        System.out.println(list);



    }
}
