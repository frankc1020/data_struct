package com.atguigu.hashtab;

/**
 * @author admin
 * @title: HashTabDemo
 * @projectName base_thread
 * @description: TODO
 * @date 2021/8/4 17:09
 */
public class HashTabDemo {
    public static void main(String[] args) {

    }
}

class HashTab{

}
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList,标识链表
class EmpLinkedList{
    //头指针，执行第一个Emp，因此我们这个链表的head是直接指向第一个Emp
    private Emp head;// 默认null

    public void add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){//说明到链表最后
                break;
            }
            curEmp = curEmp.next;//后移
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no){
        if(head == null){//链表为空
            System.out.println("第"+(no+1)+ " 个链表为空");
            return;
        }
        System.out.println("第"+(no+1)+ " 个链表信息为：");
        Emp curEmp = head;
        while(true){
            System.out.printf("==> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next == null){//说明curEmp已经是最后的结点
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();

    }

    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){//找到
                break;
            }
            if(curEmp.next == null){//遍历当前链表没有找到该雇员信息
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}