package com.atguigu.tree.basetree;

/**
 * @author admin
 * @title: BinaryTreeDemo
 * @projectName base_thread
 * @description: TODO
 * @date 2021/8/5 17:05
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //先手动创建二叉树，后面使用递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //测试
       /* System.out.println("前序遍历：");
        binaryTree.preOrder();

        System.out.println("========中序遍历：============");
        binaryTree.infixOrder();

        System.out.println("\n========后序遍历：============\n");
        binaryTree.afterOrder();*/

       /* System.out.println("***********前序遍历查找：**************");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了，信息为no=%d,name=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找到 no=%d 的英雄",5);
        }*/

        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
//        binaryTree.delNode(5);
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }
}

class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //前序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void afterOrder(){
        if(this.root != null){
            this.root.afterOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }
    public HeroNode preOrderSearch(int no){
        if(this.root != null){
           return this.root.preOrderSearch(no);
        }else{
            System.out.println("当前二叉树为空，无法遍历查找");
            return null;
        }
    }
    public HeroNode infixOrderSearch(int no){
        if(this.root != null){
            return this.root.infixOrderSearch(no);
        }else{
            System.out.println("当前二叉树为空，无法遍历查找");
            return null;
        }
    }
    public HeroNode afterOrderSearch(int no){
        if(this.root != null){
            return this.root.afterOrderSearch(no);
        }else{
            System.out.println("当前二叉树为空，无法遍历查找");
            return null;
        }
    }

    //删除节点
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null ;
                return;
            }
            root.delNode(no);
        }else{
            System.out.println("删除的二叉树为空！");
        }
    }

}

class  HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){

        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void afterOrder(){
        if(this.left != null){
            this.left.afterOrder();
        }

        if(this.right != null){
            this.right.afterOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no){
        //比较当前节点是不是
        if(this.no == no){
            return  this;
        }
        //1. 判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //1.左递归前序查找，找到结点，则返回
        //2. 当前结点的右子结点是否为空，如果不空，则继续向右递归前序查找
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrderSearch(int no){

        //1. 判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //比较当前节点是不是
        if(this.no == no){
            return  this;
        }
        //否则继续向右递归查找
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode afterOrderSearch(int no){

        //1. 判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.afterOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }

        //否则继续向右递归查找
        if(this.right != null){
            resNode = this.right.afterOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //比较当前节点是不是
        if(this.no == no){
            return  this;
        }
        return resNode;
    }

    /**
     * 递归删除节点
     * 1、如果删除的节点是叶子节点，则删除该节点
     * 2、如果删除的节点是非叶子节点，则删除该子树
     */
    public void delNode(int no){
        //思路：
        /**
         * 1、因为我们的二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除节点，而不能去判断当前这个节点是不是需要删除节点
         * 2、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null;并且就返回（结束递归删除）
         * 3、如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，就将this.right = null; 并且就返回（结束递归删除）
         * 4、如果第2和第3步没有删除节点，那么我们就需要向左子树进行递归删除
         * 5、如果第4步没有删除节点，则应当向右子树进行递归删除
         */

        //2、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null;并且就返回（结束递归删除）
        if(this.left != null && this.left.no == no){
            this.left = null;
        }
        //3、如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，就将this.right = null; 并且就返回（结束递归删除）
        if(this.right != null && this.right.no == no){
            this.right = null;
        }
        //4、如果第2和第3步没有删除节点，那么我们就需要向左子树进行递归删除
        if(this.left != null){
            this.left.delNode(no);
        }
        //5、如果第4步没有删除节点，则应当向右子树进行递归删除
        if(this.right != null){
            this.right.delNode(no);
        }
    }


}