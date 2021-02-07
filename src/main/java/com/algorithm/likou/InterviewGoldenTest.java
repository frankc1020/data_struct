package com.algorithm.likou;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.sql.Array;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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


    /**
     * 四数相加 ②
     * @param
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if(A[i] + B[j] + C[k] + D[l] == 0){
                            count++;
                        }

                    }

                }

            }

        }
        return count;
    }

    /**
     * 四数相加 ②
     * 使用Hash函数
     * 1.收件建立一个HashMap计算A和B数组中任意两数之和作为key，然后重复的key就加1 那么A和B数组中出现几次那么在和C和D中相加的时候就可能出现几次
     * 2.接着计算C和D数组中任意两数之和，取相反数，然后在与Map中具有相同key的键值进行相加
     *
     * @param
     */
    public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                if(map.containsKey(a+b)){
                    map.put(a+b,map.get(a+b)+1);//存在，则值加1
                }else{
                    map.put(a+b,1);//不存在，默认初始化为1
                }
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sumCD = -(c+d);
                if(map.containsKey(sumCD)){
                    count += map.get(sumCD);
                }
            }
        }
        return count;
    }

    /**
     * 整数反转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        int last = 0;
        while(x != 0){//当x等于0时直接返回
            int temp = x % 10;//得到最后一位
            last = res;//将上一次得到的结果复制给last
            res = res * 10 + temp;//将上一次得到的res扩大10倍，后面再加上这次得到的最后一位
            if(last != res /10){//判断是否溢出
                return 0;
            }
            x /= 10;//将原数縮小10倍
        }
        return res;
    }

    /**
     * 回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x>=0 && x<10){
            return true;
        }
        if(x>=10){
            int res = 0;
            int k = x;
            while(k != 0){
                int temp = k % 10;
                res = res * 10 + temp;
                k /= 10;

            }
            if(x == res){
                return true;
            }
        }
        return false;
    }


    public static int romanToInt(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                case 'I':
                    if((i+1)<s.length()){
                        char str = s.charAt(i+1);
                        if('V'==str){
                            i++;
                            result +=4;
                        }else if('X'==str){
                            i++;
                            result+=9;
                        }else{
                            result+=1;
                        }
                    }else{
                        result+=1;
                    }
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    if((i+1)<s.length()){
                        char str = s.charAt(i+1);
                        if('L'==str){
                            i++;
                            result +=40;
                        }else if('C'==str){
                            i++;
                            result+=90;
                        }else{
                            result+=10;
                        }
                    }else{
                        result+=10;
                    }

                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    if((i+1)<s.length()){
                        char str = s.charAt(i+1);
                        if('D'==str){
                            i++;
                            result +=400;
                        }else if('M' == str){
                            i++;
                            result+=900;
                        }else{
                            result+=100;
                        }
                    }else{
                        result+=100;
                    }
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;

            }
        }

        return result;
    }

    /**
     * 罗马数字转整数
     * @param s
     * @return
     */
    public static int romanToInt2(String s) {
        int sum = 0;
        for(int i = 0;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if((i+1)<s.length() && num < getValue(s.charAt(i+1))) {
                sum -= num;
            }else{
                sum += num;
            }
        }
        return sum;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    /**
     * 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

     问总共有多少条不同的路径？

     使用动态规划
     在当前的位置只能从这个位置的左面或者上面得到，而处于网格边界的只有一种路径，所以可以从边界计算得来路径的条数
     * @param m
     * @param n
     * @return
     */
    public static   int uniquePaths(int m, int n) {

        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            arr[i][0] = 1;
        }
        print(arr);
        System.out.println();
        for (int j = 0; j < n; j++) {
            arr[0][j] = 1;
        }
        print(arr);
        for (int i = 1; i <m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }

    //输出方法
    private static   void print(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null && strs.length == 0){
            return "";
        }
        int length = strs[0].length();
        for(int j=0;j<length;j++){
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if(j == strs[i].length() || strs[i].charAt(j) != c){
                   return strs[0].substring(0,j);
                }
            }
        }

        return strs[0];


    }

    /**
     * 柠檬水找零
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        boolean flag = true ;
        int[] arr = new int[3];
        for (int bill : bills) {
            if(bill == 5){
                arr[0] +=1;
            }else if(bill == 10){
                if(arr[0] >= 1){
                    arr[1]+=1;
                    arr[0]-=1;
                }else{
                    flag = false;
                    break;
                }
            }else if(bill == 20){
                if(arr[0] >=1 && arr[1]>=1){
                    arr[2]+=1;
                    arr[0]-=1;
                    arr[1]-=1;
                }else if(arr[0] >=3){
                    arr[2]+=1;
                    arr[0]-=3;
                }else{
                    flag = false;
                    break;
                }
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 柠檬水找零
     * @param bills
     * @return
     */
    public static boolean lemonadeChange2(int[] bills) {
        boolean flag = true ;
        int five = 0; int ten = 0;
        for (int bill : bills) {
            if(bill == 5){
                five +=1;
            }else if(bill == 10){
                if(five >= 1){
                    ten+=1;
                    five-=1;
                }else{
                    flag = false;
                    break;
                }
            }else if(bill == 20){
                if(five >=1 && ten>=1){

                    five-=1;
                    ten-=1;
                }else if(five >=3){
                    five-=3;
                }else{
                    flag = false;
                    break;
                }
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 有效括号
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if(stack.size() > 0 && ")".equals(c) ){
                if("(".equals(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }else if(stack.size() > 0 && "}".equals(c)){
                if("{".equals(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }

            }else if(stack.size() > 0 &&  "]".equals(c)){
                if("[".equals(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        if(stack.size()> 0){
            return false;
        }
        return true;
    }

    /**
     * 计算两个日期的时间间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetweenDates(String date1, String date2) {
        long days = 0L;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            long time1= sdf.parse(date1).getTime();
            long time2 = sdf.parse(date2).getTime();
            days = (time1-time2)/(1000*60*60*24);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(days));
    }

    /**
     * 计算两个日期的时间间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetweenDates2(String date1, String date2) {
        long days = 0L;
        try {
            long time1= Date.parse(date1);
            long time2 = Date.parse(date2);
            days = (time1-time2)/(1000*60*60*24);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(days));

    }


    /**
     * 小于等于阈值
     */
    public static int smallestDivisor(int[] nums, int threshold) {


        for(int i = 1;i<=threshold;i++){
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] % i >0){
                   sum = sum+ ((nums[j]/i) + 1);
                }else{
                    sum = sum+ (nums[j]/i);
                }
            }
            if(sum <= threshold){
                return i;
            }
        }
        return 0;
    }

    /**
     * 738. 单调递增的数字
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
     * @param N
     * @return
     */
    public static int monotoneIncreasingDigits(int N) {
        char[] a = String.valueOf(N).toCharArray();//首先转换为char字符数组
        int flag = a.length;//将flag初始化为字符串长度大小，防止没有合适的位置时不会执行②
        //从最后一个位置开始遍历进行比较
        for(int i=a.length-1;i>0;i--){//①
            if(a[i-1] > a[i]){//这一步比较只要后面一位小于前面一位，则前面一位就减小
                flag = i;//这个是为了标记最后一次找的位置，即最终的位置
                a[i-1]--;
            }
        }
        for(int i=flag;i<a.length;i++){//② 这一步是将不符合的位置及之后的数字换成最大的数字
            a[i] = '9';
        }
        return Integer.parseInt(String.valueOf(a));
    }

    /**
     * 单词规律
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {
        if(pattern != "" && s != ""){
            char[] chars = pattern.toCharArray();
            int B = 0;
            for (int i = 0; i < chars.length; i++) {
                if(pattern.contains(String.valueOf(chars[i]))){
                    pattern = pattern.replaceAll(String.valueOf(chars[i]),String.valueOf(B));
                    B =  B + 1;
                }
            }

            String[] split = s.split(" ");
            int A = 0;
            for (int i = 0; i < split.length; i++) {
                if(s.contains(split[i])){
                    for (int C = i+1; C < split.length; C++) {
                        if(split[i].equals(split[C])){
                            split[C] = String.valueOf(A);
                        }
                    }
                    split[i] = String.valueOf(A);
                    A =  A + 1;
                }

            }
            StringBuffer sb = new StringBuffer();
            for (String s1 : split) {
                sb.append(s1);
            }
            return pattern.equals(sb.toString());
        }
        return false;
    }

    /**
     * 思路及解法

     在本题中，我们需要判断字符与字符串之间是否恰好一一对应。即任意一个字符都对应着唯一的字符串，任意一个字符串也只被唯一的一个字符对应。在集合论中，这种关系被称为「双射」。

     想要解决本题，我们可以利用哈希表记录每一个字符对应的字符串，以及每一个字符串对应的字符。然后我们枚举每一对字符与字符串的配对过程，不断更新哈希表，如果发生了冲突，则说明给定的输入不满足双射关系。

     在实际代码中，我们枚举 pattern 中的每一个字符，利用双指针来均摊线性地找到该字符在 str 中对应的字符串。每次确定一个字符与字符串的组合，我们就检查是否出现冲突，最后我们再检查两字符串是否比较完毕即可

     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern2(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }

    /**
     * 389. 找不同
     * @param s
     * @param t
     * @return
     * 给定两个字符串 s 和 t，它们只包含小写字母。

    字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

    请找出在 t 中被添加的字母。
     */
    public static char findTheDifference(String s, String t) {
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
             ch[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if(ch[t.charAt(i) - 'a']>0){
                ch[t.charAt(i) - 'a']--;
            }else{
                return t.charAt(i);
            }

        }
        return t.charAt(0);
    }

    /**
     * 2.两数相加
     * @param l1
     * @param l2
     * @return
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807

     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       String sb1 = String.valueOf(l1.val);
       while(l1.next != null){
           l1 = l1.next;
            sb1= String.valueOf(l1.val) +sb1;

       }

        String sb2 = String.valueOf(l2.val);
        while(l2.next != null){
            l2 = l2.next;
            sb2= String.valueOf(l2.val) +sb2;

        }
        long sum = Long.parseLong(sb1) + Long.parseLong(sb2);
        String sumStr = String.valueOf(sum);
        ListNode first = new ListNode();
        ListNode temp;
        temp = first;
        for (int i = sumStr.length()-1; i >=0; i--) {
            if(i != 0){
                temp.val = Integer.parseInt(String.valueOf(sumStr.charAt(i)));
                temp.next = new ListNode();
                temp = temp.next;
            }else {
                temp.val = Integer.parseInt(String.valueOf(sumStr.charAt(i)));
            }

        }
        return first;
    }

    /**
     * 第一步存在缺陷，只能计算long以内长度的
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int count = 0;
        while(l1 != null || l2 != null){
            int n1  = (l1 != null )?  l1.val : 0;
            int n2 = (l2 != null )? l2.val : 0;
            int sum = n1 + n2 + count;
            count = sum / 10;
            if(head == null){
                head = temp = new ListNode(sum % 10);
            }else{
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if (count > 0) {
            temp.next = new ListNode(count);
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 746. 使用最小花费爬楼梯 使用动态规划
     *      i-2级阶梯      i-1级       i级
     *  例子 10              15          20
     *       i-2            i-1          i
     *
     *
     * 到达第i级阶梯时，当到达i-2级阶梯时，即是到达第i-1级阶梯最小的步数，minCost[i-1] ，这时到达第i级阶梯时还需要在加上cost[i]
     * 同理，到达第i-2级阶梯最小的花费，这时还不在i-2级阶梯，所以minCost[i-2] + cost[i-1]
     *
     * @param cost
     * @return
     */
    public  static  int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = 0;
        minCost[1] = Math.min(cost[0],cost[1]);
        for (int i = 2; i < cost.length; i++) {
            minCost[i] = Math.min(minCost[i-1] + cost[i],minCost[i-2] + cost[i-1]);
        }
        return minCost[cost.length-1];

    }

    /**
     * 103. 二叉树的锯齿形层序遍历
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.add(root);
        }
        boolean  flag = true;
        while(!queue.isEmpty()){
            Deque<Integer> level = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if(flag){
                   level.offerLast(node.val);
                }else{//
                    level.offerFirst(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }

            }
            flag = (!flag);
            res.add(new LinkedList<Integer>(level));
        }

        return res;
    }

    /**
     * 102 二叉树层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        if(root != null){
            queue.add(root);
        }
        boolean  flag = false;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;

        InterviewGoldenTest test = new InterviewGoldenTest();
        test.zigzagLevelOrder(t1);
    }

    /**
     * 135. 分发糖果
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        for(int i=0;i<ratings.length;i++){

        }
        return 0;
    }

    /**
     * 26. 删除排序数组中的重复项
     */
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int n = 0;
        nums[n] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!= nums[n]){
                n++;
                nums[n] = nums[i];
            }
        }
        return n+1;
    }

    /**
     * 830. 较大分组的位置 较大分组的位置
     在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。

     例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。

     分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。

     我们称所有包含大于或等于三个连续字符的分组为 较大分组 。

     找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     */
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int length = s.length();
        int count = 1;
        for (int i = 0; i < length; i++) {
            if(i==length-1 || s.charAt(i) != s.charAt(i+1)){
                if(count >= 3){
                    result.add(Arrays.asList(i-count+1,i));
                }
                count=1;
            }else{
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] cost = new int[]{10,15};
//        System.out.println(minCostClimbingStairs(cost));
       /* ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4,l13);
        ListNode l1 = new ListNode(2,l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6,l23);
        ListNode l2 = new ListNode(5,l22);


        System.out.println(addTwoNumbers2(l1,l2));*/

        String s = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(s));
    }


}
