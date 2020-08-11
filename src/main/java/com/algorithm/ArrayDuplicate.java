package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @title: ArrayDuplicate
 * @projectName base_java
 * @description: 数组中重复的数字
 * @date 2020/7/25 09:36
 */
public class ArrayDuplicate {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5};
        int [] duplication = new int[nums.length];
        boolean flag = new ArrayDuplicate().duplicate(nums,nums.length,duplication);
        System.out.println(Arrays.toString(duplication));
    }
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++)
        {
            while (nums[i] != i) {
                System.out.println("i: "+Arrays.toString(nums));
                System.out.println("nums[i]:" + nums[i]+" nums[nums[i]]: "+ nums[nums[i]]);
            if (nums[i] == nums[nums[i]])
            {
                duplication[0] = nums[i];
                return true;
            }
            swap(nums, i, nums[i]);
                System.out.println("i: "+Arrays.toString(nums));
            }
        }
        return false;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
