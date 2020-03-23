package com.dataStrcture.huffmantree;
//哈弗曼树：带权路径最小的二叉树：最优二叉树

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//1：创建节点：
//为了让Node 对象持续排序Collections集合支持排序，让Node实现Comparable接口
class Node implements Comparable<Node>{
    int val;//节点的权值
    Node left;//左节点
    Node right;//右节点

    public Node(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "Node[val="+val+"]";
    }

    @Override
    public int compareTo(Node o) {
        //这样表示的是从小到大排序
        return this.val-o.val;

        //这样表示的是从大到小排序:加个负号
        //return -(this.val-o.val);
    }

    //写一个前序遍历：进行测试：
    public void pre(){
        System.out.println(this);
        if(this.left!=null){
            this.left.pre();
        }
        if(this.right!=null){
            this.right.pre();
        }
    }
}

public class HuffmanTree {
    //创建哈弗曼树：
    public static Node createHuffmanTree(int[]arr){
        /*1：为了操作方便，遍历数组
         * 2：将数组中的每个元素构造成一个节点Node
         * 3：将节点放入到ArrayList中去：因为排序直接用集合就行了*/
        List<Node> nodes=new ArrayList<Node>();
        for(int val:arr){
            nodes.add(new Node(val));
        }

        //开始处理：循环
        while (nodes.size()>1) {
            //1：将数组进行排序：从小到大
            Collections.sort(nodes);
            System.out.println("排序后：" + nodes);

            //2：取出根节点取值最小的两个二叉树：
            //2.1：取出权值最小的节点：
            Node leftNode = nodes.get(0);
            //2.2：取出次小的权值小的节点
            Node rightNode = nodes.get(1);
            //2.3：构建一个新的二叉树
            Node parent = new Node(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;

            //3：从ArrayList中删除处理过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //4：将新建立的节点加入进去：
            nodes.add(parent);
        }
        //5：返回根节点
        return nodes.get(0);
    }

    //编写一个前序遍历的方法：
    public static void preOrder(Node root){
        if(root!=null){
            root.pre();
        }else {
            System.out.println("是空树，不能遍历");
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        //测试：
        preOrder(root);
    }
}
