package com.algorithm.CodingOffer;


/**
 * @author admin
 * @title: CodingDemo
 * @projectName base_thread
 * @description: TODO
 * @date 2021/2/1 15:42
 */
public class CodingDemo {

    /**
     * 3.数组中重复的数字
     */
    public static boolean duplicate(int[] nums,int[] duplication){
        if(nums == null || nums.length < 0){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){//如果第i个位置的数据不等于i
                if(nums[i]  == nums[nums[i]]){//如果第i的数据不等于i且等于nums[i] 位置的数据，则证明数据重复
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);//交换i位置和nums[i] 位置的数据
            }
        }
        return false;
    }

    /**
     * 这个交换的前提是
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * 4. 二维数组中查找
     * @param target
     * @param arr
     * @return
     */
    public static boolean findTarget(int target,int[][] arr){
        if(arr == null || arr.length<0 || arr[0].length < 0){
            return false;
        }
        int rows = arr.length;
        int clos = arr[0].length;

        int r = 0;
        int c = clos-1;
        while(r<= rows-1 && c>=0){
            if(target == arr[r][c]){
                return true;
            }else if(target > arr[r][c]){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
       int[][] nums = {
               {1,4,7,11,15},
               {2,5,8,12,19},
               {3,6,9,16,22},
               {10,13,14,17,24},
               {18,21,23,26,30}
       };

        System.out.println( findTarget(25,nums));

    }



















}
