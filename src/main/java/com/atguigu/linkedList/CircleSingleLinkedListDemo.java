package com.atguigu.linkedList;

/**
 * @author admin
 * @title: CircleSingleLinkedListDemo
 * @projectName data_struct
 * @description: TODO
 * @date 2020/8/11 17:25
 * josepfu 约瑟夫环问题
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CirCleSingleLinkedList list = new CirCleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();

        //验证小孩出圈顺序
        list.countBoy(1,2,5);//2->4->1->5->3
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

    /**
     * 根据用户的输入计算小孩出圈的顺序
     *  nums = 5,即有5个人
     *  startNo = 1 表示从第一个开始报数
     *  countNum = 2 数2下
     *
     *  1.需求创建一个辅助指针helper，事先应该指向环形链表的最后这个节点
     *  补充：小孩报数前，让first和helper指针同时移动startNo - 1次，即让first指针移动到考试计数的节点
     *  2.当小孩报数时，让first和helper指针同时移动countNum-1次
     *  3. 这时就可以将first指向小孩节点出圈
     *
     * @param startNo 表示从第几个小孩开始
     * @param countNum 表示数几下
     * @param nums 表示一共有多少个小孩（多少个节点）
     *
     */
    public void countBoy(int startNo,int countNum,int nums){
        //首先判断链表是否为空，以及入参是否有效
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("链表为空或入参有误。。。。");
            return;
        }
        //1.设置一个helper节点，移动到该环形链表的最后一个节点 即helper.next == first
        Boy helper = first;
        while(true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //2. 小孩报数前，移动helper和first节点，移动到startNo节点，移动次数 startNo-1
        for(int i=1;i<startNo;i++){
            first = first.getNext();
            helper = helper.getNext();
        }
        System.out.println("小孩出圈顺序为：");
        //让小孩还出圈
        while (true){
            if(helper == first){
                break;
            }
            for(int j=1;j<countNum;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //找到节点之后让该节点出圈
            System.out.print(first.getNo() + "->");
            //然后移除该节点信息

            first = first.getNext();
            helper.setNext(first);
        }
        //当helper下一个节点等于first节点时，表示该链表只剩下一个节点
        System.out.print(first.getNo()+"\n");
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