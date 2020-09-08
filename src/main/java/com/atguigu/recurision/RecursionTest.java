package com.atguigu.recurision;

/**
 * @author admin
 * @title: RecursionTest
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/7 17:00
 */
public class RecursionTest {

    public static void main(String[] args) {

    }

    /**
     * 通过打印问题，回顾递归调用机智
     */
    public static void test(int n){
        if(n > 2){
            test(n - 1);
        }
        System.out.println(n);
    }

    public  static int factorial(int n){
       if (n == 1){
           return 1;
       }else{
           return factorial(n-1) * n;
       }
    }
}
