package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author admin
 * @title: quickSort
 * @projectName base_thread
 * @description: TODO
 * @date 2020/10/27 15:37
 */
public class quickSort {

    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,30,-567,70,-3,100};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);//生成一个[0,8000000)数组
        }
        System.out.println("排序前");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long begin = System.currentTimeMillis();
        System.out.println("排序前时间："+begin);
        quickSort(arr,0,arr.length-1);
//        System.out.println("arr=" + Arrays.toString(arr));
        long end = System.currentTimeMillis();
        System.out.println("排序时间后："+end);
        System.out.println(end-begin);

    }

    public static  void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        //pivot 中轴值
        int pivot = arr[(left+right)/2];
        int temp = 0;
        //while循环的目的是让比pivot值小的放到左边
        //比pivot值大的放到右边
        while(l<r){
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while(arr[l] < pivot){
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while(arr[r] > pivot){
                r -= 1;
            }
            //说明l>= r说明pivot的左右两边的值，已按照左边全是小于等于pivot值
            //右边全部是大于等于pivot值
            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //若果交换完后，发现这个arr[l] == pivot 值，相等 r--，前移
            if(arr[l] == pivot){
                r -= 1;
            }
            //若果交换完后，发现这个arr[r] == pivot 值，相等 l++，后移
            if(arr[r] == pivot){
                l += 1;
            }
        }
        //如果 l==r ,必须l++,r--,否则会出现栈溢出
        if(l == r ){
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right > l){
            quickSort(arr,l,right);
        }

    }

}
