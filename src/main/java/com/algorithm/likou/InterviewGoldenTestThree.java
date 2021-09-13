package com.algorithm.likou;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.*;

/**
 * @author admin
 * @title: InterviewGoldenTest
 * @projectName base_thread
 * @description: TODO
 * @date 2020/11/25 10:00
 *
 * 算法练习：力扣网页：面试金典算法测试：
 * 链表算法题专用
 *
 */
public class InterviewGoldenTestThree {
    /**
     * 141. 环形链表
     * @param head
     * @return
     * 使用快慢指针的方式，快的指针每次走2步，慢指针走一步，当有环的时候，慢指针会和快指针重合
     *
     * 或者当链表中没有重复元素的时候，使用hash表也可以
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;//快指针每次走两步，总会追上慢指针，但是会超过慢指针N圈
        }
        return false;
    }

    /**
     * 20. 有效的括号
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if("(".equals(c) || "{".equals(c) || "[".equals(c)){
                stack.push(c);
            }else{
                if(stack.size() == 0){
                    return false;
                }
                if("(".equals(stack.peek()) && ")".equals(c)){
                    stack.pop();
                }else if("{".equals(stack.peek()) && "}".equals(c)){
                    stack.pop();
                }else if("[".equals(stack.peek()) && "]".equals(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    /**
     *
     * @param root
     * @return
     */
    static  List<Integer> res = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {

        if(root == null){
           return res;
        }
        res.add(root.val);
        if(root.left != null){
            preorderTraversal(root.left);
        }
        if(root.right!= null){
            preorderTraversal(root.right);
        }
        return res;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <queue.size(); i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(list);
        }
        return res;
    }
    int result = 0;
    public int sumRootToLeaf(TreeNode root) {
        preOrder(root,0);
        return result;
    }

    public void preOrder(TreeNode node,int sum){
        if(node == null){
            return;
        }
        int curSum = (sum<<1) | node.val;
        if(node.left == null && node.right == null){
            result += curSum;
            return;
        }
        preOrder(node.left,curSum);
        preOrder(node.right,curSum);
    }
    public static void main(String[] args) {

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode root = new TreeNode(1,treeNode2,null);
        System.out.println(preorderTraversal(root));

    }

}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
        next = null;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }