package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author admin
 * @title: SelectSort
 * @projectName base_thread
 * @description: 选择排序
 * @date 2020/10/3 09:10
 */
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {34,101,119,1};
        selectSort(arr);
    }

    /**
     * 选择排序思路图解：
     *    1. 选择排序一共有数组大小-1 轮排序
     *    2. 每1轮排序，又是一个循环，循环的规则（代码）
     *    2.1 先假定当前这个数是最小数
     *    2.2 然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定
     *    最小数，并得到下标
     *    2.3 当遍历到数组的最后时，就得到本轮最小数和下标
     *    2.4 交换
     * @param arr
     */
    //选择排序 算法思想：先简答------》再复杂 把一个复杂的算法，拆分成简单的问题--》逐步解决
    public static void  selectSort(int[] arr){
        //选择排序的时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(min > arr[j]){
                    minIndex = j;//重置minIndex
                    min = arr[j];//重置min
                }
            }
            //将最小值，放在arr[i],即交换
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println("第"+(i+1)+"轮：");
            System.out.println(Arrays.toString(arr));
        }

    }
}
