package com.algorithm.likou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 * @title: InterviewGoldenTest
 * @projectName base_thread
 * @description: TODO
 * @date 2020/11/25 10:00
 *
 * 算法练习：力扣网页：面试金典算法测试：
 *
 */
public class InterviewGoldenTestTwo {
    /**
     * 217 存在重复元素 方法一
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = (map.get(nums[i]) == null) ? 0:map.get(nums[i]);
            map.put(nums[i],count +1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) > 1){
                return true;
            }
        }
        return false;
    }
    /**
     * 217 存在重复元素 方法二
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * 53 最大子序和 方法一 动态规划求解
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max= nums[0];
        int cur =0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            max = Math.max(nums[i],max);
        }
        // System.out.println(max);
        return max;
    }

    /**
     * 53 最大子序和 方法二  贪心算法求解
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int max= nums[0];
        int cur =0;
        for (int num : nums) {
            //如果前边累加后还不如自己本身大，那就把前边的都扔掉，从自己本身重新开始累加
            cur = Math.max(cur+num,num);
            max = Math.max(max,cur);
        }
        System.out.println(max);
        return max;
    }

    /**
     * 1. 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
            }
            map.put(target-nums[i],i);
        }
        return result;
    }

    /**
     * 88 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int tail = m+n-1;
        int cur;
        while(p1>=0 || p2>=0){
            if(p2==-1){
                cur = nums1[p1--];
            }else if(p1==-1){
                cur = nums2[p2--];
            }else if(nums1[p1] > nums2[p2]){
                cur = nums1[p1--];
            }else{
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
//        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums =  {-2,1};
        maxSubArray2(nums);
    }
}
