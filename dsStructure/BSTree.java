package com.dataStrcture;
/*二叉搜索树：又称排序树
 * 1：中序遍历是有序的
 * 2：最左边的节点是最小的，最右边的节点是最大的
 * 3：二叉搜索树的主要功能是进行搜索的*/

//binary search tree
public class BSTree {
    public static class BSTNode{
        BSTNode left=null;
        BSTNode right=null;
        int val;
        public BSTNode(int val){
            this.val=val;
        }
    }

    private BSTNode root= null;

    //检测val知否在二叉搜索树中
    public boolean contains(int val){
        BSTNode cur=root;
        while (cur!=null) {
            if (cur.val == val) {
                return true;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    //将val插入到二叉搜索树中，成功true，失败false
    /*1：如果有该元素，则不进行插入，直接返回
    * 2：否则进行插入新节点
    * */
    public boolean put(int val){
        //空树的时候：
        if(root==null){
            root=new BSTNode(val);
            return true;
        }
        //非空的时候：
        //找待插入元素在二叉搜索树中的插入位置
        BSTNode cur=root;
        BSTNode parent=null;
        while (cur!=null){
            parent=cur;
            if(val<cur.val){
                cur=cur.left;
            }else if(val>cur.val){
                cur=cur.right;
            }else {
                return false;
            }
        }

        //退出循环的时候，已经找到待插入的位置，直接插入新的节点
        //将新的节点插入到parent的左侧或者右侧
        cur=new BSTNode(val);
        if(val<parent.val){
            parent.left=cur;
        }else {
            parent.right=cur;
        }
        return true;
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(BSTNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+"  ");
            inOrder(root.right);
        }
    }

    //得到最左侧的节点，也就是最小的节点
    public int leftMost(){
        if(root==null){
            //在这里返回的整型是不能这样的
            //所以就可以进行抛异常--》空指针异常即可

        }

        BSTNode cur=root;
        while (cur.left!=null){
            cur=cur.left;
        }
        return cur.val;
    }

    //得到最右侧的节点，也就是最大的节点
    public int rightMost(){
        if(root==null){

        }
        BSTNode cur=root;
        while (cur.right!=null){
            cur=cur.right;
        }
        return cur.val;
    }

    //删除节点：
    public boolean remove(int val){
        if(root==null){
            return false;
        }

        //树非空的情况下：找到要删除的节点：
        BSTNode cur=root;
        BSTNode parent=null;
        while (cur!=null){//说明cur只一个有效的节点
            //parent=cur;//在这里的话，到最后发现cur和parent的位置是一样的
            if(val==cur.val){
                break;//找到要删除的节点
            }else if(val<cur.val){
                parent=cur;
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }

        //退出循环，两种可能：1：找到了；2：没有找到
        if(cur==null){
            //这种情况就是没有找到
            return false;
        }

        //这种情况就是已经找到了该删除节点的位置
        /*删除节点得分情况
        * 1：cur没有孩子，也就是根节点(可以和2)，3情况的结合起来
        * 2：cur只有左孩子
        * 3：cur只有右孩子
        * 4：cur的左右孩子均存在(不可以直接删除)
        * */
        if(cur.left==null){
            //cur只有左右孩子||cur就是叶子节点
            if(parent==null){
                //cur的双亲不存在，也就是根节点
                root=cur;
            }else {
                ///双亲都存在
                if(cur==parent.left){
                    parent.left=cur.right;
                }else {
                    parent.right=cur.right;
                }
            }
        }else if(cur.right==null){
            //cur只有左孩子
            if(parent==null){
                //双亲不存在
                root=cur.left;
            }else {
                //双亲存在
                if(cur==parent.left){
                    parent.left=cur.left;
                }else {
                    parent.right=cur.left;
                }
            }
        }else {
            //cur节点的左右孩子均存在-->不能直接删除
            /*1：在cur的子树中找一个替代节点删除
            * 方式1：在其右子树中找到一个最小的节点，即右子树的最左侧的节点
            * 方式2：在其左子树中找到一个最大的节点，即左子树中最右侧的节点
            * */
            BSTNode del=cur.right;
            parent=cur;
            while (del.left!=null){//说明不是最左边的节点
                parent=del;
                del=del.left;
            }

            //退出循环说明代替节点已经找到：
            cur.val=del.val;

            //删除代替节点
            if(parent.left==del){
                parent.left=del.right;
            }else {
                parent.right=del.right;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[]arr={5,3,4,1,7,8,2,6,0,9};

        BSTree t=new BSTree();
        for (int e:arr) {
            t.put(e);
        }
        t.inOrder();
        System.out.println();
        System.out.println(t.leftMost());
        System.out.println(t.rightMost());
        t.remove(8);
        t.inOrder();;
        t.remove(4);
        t.inOrder();
        t.remove(3);
        t.inOrder();
        //删除之后中序遍历还是有序的-
    }
}