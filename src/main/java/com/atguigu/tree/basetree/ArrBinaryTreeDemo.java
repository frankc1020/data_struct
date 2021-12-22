package com.atguigu.tree.basetree;

import com.algorithm.likou.InterviewGoldenTest;

/**
 * @author admin
 * @title: ArrBinaryTreeDemo
 * @projectName base_thread
 * @description: TODO
 * @date 2021/9/28 15:12
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
    }

}

//编写一个ArrBinaryTree，实现顺序存储二叉树遍历
class  ArrBinaryTree{

    private  int[] arr;//存储数据积点的数组

    public ArrBinaryTree(){
    }

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    /**
     * 前序遍历
     * @param index
     */
    public void preOrder( int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树前序遍历");
            return;
        }
        if(index >= arr.length){
            return;
        }
        System.out.print(arr[index]+",");
        if(index *2 +1 <arr.length){
            preOrder(index*2 +1);
        }
        if(index *2 +2 <arr.length){
            preOrder(index*2 +2);
        }
    }

}