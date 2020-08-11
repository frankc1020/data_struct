package com.atguigu.linkedList;

/**
 * @author admin
 * @title: DoubleLinkedListDemo
 * @projectName data_struct
 * @description: TODO
 * @date 2020/8/11 12:11
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试双向链表
        HeroNode2 hero1 = new HeroNode2(1, "武松", "武曲星君");
        HeroNode2 hero2 = new HeroNode2(2,"林冲","豹子头");
        HeroNode2 hero3 = new HeroNode2(3,"宋江","及时雨");
        HeroNode2 hero4 = new HeroNode2(4, "卢俊义", "玉麒麟");

        DoubleLinkedList list = new DoubleLinkedList();
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);

        DoubleLinkedList.printList(list.getHead());

        HeroNode2 hero = new HeroNode2(3,"公孙胜","入云龙");
        list.update(hero);

        System.out.println("================修改之后链表信息=================");

        DoubleLinkedList.printList(list.getHead());

        list.del(3);
        System.out.println("================删除之后链表信息=================");
        DoubleLinkedList.printList(list.getHead());
    }
}

//带头结点的双向链表，
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead(){
        return head;
    }

    public static void printList(HeroNode2 head){
        if(head.next == null){
            System.out.println("链表为空，不能输出链表信息！！");
            return;
        }
        HeroNode2 cur = head.next;
        while(cur!=null){
            System.out.println(cur);
            cur = cur.next;
        }
    }

    /**
     * 添加到双向链表最后面
     * @param node
     */
    public void add(HeroNode2 node){
        HeroNode2 cur = head;
        while(true){
            if(cur.next == null){
                break;
            }
            cur =cur.next;
        }
        cur.next = node;
        node.pre = cur;
    }
    public void update(HeroNode2 node){
        if(head.next == null){
            System.out.println("链表为空，不能修改");
            return;
        }
        HeroNode2 cur = head.next;
        boolean flag = false;
        while(cur != null){
            if(cur.no == node.no){
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            cur.name = node.name;
            cur.nickName = node.nickName;
        }else{
            System.out.println("没有找到该节点，不能修改");
        }
    }

    public void del(int no){
        if(head.next == null){
            System.out.println("链表为空，不能修改");
            return;
        }
        HeroNode2 cur = head.next;
        boolean flag = false;
        while(cur != null){
            if(cur.no == no){
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            cur.pre.next = cur.next;
            if(cur.next != null){
                cur.next.pre = cur.pre;
            }
        }else{
            System.out.println("没有找到对应的节点信息，删除失败");
        }
    }
}
//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public Integer number;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向上一个节点

    public HeroNode2(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    public HeroNode2(int no,Integer number){
        this.no = no;
        this.number = number;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", number='"+ number + '\'' +
                '}';
    }
}