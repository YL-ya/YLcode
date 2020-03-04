package com.dataStrcture;
//二叉树采用孩子表示法进行表示：采用的是链式存储
//定义每个节点
class BTNode{
    BTNode left;//指向该节点的左子树
    BTNode right;//指向该节点的右子树
    int val;//当前节点的值

    public BTNode( int val) {
        this.val = val;
    }
}

//定义树
public class BinTree {
    private BTNode root=null;//应用二叉树的根节点

    //遍历方式：前序，中序，后序
    //前序遍历：根节点，根节点的左子树，根节点的右子树，将节点中的值进行打印
    public void preOrder(BTNode root){
        if(root!=null){//这里表示的是如果树不为空
            System.out.print(root.val);
            preOrder(root.left);//进行遍历左子树
            preOrder(root.right);//进行遍历右子树
        }
    }
    public static void main(String[] args) {

    }
}
