package com.atguigu.linkedList;

/**
 * @author admin
 * @title: CircleSingleLinkedListDemo
 * @projectName data_struct
 * @description: TODO
 * @date 2020/8/11 17:25
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CirCleSingleLinkedList list = new CirCleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();
    }
}

class CirCleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = null;
    //添加小孩节点，构建一个环形链表
    public void addBoy(int number){
        //number 做一个数据校验
        if(number < 1){
            System.out.println("number值不正确！！！");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        for(int i =1;i<= number;i++){
            Boy boy = new Boy(i);
            if(i==1){
                first = boy;
                curBoy = first;//让curBoy指向第一个小孩
                boy.setNext(first);//构成环
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历循环当前的环形链表
    public  void showBoy(){
        //判断链表是否为空
        if(first == null){
            System.out.println("没有小孩！！！");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while(true){
            System.out.println("小孩的编号："+curBoy);
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

}

class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}