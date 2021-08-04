package com.algorithm.likou;

import java.util.*;

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

    /**
     * 350 两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = nums1.length-1;
        int p2 = nums2.length -1;
        int tail = p1<p2 ? p1:p2;
        int index= 0;
        int[] result = new int[tail+1];
        while(p1>=0 || p2>=0){
            if((p1==-1) || (p2 == -1)){
                return Arrays.copyOfRange(result, 0, index);
            }else if(nums1[p1] > nums2[p2]){
                p1--;
            }else if(nums1[p1] < nums2[p2]){
                p2--;
            }else{
                result[index] = nums1[p1];
                index++;
                p1--;
                p2--;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    /**
     * 121。 买卖股票的最佳时机
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[minIndex] > prices[i]){
                minIndex = i;
            }else if(prices[i] - prices[minIndex] > max){
                maxIndex = i;
                max = prices[i] - prices[minIndex];
            }
        }
        return max < 0 ? 0 : max;
    }

    /**
     * 118. 杨辉三角
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> iList = new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                if(j==0 || j==i){
                    iList.add(1);
                }else{
                    iList.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(iList);
        }
        return result;
     }

    /**
     * 556 重塑矩阵
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if((row*col) <= ((r-1)*c) || (row*col) <= (r*(c-1))){
            return mat;
        }
        int[][] result = new int[r][c];
        int r1=0;
        int c1=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (c1<c) {
                    result[r1][c1++] = mat[i][j];
                }else{
                    c1=0;
                    r1++;
                }
            }
        }
        return mat;
    }

    /**
     * 36,有效数独
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer,Integer>[] rows = new HashMap[9];
        Map<Integer,Integer>[] cols = new HashMap[9];
        Map<Integer,Integer>[] boxs = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxs[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    int num = (int)board[i][j];
                    rows[i].put(num,rows[i].getOrDefault(num,0)+1);
                    cols[j].put(num,cols[j].getOrDefault(num,0)+1);
                    int box_i = (i/3)*3 + (j/3);
                    boxs[box_i].put(num,boxs[box_i].getOrDefault(num,0)+1);

                    if(rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxs[box_i].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 387. 字符串中的第一个唯一字符
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int num = -1;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i)+"";
            int m = (map.get(c)== null) ? 0 : map.get(c);
            map.put(c,m+1);
        }
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i)+"";
            if(map.get(c) == 1){
                num = i;
                return num;
            }
        }
        return num;
    }

    /**
     * 383  赎金信 使用HashMap
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int num = map.get(c)== null ? 0 : map.get(c);
            map.put(c,num+1);
        }
        boolean flag = false;
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            if(map.containsKey(r)){
                if(map.get(r) == 0){
                    map.remove(r);
                    return flag;
                }
                map.put(r,map.get(r)-1);
            }else{
                return flag;
            }
        }
        flag = true;
        return flag;
    }

    /**
     * 383 赎金信 使用数组 即假定两个字符串都是小写字母
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
       int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int c = magazine.charAt(i) - 'a';
            arr[c]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote.charAt(i) - 'a';
            if(arr[c] > 0){
                arr[c]--;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 242. 有效的字母异位词 使用数组解决
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            arr1[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i) - 'a';
            arr2[c]++;
        }
        for (int i = 0; i < 26; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 203. 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode();
        while(head != null){
            if(head.val == val){
                head = head.next;
            }else{
                temp = head;
                break;
            }
        }


        while(temp != null && temp.next != null){
            if(temp.next.val == val){
                if(temp.next.next != null){
                    temp.next = temp.next.next;
                }else{
                    temp.next = null;
                    break;
                }
            }else{
                temp = temp.next;
            }

        }

        return head;
    }

    /**
     * 21. 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head,temp,temp1,temp2;
        if(l1.val < l2.val){
            head = l1;
            temp1 = l1.next;
            temp2 = l2;
            temp = head;
        }else{
            head = l2;
            temp1 = l1;
            temp2 = l2.next;
            temp = head;
        }
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 == null && temp2 != null){
            temp.next = temp2;
        }
        if(temp1 != null && temp2 == null){
            temp.next = temp1;
        }
        return head;
    }

    /**
     *206. 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode headNew = null;
//        ListNode headNew = new ListNode();
        ListNode temp = head;
        ListNode cur;
        while(temp != null){
            cur = temp;
            temp = temp.next;
            cur.next = headNew;
            headNew = cur;
        }
        return headNew;
    }

    public static void main(String[] args) {
//        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums1 =  {1,2,2,1};
//        int[] nums2 =  {2,2};
//        intersect(nums1,nums2);

//        System.out.println(isAnagram("nl","cx"));

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        reverseList(l1);

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
