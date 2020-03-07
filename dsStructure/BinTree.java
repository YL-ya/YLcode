package com.dataStrcture;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

//查询伪递归的概念
// 二叉树采用孩子表示法进行表示：采用的是链式存储
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

    //一：获取节点的个数：
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

    //二：获取叶子节点的个数：没有孩子的节点就是叶子节点
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

    //三：获取K层节点的个数：
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

    //四：求二叉树的高(深)度：
    public int height(){
        return height(root);
    }
    private int height(BTNode root){
        if(root==null){
            return 0;
        }
        int leftHight=height(root.left);
        int rightHight=height(root.right);
        return leftHight>rightHight?leftHight+1:rightHight+1;
    }

    //五：找到该节点并返回，没有找到返回null
    public BTNode find(){
        return find();
    }
    private BTNode find(BTNode root,int val){
        //空树的情况下：
        if(root==null){
            return null;
        }

        //是根节点的情况下：
        if(root.val==val){
            return root;
        }

        //在左右子树里面：
        BTNode findNode=null;
        if((findNode=find(root.left,val))!=null||(findNode=find(root.right,val))!=null){
            return findNode;//找到了返回
        }
        return null;//没找到返回null
    }

    //六：判断两个二叉树是否相同
    public boolean isSame(){
        return isSame(root,root);
    }
    private boolean isSame(BTNode p,BTNode q){
        //判断树是否为空：
        if(p==null&&q==null){
            return true;
        }

        //判断连个树中其中有一个是空树:
        if(p==null||q==null){
            return false;
        }

        //接下来判断两个树的左右子树
        return isSame(p.left,q.left)&&isSame(p.right,q.right);
    }

    //七：判断是不是子树;
    /*1：结构相同
    * 2：完全一样
    * 3：空树是任意树的子树*/
    public boolean isChildTree(){
        return  isChildTree(root,root);
    }
    private boolean isChildTree(BTNode s,BTNode t){
        //当s空树的时候
        if(s==null){
            return false;
        }

        //s不为空树，t为空树
        if(s!=null&&t==null){
            return true;
        }

        //完全一样的时候：
        if((s.val==t.val)&&isSame(s,t)){
            return true;
        }

        //是子树的情况下：
        return isChildTree(s.left,t)||isChildTree(s.right,t);
    }

    //八：判断是否是平衡二叉树：
    //该方法的效率比较的低：O(n^2)：因为子树的高度重复求解：因为这个是从跟开始，那么每次都会去判断子树的平衡
    //优化：从子树开始，并且每次返回的时候将高度带出来，然后根节点进行减法进行了
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(BTNode root){
        if(root==null){
            return true;
        }
        //2：求左右子树的高度：
        int leftHight=height(root.left);
        int rightHight=height(root.right);
        if(Math.abs(leftHight-rightHight)>1){//高度差的绝对值大于1的时候，非平衡二叉树
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    //九：层序遍历(也称作广度优先遍历)：采用队列的方式
    /*思路：
    * 1：空树：直接进行返回
    * 2：让根先入队列
    * 循环执行以下操作：
    * 2.1：如果队列不为空，去队头元素
    * 2.2：遍历该节点
    * 2.3：如果当前有左子树，将左子树入队列
    * 2.4：如果当前有右子树，将右子树入队列*/
    private void levelOrder(){
        if(root==null){
            return;
        }
        Queue<BTNode> q=new LinkedList<>();
        q.offer(root);//先将根节点放入队列
        while(!q.isEmpty()){
            //先将对头节点取出来：
            BTNode cur=q.poll();
            System.out.print(cur.val+" ");

            //如果cur有左子树，将左子树，入队列
            if(cur.left!=null){
                q.offer(cur.left);
            }

            //如果cur节点由右子树，则将右子树入队列
            if(cur.right!=null){
                q.offer(cur.right);
            }
        }
        System.out.println();
    }

    //十：前序非递归遍历方式1：利用栈
    /*思路：先遍历左子树，在遍历右子树
    * 1：将根节点入栈
    * 循环以下操作：
    * 2：取栈顶元素cur，并打印遍历
    * 3：删除栈顶元素
    * 4：如果cur的右子树不为空，将其入栈(保存起来)
    * 5：如果cur的左子树不为空，将其入栈(保存起来)
    * 注意：在这里一定是先将右子树入栈，因为先进的后出*/
    private void preOrder1(){
        if(root==null){
            return;
        }

        Stack<BTNode> q=new Stack<>();
        q.push(root);
        while (!q.empty()) {
            BTNode topNode=q.peek();
            System.out.print(topNode.val+" ");
            q.pop();

            //如果栈顶元素也就是根节点：topNode
            //注意：一定是先是右子树：因为先进的后出
            if (topNode.right != null) {
                q.push(topNode.right);
            }

            //如果topNode的左子树存在，就将其入栈
            if (topNode.left != null) {
                q.push(topNode.left);
            }
        }
        System.out.println();
    }

    //十一：前序遍历非递归方法2：一条路走到底
    /*思路：
    * 1：让cur一直走它的左孩子：cur=cur.left
    * 2：在一直走的过程中将节点的右孩子进行保存即可(因为先保存的孩子要在后面进行打印，所以才用栈的结构)*/
    public void preOrder2(){
        if(root==null){
            return;
        }

        Stack<BTNode> p=new Stack<>();
        p.push(root);

        while (!p.empty()) {
            BTNode cur=p.peek();//外层循环是用来管理右子树的
            p.pop();
            while (cur != null) {//管理左子树
                System.out.print(cur.val + " ");
                if (cur.right != null) {
                    p.push(cur.right);
                }
                cur = cur.left;
            }
        }
        System.out.println();
    }

    //十二：遍历方式：前序，中序，后序
    //前序遍历：根节点，根节点的左子树，根节点的右子树，将节点中的值进行打印
    /*前序遍历相当于深度优先遍历：一条路走到通*/
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

    //十三：判断是否是完全二叉树：
    /*思路：（设该树有k层）
    * 1：（在k-1层里面）找到第一个孩子不全的节点（1：只有左孩子 2：只有右孩子 3：没有孩子）
    * 2：如果某个节点只有右孩子没有左孩子→一定不是完全二叉树
    * 总结：
    * 1：找到第一个不饱和的节点，然后后序的节点一定是没有孩子的(否则不是完全二叉树)
    * 实现方式：
    * 1：层序遍历树，找到第一个不是饱和节点
    * 2：从该节点之后的所有节点不能有孩子，如果有则一定不是完全二叉树*/
    public boolean isCompleteBinTree(){
        return isCompleteBinTree(root);
    }
    private boolean isCompleteBinTree(BTNode root){
        //1：空树也是完全二叉树
        if(root==null){
            return true;
        }

        //2：树非空
        Queue<BTNode> z=new LinkedList<>();
        z.offer(root);
        boolean isLeafOrLeft=false;
        while (!z.isEmpty()) {
            BTNode cur = z.poll();

            if (isLeafOrLeft == true) {
                //2：从第一个不饱和节点之后，所有的节点都不能有孩子
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            } else {
                //1：按照层序遍历找到第一个不饱和节点(叶子节点，只有一个孩子的节点)
                //cur节点的左右孩子均存在
                if (cur.left != null && cur.right != null) {
                    z.offer(cur.left);
                    z.offer(cur.right);
                } else if (cur.left != null) {//cur只有左孩子，即是不饱和的节点，判断后序的节点是否有孩子节点
                    z.offer(cur.left);
                    isLeafOrLeft = true;//当该变量为true的时候，说明地已经找到了饱和节点的位置
                } else if (cur.right != null) {//cur只有右孩子
                    return false;//只有右孩子的情况下肯定不是完全二叉树
                } else {//该节点是叶子节点
                    isLeafOrLeft = true;
                }

            }
        }
        return true;
    }

    public List<List<Integer>> levelOrder1() {
        return levelOrder1(root);
    }
    private List<List<Integer>> levelOrder1(BTNode root){
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }

        //先建立一个队列：
        Queue<BTNode> q=new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>(size);
            for (int i = 0; i <size ; i++) {
                BTNode cur=q.poll();
                level.add(cur.val);

                //然后将左右子树放入队列：
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            //退出里层循环是已经将一层的节点里面的值放入了一个一位数组中，
            // 只用将它加在自己创建的动态二维数组中即可
            ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        BinTree binTree=new BinTree();
        binTree.preOrder();//这里调用者精良不传参，因为还要去了解那些参数的概念
        binTree.inOrder();
        binTree.preOrder();
        if(binTree.isCompleteBinTree()){
            System.out.println("It is a complete tree!!!");
        }else {
            System.out.println("It is not a complete tree!!!");
        }
        binTree.levelOrder();
        binTree.preOrder1();
        binTree.preOrder2();
        binTree.levelOrder1();
        System.out.println("二叉树的节点："+binTree.getNodeCount());
        System.out.println("二叉树的叶子节点个数："+binTree.getLeafCount());
        System.out.println(binTree.getLevelNodeCount(3));
    }
}