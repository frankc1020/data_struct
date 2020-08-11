package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author admin
 * @title: CircleArrayQueueDemo
 * @projectName base_java
 * @description:
 * @date 2020/8/4 12:00
 *
 * 数组模拟环形队列案列：
 *
 * 环形队列思路：
 *  1.front 变量的含义做一个调整，front就指向队列的第一个元素，
 *   就是说arr[front]就是队列的第一个元素，front 的初始值 = 0
 *
 *  2.  rear 变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，
 *      因为希望空出一个空间作为约定，rear 的初始值 = 0；
 *
 *  3. 当队列满时，(rear + 1) % maxSize == front【满】
 *  4.当队列为空时，条件rear == front【空】
 *  5.当我们这样分析，队列中有效的数据个数（rear + maxSize -front）% maxSize
 *  6.我们就可以在原来的队列上修改得到，一个环形队列。
 *
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试数组队列
        //说明，数组大小设置为4，其队列的有效数据最大是3
        CircleArray queue = new CircleArray(4);
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

class CircleArray{
    private int maxSize;//表示数组最大容量
    //front 变量的含义做一个调整，front就指向队列的第一个元素，就是说arr[front]就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
    //rear 的初始值 = 0；
    private int rear;

    private int[] arr;//该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1)%maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }
    //获取队列，出队列
    public int getQueue(){
        //判断队列是否空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列为空，没有元素可以获取");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值取出来保存到一个临时变量
        int value = arr[front];
        //2.将front后移
        front = (front + 1) % maxSize;
        //3.将临时保存的变量返回
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以获取");
        }
        for (int i = front; i < front + size()  ; i++) {
            System.out.printf("arr[%d]=%d\n ", i % maxSize,arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        //rear = 1
        //front =2;
//        maxSize = 3;
        return (rear + maxSize - front) % maxSize;
    }

    //获取第一个元素
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以获取");
        }
        return arr[front];
    }
}
