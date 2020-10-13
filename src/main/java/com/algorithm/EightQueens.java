package com.algorithm;

/**
 * @author admin
 * @title: EightQueens
 * @projectName base_thread
 * @description: 八皇后问题
 * @date 2020/10/13 14:18
 */
public class EightQueens {
    int max = 8;
    int[] arr = new  int[max];
    static  int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.check(0);
        System.out.println("一共有多少种解法：" + count);

    }

    public void check(int n){
        if(n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }

    }

    public  boolean judge(int n){//判断是否在同一列和统一斜列上面
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(arr[n] == arr[i] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    public void print(){
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
