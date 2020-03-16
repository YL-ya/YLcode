package com.dataStrcture;
//创建中序线索二叉树：有点空间利用率高，将叶子节点左右子树的节点，用来保存前序和后继
public class ThreadedBinary {


    public static void main(String[] args) {

    }
}

//创建中序线索二叉树:
class BinTree1 {
    private BT root = null;//应用二叉树的根节点
    private int count = 0;//仅仅在创建二叉树的时使用

    //为了实现线索化，需要创建当前节点的前驱节点的一个引用
    //在递归进行线索化的时候，pre总是保留前一个节点
    private BT pre=null;

    public BinTree1(int[] array, int invaild) {
        root = createBinTree(array, invaild);
    }

    //编写二叉树进行中序线索化的二叉树的方法即可:node：当前需要线索化的的节点
    public void threadedNode(BT node){
        //当前的node为null的时候，不能进行线索化，直接返回
        if(node==null){
            return;
        }
        //1：先线索化左子树
        threadedNode(node.getLeft());
        //2：线索化当前的节点
        //3：线索化右子树
        threadedNode(node.getRight());

    }

    //创建二叉树：按照前序遍历的规则
    BT createBinTree(int[] arr, int invaild) {
        BT newRoot = null;
        if (count < arr.length && arr[count] != invaild) {//说明序列还没有走完，二叉树还没有创建完

            //创建一个根节点
            newRoot = new BT(arr[count]);

            //递归创建根节点的左子树
            ++count;
            newRoot.getLeft() = createBinTree(arr, invaild);

            //递归创建根节点的柚右子树
            ++count;
            newRoot.getRight() = createBinTree(arr, invaild);
        }
        return newRoot;
    }
}

//创建节点
class BT{
    private BT left;//指向该节点的左子树
    private BT right;//指向该节点的右子树
    private int val;//当前节点的值

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    /*说明：要进行判断里面保存的是左(右)子树，还是前驱或者后继
    * 1：当leftType==0表示指向的是左子树，如果leftType==1表示指向的是前驱节点
    * 2：当rightType==0表示指向的右子树 ，如果rightType==1表示指向的是后继节点*/



    public BT( int val) {
        this.val = val;
    }

    public BT getLeft() {
        return left;
    }

    public void setLeft(BT left) {
        this.left = left;
    }

    public BT getRight() {
        return right;
    }

    public void setRight(BT right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

