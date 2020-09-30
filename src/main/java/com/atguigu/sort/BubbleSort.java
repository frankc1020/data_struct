package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author admin
 * @title: BubbleSort
 * @projectName base_thread
 * @description: 冒泡排序
 * @date 2020/9/30 09:32
 *
 * 冒泡排序规则：
 * （1）一共进行数组的大小-1次的循环
 * （2）每一趟排序的次数在逐渐的减少
 * （3）如果我们发现在某趟排序中，没有发生一次交换，可以提前结束冒泡排序。这个就是优化
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int arr[] = {3,9,-1,10,-2};
        int arr[] = {3,9,-1,10,20};
        int temp = 0;
        boolean flag = false;//标识变量，标识是否进行过交换
        //排序的次数 冒泡排序的时间复杂度O(n^2)
        for(int i=0;i<arr.length-1;i++){
            //每次排序都把最大的数据排序好了，然后就每排序好一轮，就把排序的数据减少一个，即最大的数据
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){//当数据大于后面的数据的时候，交换位置
                    flag = true;//进行配置，置为true
                    temp = arr[j];//先将前面的数据保存到临时变量
                    arr[j] = arr[j+1];//在将后面的数据保存到前面的数据的位置里面
                    arr[j+1] = temp; //然后在将临时变量保存到后面位置
                }
            }
            System.out.println("第"+(i+1)+"趟排序的数据：");
            System.out.println(Arrays.toString(arr));

            if(!flag){//在一趟排序中，一次交换都没有发生过
                break;
            }else{
                flag = false;//如果发生交换，在这里重置flag
            }
        }
    }

}
