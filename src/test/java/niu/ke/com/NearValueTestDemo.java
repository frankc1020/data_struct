package niu.ke.com;

import java.util.Scanner;

/**
 * @author admin
 * @title: NearValueTestDemo
 * @projectName base_thread
 * @description: TODO
 * @date 2021/2/28 10:18
 */
public class NearValueTestDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        int b = (int)(a+0.5);

        System.out.println(b);
        Math.round(100);
    }

}
