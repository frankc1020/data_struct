package com.atguigu.linkedList;

import java.util.Stack;

/**
 * @author admin
 * @title: SingleLinkedListDemo
 * @projectName base_java
 * @description: TODO
 * @date 2020/8/4 13:50
 *
 * 单链表
 *
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        HeroNode hero1 = new HeroNode(1, "武松", "武曲星君");
        HeroNode hero2 = new HeroNode(2,"林冲","豹子头");
        HeroNode hero3 = new HeroNode(3,"宋江","及时雨");
        HeroNode hero4 = new HeroNode(4, "卢俊义", "玉麒麟");
        SingleLinkedList list = new SingleLinkedList();
//        list.add(hero1);
//        list.add(hero2);
//        list.add(hero3);
//        list.add(hero4);



//        list.addByOrder(hero1);
//        list.addByOrder(hero4);
//        list.addByOrder(hero2);
//        list.addByOrder(hero3);

        list.printList();

        System.out.println("==============使用栈进行反序输出=，不改变链表结构================");
        reversePrintList(list.getHead());

//        System.out.println("=============讲师所使用的反转链表的方法============");
//        reverseList(list.getHead());
//        list.printList();


        /*System.out.println("更新之后的数据============");
        HeroNode hero5 = new HeroNode(6, "小卢", "玉麒麟~~~~~");
        list.update(hero5);
        list.printList();

        //删除一个节点
        list.del(1);
        System.out.println("删除之后的状况===============");
        list.printList();

        //测试一下单链表的头节点的个数
        int length = getLength(list.getHead());
        System.out.println("有效的链表的节点个数" + length);

        System.out.println("========查找链表倒数第k个位置的节点信息=========");
        HeroNode lastIndexNode = findLastIndexNode(list.getHead(), 2);
        System.out.println(lastIndexNode);

        System.out.println("+==============带头结点的单链表反转=================+");
        myReverseList(list.getHead());
        list.printList();*/


        //合并两个有序的链表
        SingleLinkedList list1 = new SingleLinkedList();
        HeroNode sNode1 = new HeroNode(1,5);
        HeroNode sNode2 = new HeroNode(2,10);
        HeroNode sNode3 = new HeroNode(3,40);
        HeroNode sNode4 = new HeroNode(4,50);

        SingleLinkedList list2 = new SingleLinkedList();
        HeroNode tNode1 = new HeroNode(1,15);
        HeroNode tNode2 = new HeroNode(2,25);
        HeroNode tNode3 = new HeroNode(3,35);
        HeroNode tNode4 = new HeroNode(4,55);

        list1.add(sNode1);
        list1.add(sNode2);
        list1.add(sNode3);
//        list1.add(sNode4);

        list2.add(tNode1);
        list2.add(tNode2);
        list2.add(tNode3);
        list2.add(tNode4);

        list1.printList();
        list2.printList();
        System.out.println("================合并之后=================");
        HeroNode mergeNodeHead = mergeOrderList(list1.getHead(), list2.getHead());
        SingleLinkedList.printList(mergeNodeHead);


    }

    /**
     *合并两个有序的链表
     * @param head1
     * @param head2
     *  从大到小
     */
    public static HeroNode mergeOrderList(HeroNode head1, HeroNode head2){
        HeroNode orderHead = new HeroNode(0,null);
        if(head1.next == null){//首先判断链表1是否为空，为空则直接接收链表2
            orderHead.next = head2.next;
            return orderHead;
        }
        if(head2.next == null){//判断链表2是否为空，为空则直接接收链表1
            orderHead.next = head1.next;
            return orderHead;
        }
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode next1 = null;
        HeroNode next2 = null;
        //链表1和链表2都不为空
        while(cur1 != null || cur2 != null){
            if(cur1 != null && cur2 != null){//当前节点都不为空时
                while(cur2 != null && cur1.number >= cur2.number){
                    //如果链表1的当前节点大于等于链表2的当前节点那么就接收链表2的当前节点
                    //并接着移动链表2的节点与链表1的当前节点继续比较，知道链表2的当前节点大于链表1的当前节点
                    next2 = cur2.next;
                    cur2.next = orderHead.next;
                    orderHead.next = cur2;
                    cur2 = next2;
                }
                while(cur1 != null && cur1.number < cur2.number){
                    //如果链表2的当前节点大于等于链表1的当前节点那么就接收链表2的当前节点
                    //并接着移动链表1的节点与链表1的当前节点继续比较，知道链表2的当前节点大于链表2的当前节点
                    next1 = cur1.next;
                    cur1.next = orderHead.next;
                    orderHead.next = cur1;
                    cur1 = next1;
                }


            }

            if(cur1 == null && cur2 != null){//当链表1为空，链表2不为空时，接收链表2剩余节点
                next2 = cur2.next;
                cur2.next = orderHead.next;
                orderHead.next = cur2;
                cur2 = next2;
            }
            if(cur2 == null && cur1 != null){
                next1 = cur1.next;
                cur1.next = orderHead.next;
                orderHead.next = cur1.next;
                cur1 = next1;
            }

        }
        return orderHead;

    }

    /**
     * 利用栈这个数据结构，讲各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
     * @param head
     */
    public static void reversePrintList(HeroNode head){
        if(head.next == null ){//该链表没有数据
            return;//空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;//cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点打印，pop出栈
        for (int i=stack.size();i>0;i--){
            System.out.println(stack.pop());//stack的特性是先进后出
        }
    }

    /**
     * 反转带头结点的单链表
     */
    public static void reverseList(HeroNode head){
        if(head.next == null && head.next.next == null){//链表没有数据或只有一个节点，不用反转
            System.out.println("该链表不用反转");
            return;
        }
        //初始化反转头结点
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;//定义当前节点
        HeroNode next = null;//保存变量
        while(cur != null){
            next = cur.next;//先保存当前节点的下一个节点
            cur.next = reverseHead.next;//然后使用当前节点，保存反转节点的后面的节点数据
            reverseHead.next = cur;//然后在使用反转节点，保存当前节点信息
            cur = next;//在把之前保存的下一个节点信息赋值给当前节点变量，使链表进行遍历节点

        }
        head.next = reverseHead.next;//将反转头结点之后的东西在赋值给头节点，反转完成
    }

    /**
     * 反转带头结点的单链表---自己编写
     */
    public static void myReverseList(HeroNode head){
        if(head.next == null){
            System.out.println("该链表为空~~~~");
            return;
        }
        //初始化反转头结点
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;//定义当前节点
        HeroNode temp = null;//保存变量
        while(true){
            if(cur == null){
                break;
            }
            temp = new HeroNode(cur.no,cur.name,cur.nickName);//把所有信息赋值给这个变量，以防下面的节点丢失造成循环
            if(reverseHead.next == null){
                reverseHead.next = temp;
            }else{
                temp.next = reverseHead.next;
                reverseHead.next = temp;
            }
            cur = cur.next;
        }
        head.next = reverseHead.next;//将反转头结点之后的东西在赋值给头节点，反转完成
    }

    /**
     * 查找单链表中的倒数第k个节点【新浪面试题】
     * 思路：
     *   1.编写一个方法，接收head节点，同时接收一个index
     *   2.index表示是倒数第index个节点
     *   3.先把链表从头到尾遍历，得到链表的总长度getLength
     *   4.得到Size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
     *   5.如果找到了，就返回该节点，否则返回null
     */
    public static  HeroNode findLastIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if(head.next == null){
            return null;//没有找到
        }
        //第一个遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //第二次遍历 size -index位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if(index <= 0 || index > size){
            return null;
        }
        //定义给辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next;
        for(int i=0;i<size -index;i++){
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 方法：获取到单链表的节点的个数（如果是带头结点的链表，需要不统计头节点）
     */
    public static int getLength(HeroNode head){
        int length = 0;
        if(head.next == null){
            return length;
        }
        HeroNode temp = head.next;
        while(true){
            if (temp == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }

}

class SingleLinkedList{
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");//定义一个头结点
    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 第一种添加方式，直接添加到链表尾部
     * @param heroNode
     * 添加节点到单向链表
     * 思路，当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next 指向 新的节点
     */
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * (如果有这个排名，则添加失败，并给出提示)
     */
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;// flag标志添加的编号是否存在，默认为false
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no ){//位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){//说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断标志
        if(flag){//不能添加，说明编号存在
            System.out.printf("该标号已存在，存在的标号为%d",temp.next.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false; //设置查找标志，找到相同编号设置为true
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("没有找到该英雄，该英雄的编号为" + newHeroNode.no);
        }
    }
    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public  void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("没有找到相对应的节点信息");
        }
    }

    public void printList(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
    public static void printList(HeroNode head){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public Integer number;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    public HeroNode(int no,Integer number){
        this.no = no;
        this.number = number;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", number='"+ number + '\'' +
                '}';
    }
}
