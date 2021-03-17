package niu.ke.com;

import java.util.ArrayList;
import java.util.List;
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
       /* Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        int b = (int)(a+0.5);

        System.out.println(b);
        Math.round(100);*/

       boolean flag = false;
       List<Long> arr = new ArrayList<Long>();
       arr.add(1000000000091201L);
        List<Long> arr2 = new ArrayList<Long>();
        arr2.add(1000000000091201L);
        if(arr.containsAll(arr2) && arr2.containsAll(arr)){
            flag = true;
        }
        System.out.println(flag);



    }

}
