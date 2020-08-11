package com.algorithm;

import java.util.ArrayList;

/**
 * @author admin
 * @title: PrintLinked
 * @projectName base_java
 * @description: 打印链表
 * @date 2020/8/3 09:50
 *
 * 打印链表----->  从尾到头反过来打印出每个结点的值。
 *
 */
public class PrintLinked {

    private static ListNode listNode;

    public static void main(String[] args) {

        ListNode listNode = new ListNode();
        listNode.add(10);
        listNode.add(20);
        listNode.add(30);
        listNode.add(40);
//        printListFromTailToHead(listNode);

    }

    //第一种方法 使用递归的方法
    public ArrayList<Integer> printListFromTailToHead(Node node){
        ArrayList<Integer> ret = new ArrayList<>();
        if(node != null){
            ret.addAll(printListFromTailToHead(node.next));
            ret.add(node.val);
        }
        return ret;
    }


}

class  ListNode{
    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void print(){
        Node current = first;
        while(current != null){
            System.out.println(current.val+ "  ");
            current = current.next;
        }
        System.out.println();
    }

    public  void add(int val){
        Node newNode = new Node(val);//创建一个新的节点封装数据
        if(this.isEmpty()){//如果当前链表为空，则头和尾都指向该节点
            first = newNode;
            last = newNode;
        }else{//若链表不空
            last.next = newNode;
            last = newNode;
        }
    }
}

class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
