package com.atguigu.chart;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author admin
 * @title: Graph
 * @projectName base_thread
 * @description: 图的深度优先遍历算法和广度优先遍历算法
 * @date 2021/1/13 14:46
 */
public class Graph {

    /**
     *
     * @param isVisited
     * @param i
     */
    //i 第一次就是0
    /*private void dfs(boolean[] isVisited,int i){
        //首先我们访问该节点，输出
        System.out.println(getValueByIndex(i) + "->");

        //将节点设置为已经访问
        isVisited[i] = true;

        //查找节点i的第一个邻结节点w
        int w = getFirstNeighbor(i);

        while(w != -1){//说明有
            if(!isVisited[w]){
                dfs(isVisited,w);
            }

            //如果w节点已经被访问过了
            w = getNextNeighbor(i,w);

        }
    }

    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }*/

    /**
     * DFS 深度遍历递归实现
     * @param root
     */
    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * BFS 广度优先遍历
     * @param root
     */
    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
