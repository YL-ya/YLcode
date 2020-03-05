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

    //为了快速的进行测试：
    public BinTree(){
        BTNode n1=new BTNode(1);
        BTNode n2=new BTNode(2);
        BTNode n3=new BTNode(3);
        BTNode n4=new BTNode(4);
        BTNode n5=new BTNode(5);
        BTNode n6=new BTNode(6);
        root=n1;
        n1.left=n2;
        n1.right=n4;
        n2.left=n3;
        n4.left=n5;
        n4.right=n6;
    }

    //获取节点的个数：
    /*两种方法：
    1：采用遍历的三种方法(LOW)
    2：将大问题分解成小问题：
    空树的情况下：0
    非空：左子树的节点+右子树的节点个数+1(根节点)*/
    public int getNodeCount(){
        return getNodeCount(root);
    }
    private int getNodeCount(BTNode root){
        if(root==null){
            return 0;
        }
        return getNodeCount(root.left)+getNodeCount(root.right)+1;
    }

    //获取叶子节点的个数：没有孩子的节点就是叶子节点
    /*1：空树的情况下是没有叶子节点的
    *:2：非空树：左右子树的叶子节点相加即可*/
    public int getLeafCount(){
        return getLeafCount(root);
    }
    private int getLeafCount(BTNode root){
        if(root==null) {
            return 0;//树为空树的时候
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafCount(root.left)+getLeafCount(root.right);

    }

    //获取K层节点的个数：
    /*拆分成子问题：变成从子树中求解
    * 就是说如果是根节点就返回1；然后就进行子树(k-1层即可)的遍历算法*/
    public int getLevelNodeCount(int k){
        return getLevelNodeCount(root,k);
    }
    private int getLevelNodeCount(BTNode root,int k){
        if(root==null||k<1){
            return 0;
        }

        if(k==1){//第一层节点的个数:肯定是一个根节点
            return 1;
        }

        //到root的子树的k-1层节点的个数
        return getLevelNodeCount(root.left,k-1)+getLevelNodeCount(root.right,k-1);
    }


    //遍历方式：前序，中序，后序
    //前序遍历：根节点，根节点的左子树，根节点的右子树，将节点中的值进行打印
    public void preOrder(){
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println();
    }
    private void preOrder(BTNode root){
        if(root!=null){//这里表示的是如果树不为空
            System.out.print(root.val+" ");
            preOrder(root.left);//进行遍历左子树
            preOrder(root.right);//进行遍历右子树
        }
    }

    //中序遍历：根节点的左子树，根节点，根节点的右子树，将节点的值进行打印
    public void inOrder(){
        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();
    }
    private void inOrder(BTNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }

    //后序遍历：根节点的左子树，根节点的右子树，根节点
    public void postOrder(){
        System.out.print("后序遍历：");
        preOrder(root);//进行包装一层，让调用者看起来简单方便操作
        System.out.println();
    }
     private void postOrder(BTNode root){
        if(root!=null){
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.val+" ");
        }
    }
    public static void main(String[] args) {
        BinTree binTree=new BinTree();
        binTree.preOrder();//这里调用者精良不传参，因为还要去了解那些参数的概念
        binTree.inOrder();
        binTree.preOrder();
        System.out.println("二叉树的节点："+binTree.getNodeCount());
        System.out.println("二叉树的叶子节点个数："+binTree.getLeafCount());
        System.out.println(binTree.getLevelNodeCount(3));
    }
}
