package com.algorithm;

/**
 * @author admin
 * @title: findArray
 * @projectName base_java
 * @description: 在二维数组中查询一个数
 * @date 2020/7/31 13:39
 */
public class findArray {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        boolean flag = findTargetToArray(16, arr);
        System.out.println(flag);

    }

    /**
     *
     * 题目：
     * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
     * 给定一个数，判断这个数是否在该二维数 组中。
     *
     * 解题思路
         要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
         该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
         因此，从右上角开始查找，就可以根
         据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
     *
     *
     */
    public static boolean findTargetToArray(int target,int[][] arr){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return false;
        }
        int rows = arr.length;//获取行数
        int cols = arr[0].length;//获取列数
        int r=0; //从第一行开始查找
        int c = cols - 1;//从最后一列开始查找 即从一个数组的右上角查找
        /**
         * 从这个数组的右上角查找
         * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边
         */

        while(r<=rows-1 && c >=0){
            if(target == arr[r][c]){
                return true;
            }else if(target > arr[r][c]){
                r++;
            }else{ //target < arr[r][c]
                c--;
            }
        }
        return false;
    }
}
