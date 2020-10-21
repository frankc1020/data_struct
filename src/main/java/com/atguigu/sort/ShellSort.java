package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author admin
 * @title: ShellSort
 * @projectName base_thread
 * @description: TODO
 * @date 2020/10/20 15:15
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {8,9,1,7,2,3,5,4,6,0};
//        shellSort(arr);
        shellSort2(arr);

    }
    //希尔排序，在插入时交换
    public static  void shellSort(int[] arr){

        int temp;
        int count = 0;
        //根据前面的逐步分析，使用循环处理
        for(int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素，工gap组，每组有arr.length/gap 个元素，步长gap
                for (int j = i-gap; j >=0; j-= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }

            System.out.println("第"+(++count) +"轮排序后的数组：" + Arrays.toString(arr));
        }

        /*//第一轮排序
        for (int i = 5; i < arr.length; i++) {
            for (int j = i-5; j >=0; j-= 5) {
//                System.out.println("排序前数组："+ Arrays.toString(arr));
                if(arr[j] > arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
//                System.out.println("排序后的数组：" + Arrays.toString(arr));
            }
        }

        System.out.println("排序后的数组：" + Arrays.toString(arr));



        //第二轮排序：
        for (int i = 2; i < arr.length; i++) {
//            System.out.println("排序前数组："+ Arrays.toString(arr));
            for (int j = i-2; j >=0; j-= 2) {

                if(arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }

            }
        }
        System.out.println("排序后的数组：" + Arrays.toString(arr));


        //第三轮排序：
        for (int i = 1; i < arr.length; i++) {
//            System.out.println("排序前数组："+ Arrays.toString(arr));
            for (int j = i-1; j >=0; j-=1) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("排序后的数组：" + Arrays.toString(arr));*/
    }

    //希尔排序，优化交换法-----》移位法
    public static  void shellSort2(int[] arr){

        int temp;
        int count = 0;
        //根据前面的逐步分析，使用循环处理
        for(int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素，工gap组，每组有arr.length/gap 个元素，步长gap
                int j =i;
                temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j-gap >=0 && temp < arr[j-gap] ){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }

        }
        System.out.println("第"+(++count) +"轮排序后的数组：" + Arrays.toString(arr));
    }
}
