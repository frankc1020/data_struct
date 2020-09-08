package com.atguigu.recurision;

/**
 * @author admin
 * @title: Queue8
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/8 14:46
 *
 * 八皇后问题
 */
public class Queue8 {

    int max = 8;
    //定义数组array，保存皇后放置位置结果，比如arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    static  int count = 0;
    static  int judgeCount = 0;
    public static void main(String[] args) {

        //测试八皇后问题
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法！",count);//92
        System.out.printf("一共判断冲突%d次！",judgeCount);//15720

    }
    //特别注意：check是每一次递归时，进入到check中都有  for (int i = 0; i < max; i++)，因此会有回溯
    private void check(int n){
        if(n == max){//n=8,表示8个皇后都放好了
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)){//不冲突
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i;即将第n个皇后，放置在本行得后移的一个位置

        }

    }


    /**
     * 查看当我们放置第n个皇后，就去检测皇后是否和前面已经摆放的皇后冲突
     * array = {0,4,7,5,2,6,1,3} 对应的array的下标，表示第几行，即第几个皇后
     * 而array的值 表示的是棋盘的列 即 arr[i] = val, val 表示第i+1（数组的下标从0开始，需要加1）个皇后，
     * 放在第i+1行的第val+1列
     * @param n 表示第n个皇后
     */
    private boolean judge(int n){
        /**
         * 说明
         *  1. array[i] == array[n] 表示判断 第n个皇后是否和前面的n-1个皇后在同一列
         *  2. Math.abs(n-i) == Math.abs(array(n) - array[i])表示判断第n个皇后是否和第i个皇后是否在同一斜线
         *
         *  就是使用array = {0,4,7,5,2,6,1,3} 即当第一个皇后放在第一列第一行的时候即array[0]=0
         *
         *  然后尝试放置第二个皇后，即放置在第2列第2行 即array[1]= 1;
         *
         *  n=1 放置在第2列(在数组中即 1 ) n = 1 array[1] = 1;
         *
         *  Math.abs(1-0) == 1  Math.abs(array(n) - array[i]) = Math.abs(1-0) = 1 在同一斜线上面，
         *
         *  3. 判断是否在同一行，没有必要，n每次都在递增
         *
         */
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //输出方法
    private  void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


}
