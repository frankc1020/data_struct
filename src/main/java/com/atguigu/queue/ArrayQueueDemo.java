package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author admin
 * @title: ArrayQueueDemo
 * @projectName base_java
 * @description: 使用数组模拟队列
 * @date 2020/7/31 10:22
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试数组队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收输入端输入的数据
        Scanner in = new Scanner(System.in);
        boolean loop = true; //控制while循环
        while(loop){
            //输出一个数组
            System.out.println();
            System.out.println("=============菜单==================");
            System.out.println("s(showQueue)展示队列");
            System.out.println("a(addQueue)增加队列元素");
            System.out.println("g(getQueue)获取队列元素");
            System.out.println("h(head)查看队列首个元素");
            System.out.println("e(exit)退出");
            System.out.println("=============结束==================");
            System.out.println();

            System.out.println("请选择你操作的选项：");
            key = in.next().toString().charAt(0);
            switch (key){
                case 's':
                    try {
                        System.out.println("队列元素如下：");
                        queue.showQueue();
                    }catch (Exception e){
                        System.out.println(e + "/n");
                        System.out.println();
                    }
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个队列元素：");
                        int n = in.nextInt();
                        queue.addQueue(n);
                    }catch (Exception e){
                        System.out.println(e + "/n");
                        System.out.println();
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("获取的队列元素为："+queue.getQueue());
                    }catch (Exception e){
                        System.out.println(e + "/n");
                        System.out.println();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("队列中首个元素为：" + queue.headQueue());
                    }catch (Exception e){
                        System.out.println(e + "/n");
                        System.out.println();
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    System.out.println("菜单异常！！！");
                    break;
            }

        }
    }
}

//使用数组模拟队列-----问题，目前数组只能使用一次，没有达到复用的效果
//需要把该数组改造为环形队列
class ArrayQueue{
    private int MaxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    public ArrayQueue(int maxSize){
        this.MaxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == this.MaxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            throw new RuntimeException("队列已满，不能再添加元素");
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以获取");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以获取");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"]= "+arr[i]);
        }
    }
    //获取第一个元素
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以获取");
        }
        return arr[front+1];
    }
}
