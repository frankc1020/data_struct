package com.atguigu.stack;

/**
 * @author admin
 * @title: ArrayStackDemo
 * @projectName base_thread
 * @description: TODO
 * @date 2020/8/14 10:20
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        for(int i = 0;i<=10;i++){
            stack.push(i);
        }
        stack.printStack();
        stack.pop();
        stack.printStack();


        int a = '2';
        System.out.println(a);
    }
}

class ArrayStack{
    private int maxSize;//栈空间
    private int[] stack;//使用数组模拟栈
    private int top = -1;//栈顶，默认初始化为-1，表示栈空

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 压栈
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈空间已满！！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈中没有任何数据，不能取出数据！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public  void printStack(){
        if(isEmpty()){
            System.out.println("栈中没有数据！");
            return;
        }
        for(int i =top;i>=0;i--){
            if(i % 5 == 0){
                System.out.println();
            }
            System.out.printf("stack[%d]=%d\t",i,stack[i]);
        }
    }

}
