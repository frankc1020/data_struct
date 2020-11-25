package com.algorithm.likou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class InterviewGoldenTest {

    public static int[] twoSum(int[] nums, int target) {
        int[] returnNum = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>=0;j--){
                if(i==j){
                    continue;
                }
                if(nums[i]+nums[j] == target){
                    returnNum[0] = i;
                    returnNum[1] = j;
                    break;
                }
            }
        }
        return returnNum;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] returnNum = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                returnNum[0] = i;
                returnNum[1] = map.get(nums[i]);
                break;
            }
            map.put(target-nums[i],i);
        }
        return returnNum;
    }


    /**
     * 判定字符是否唯一
     * @return
     */
    public static boolean isOnlyChar(String str) {
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {

            if((str.indexOf(split[i])) != (str.lastIndexOf(split[i]))){
                return false;
            }
        }
        return true;
    }
    public static boolean isOnlyChar2(String str) {
        int[] arr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            //如果不重复，则直接入数组，只有重复的字符才会重复进行判断，
            // 所以就判断出不等于0即存在重复的字符
            if(arr[str.charAt(i)] != 0){
                return false;
            }
            arr[str.charAt(i)]++;
        }
        return true;
    }

    /**
     * 上升下降字符串
     * @param str
     * @return
     */
    public static String sortString(String str) {
        StringBuffer returnStr = new StringBuffer();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(arr));
        int count = str.length();
        while(count>0){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != 0){
                    returnStr.append(Character.toChars(i+'a'));
                    arr[i]--;
                    count--;
                }
            }
            for (int j = arr.length-1; j >=0; j--) {
                if(arr[j] != 0){
                    returnStr.append(Character.toChars(j+'a'));
                    arr[j]--;
                    count--;
                }
            }
        }


        return returnStr.toString();
    }



    public static void main(String[] args) {
//        int nums[] = {2, 7, 11, 15};
//        int[] returnNums = twoSum(nums, 18);
//        System.out.println(Arrays.toString(returnNums));

//        String str = "leetcode";
//        String str = "abc";
//        System.out.println(isOnlyChar2(str));


        String s = "ggggggg";
        System.out.println(sortString(s));


        System.out.println(Character.toChars((2+'a')));
    }



}
