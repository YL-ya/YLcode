package com.dataStrcture;

import java.util.*;
import java.util.Queue;
import java.util.Stack;


//查询伪递归的概念
// 二叉树采用孩子表示法进行表示：采用的是链式存储
//定义每个节点
class  BTNode{
    BTNode left;//指向该节点的左子树
    BTNode right;//指向该节点的右子树
    int val;//当前节点的值

    public BTNode( int val) {
        this.val = val;
    }
}





//定义树
public class BinTree {
    private BTNode root = null;//应用二叉树的根节点
    private int count=0;//仅仅在创建二叉树的时使用

   //创建二叉树：
    /*思想：
     * 1：利用前序遍历来创建一个二叉树：根节点，根节点的左子树，根节点的右子树
     * 2：首先得先将一个不完全二叉树把他变成一个完全二叉树：不然创建出来的二叉树只有一条分支
     * [1,2,3,null,null,null,4,5,null,null,6]然后利用前序遍历：将打印节点的行为编程创建节点即可*/
   public BinTree(int [] array,int invaild) {
       root=createBinTree(array,invaild);
   }

   //创建二叉树：按照前序遍历的规则
    BTNode createBinTree(int[]arr,int invaild){
       BTNode newRoot=null;
       if(count<arr.length&&arr[count]!=invaild){//说明序列还没有走完，二叉树还没有创建完

           //创建一个根节点
           newRoot=new BTNode(arr[count]);

           //递归创建根节点的左子树
           ++count;
           newRoot.left=createBinTree(arr,invaild);

           //递归创建根节点的柚右子树
           ++count;
           newRoot.right=createBinTree(arr,invaild);
       }
        return newRoot;
    }





    /*//为了快速的进行测试：
        BTNode n1 = new BTNode(1);
        BTNode n2 = new BTNode(2);
        BTNode n3 = new BTNode(3);
        BTNode n4 = new BTNode(4);
        BTNode n5 = new BTNode(5);
        BTNode n6 = new BTNode(6);
        root = n1;
        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        n4.left = n5;
        n4.right = n6;*/

    //一：获取节点的个数：
    /*两种方法：
    1：采用遍历的三种方法(LOW)
    2：将大问题分解成小问题：
    空树的情况下：0
    非空：左子树的节点+右子树的节点个数+1(根节点)*/
    public int getNodeCount() {
        return getNodeCount(root);
    }

    private int getNodeCount(BTNode root) {
        if (root == null) {
            return 0;
        }
        return getNodeCount(root.left) + getNodeCount(root.right) + 1;
    }

    //二：获取叶子节点的个数：没有孩子的节点就是叶子节点
    /*1：空树的情况下是没有叶子节点的
     *:2：非空树：左右子树的叶子节点相加即可*/
    public int getLeafCount() {
        return getLeafCount(root);
    }

    private int getLeafCount(BTNode root) {
        if (root == null) {
            return 0;//树为空树的时候
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafCount(root.left) + getLeafCount(root.right);

    }

    //三：获取K层节点的个数：
    /*拆分成子问题：变成从子树中求解
     * 就是说如果是根节点就返回1；然后就进行子树(k-1层即可)的遍历算法*/
    public int getLevelNodeCount(int k) {
        return getLevelNodeCount(root, k);
    }

    private int getLevelNodeCount(BTNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        if (k == 1) {//第一层节点的个数:肯定是一个根节点
            return 1;
        }

        //到root的子树的k-1层节点的个数
        return getLevelNodeCount(root.left, k - 1) + getLevelNodeCount(root.right, k - 1);
    }

    //四：求二叉树的高(深)度：
    public int height() {
        return height(root);
    }

    private int height(BTNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = height(root.left);
        int rightHight = height(root.right);
        return leftHight > rightHight ? leftHight + 1 : rightHight + 1;
    }

    //五：找到该节点并返回，没有找到返回null
    public BTNode find() {
        return find();
    }

    private BTNode find(BTNode root, int val) {
        //空树的情况下：
        if (root == null) {
            return null;
        }

        //是根节点的情况下：
        if (root.val == val) {
            return root;
        }

        //在左右子树里面：
        BTNode findNode = null;
        if ((findNode = find(root.left, val)) != null || (findNode = find(root.right, val)) != null) {
            return findNode;//找到了返回
        }
        return null;//没找到返回null
    }

    //六：判断两个二叉树是否相同
    public boolean isSame() {
        return isSame(root, root);
    }

    private boolean isSame(BTNode p, BTNode q) {
        //判断树是否为空：
        if (p == null && q == null) {
            return true;
        }

        //判断连个树中其中有一个是空树:
        if (p == null || q == null) {
            return false;
        }

        //接下来判断两个树的左右子树
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    //七：判断是不是子树;
    /*1：结构相同
     * 2：完全一样
     * 3：空树是任意树的子树*/
    public boolean isChildTree() {
        return isChildTree(root, root);
    }

    private boolean isChildTree(BTNode s, BTNode t) {
        //当s空树的时候
        if (s == null) {
            return false;
        }

        //s不为空树，t为空树
        if (s != null && t == null) {
            return true;
        }

        //完全一样的时候：
        if ((s.val == t.val) && isSame(s, t)) {
            return true;
        }

        //是子树的情况下：
        return isChildTree(s.left, t) || isChildTree(s.right, t);
    }

    //八：判断是否是平衡二叉树：
    //该方法的效率比较的低：O(n^2)：因为子树的高度重复求解：因为这个是从跟开始，那么每次都会去判断子树的平衡
    //优化：从子树开始，并且每次返回的时候将高度带出来，然后根节点进行减法进行了
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(BTNode root) {
        if (root == null) {
            return true;
        }
        //2：求左右子树的高度：
        int leftHight = height(root.left);
        int rightHight = height(root.right);
        if (Math.abs(leftHight - rightHight) > 1) {//高度差的绝对值大于1的时候，非平衡二叉树
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
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
    public void levelOrder() {
        System.out.print("层序遍历(非递归)：");
        levelOrder(root);
    }

    private void levelOrder(BTNode root) {
        if (root == null) {
            return;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);//先将根节点放入队列
        while (!q.isEmpty()) {
            //先将对头节点取出来：
            BTNode cur = q.poll();
            System.out.print(cur.val + " ");

            //如果cur有左子树，将左子树，入队列
            if (cur.left != null) {
                q.offer(cur.left);
            }

            //如果cur节点由右子树，则将右子树入队列
            if (cur.right != null) {
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
    public void preOrder1() {
        System.out.print("前序遍历(非递归)：");
        preOrder1(root);
    }

    private void preOrder1(BTNode root) {
        if (root == null) {
            return;
        }

        Stack<BTNode> q = new Stack<>();
        q.push(root);
        while (!q.empty()) {
            BTNode topNode = q.peek();
            System.out.print(topNode.val + " ");
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
    public void preOrder2() {
        System.out.print("前序遍历(非递归)：");
        preOrder2(root);
    }

    public void preOrder2(BTNode root) {
        if (root == null) {
            return;
        }

        Stack<BTNode> p = new Stack<>();
        p.push(root);

        while (!p.empty()) {
            BTNode cur = p.peek();//外层循环是用来管理右子树的
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
    public void preOrder() {
        System.out.print("前序遍历(递归)：");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(BTNode root) {
        if (root != null) {//这里表示的是如果树不为空
            System.out.print(root.val + " ");
            preOrder(root.left);//进行遍历左子树
            preOrder(root.right);//进行遍历右子树
        }
    }

    //中序遍历：根节点的左子树，根节点，根节点的右子树，将节点的值进行打印
    public void inOrder() {
        System.out.print("中序遍历(递归)：");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(BTNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    //后序遍历：根节点的左子树，根节点的右子树，根节点
    public void postOrder() {
        System.out.print("后序遍历(递归)：");
        postOrder(root);//进行包装一层，让调用者看起来简单方便操作
        System.out.println();
    }

    private void postOrder(BTNode root) {
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.val + " ");
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
    public boolean isCompleteBinTree() {
        return isCompleteBinTree(root);
    }

    private boolean isCompleteBinTree(BTNode root) {
        //1：空树也是完全二叉树
        if (root == null) {
            return true;
        }

        //2：树非空
        Queue<BTNode> z = new LinkedList<>();
        z.offer(root);
        boolean isLeafOrLeft = false;
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

    //十四：层序遍历，将每层节点保存在一个动态的二维数组中
    public List<List<Integer>> levelOrder1() {
        return levelOrder1(root);
    }

    private List<List<Integer>> levelOrder1(BTNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        //先建立一个队列：
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                BTNode cur = q.poll();
                level.add(cur.val);

                //然后将左右子树放入队列：
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            //退出里层循环是已经将一层的节点里面的值放入了一个一位数组中，
            // 只用将它加在自己创建的动态二维数组中即可
            ret.add(level);
        }
        return ret;
    }

    //十五：还原二叉树：前序+中序
    public BTNode buildTree(int[] preorder, int[] inorder) {
        return reBuildTree(preorder, inorder, 0, inorder.length);
    }
    //preorder:前序的遍历结果
    //inorder:中序的遍历结果
    //[left,right):标记树中节点inorder中的范围

    int index1 = 0;

    private BTNode reBuildTree(int[] preorder, int[] inorder, int left, int right) {
        //将count给成一个全局变量，就是回溯的时候变成0了
        //int index=0;

        if (index1 >= preorder.length || left >= right) {
            //这个区间不存在，说明子树没有
            return null;
        }

        //找到根节点：在前序遍历的结果中
        BTNode root = new BTNode(preorder[index1]);//以根节点为根

        //在中序遍历结果中找根的位置
        int inrootIdx = left;//注意在这里一定不能给0
        while (inrootIdx < right) {
            if (inorder[inrootIdx] == preorder[index1]) {
                //如果找到了，解直接跳出
                break;
            }
            inrootIdx++;
        }

        //退出循环，就将根节点在中序遍历中找到了根节点
        //创建根节点：
        //TreeNode root=new TreeNode(preorder[index]);//以根节点为根
        ++index1;
        //递归的创建根节点的左子树
        //左子树的区间：[left,inrootIdx]
        root.left = reBuildTree(preorder, inorder, left, inrootIdx);

        //递归的创建根节点的右子树
        root.right = reBuildTree(preorder, inorder, inrootIdx + 1, right);

        //最后重建好了的树，直接返回一个根即可
        return root;
    }

    //十六：还原二叉树：中序+后序：
    /*思想：
     * 1：在后序遍历中找到根节点，在中序中循环找到根节点的所在位置
     * 2：创建根节点，让后序中的指针继续往下走
     * 3：然后循环创建右子树，循环创建左子树
     * 4：返回根节点*/
    int index = 0;

    private BTNode reBuildTree1(int[] postorder, int[] inorder, int left, int right) {
        index = postorder.length - 1;

        if (left >= right || index < 0) {
            return null;
        }

        //1：在中序中找到根节点的位置：
        int rootIdex = left;
        while (rootIdex < right) {
            if (postorder[index] == inorder[rootIdex]) {
                break;
            }
            ++rootIdex;
        }
        //退出循环就是找到了根节点：

        //循环创建右子树：根节点的下一个节点：
        //创建根节点：
        BTNode root = new BTNode(postorder[index]);

        index--;
        root.right = reBuildTree1(postorder, inorder, rootIdex + 1, right);

        //循环创建左子树：
        root.left = reBuildTree1(postorder, inorder, left, rootIdex);
        return root;
    }

    //十七：中序：非递归：注意：一般将递归转为非递归就是用：循环+栈(或者队列)
    //后递归的先退出：像栈的特性
    /*特点：
     * 1：中序遍历的第一个节点一定是这颗树的最左侧的节点cur=cur.left(让cur一直往左边走)，并(通过栈)将保存走过的节点
     * 2：当cur.left==null时，说明当前节点的左子树已经遍历完了，获取栈顶元素
     * 3：*/
    public void inOrderNor() {
        System.out.print("中序遍历(非递归)：");
        inOrderNor(root);
        System.out.println();
    }

    private void inOrderNor(BTNode root) {
        if (root == null) {
            return;
        }
        BTNode cur = root;

        Stack<BTNode> p = new Stack<>();
        while (!p.empty() || cur != null) {
            //1：找以root为根的最左侧的节点，并保存走过的节点：
            while (cur != null) {
                p.push(cur);
                cur = cur.left;
            }

            //退出循环cur=null
            //cur为空，就说明该棵树已经遍历，该遍历上个节点的左右子树了
            cur = p.peek();
            System.out.print(cur.val + " ");
            p.pop();

            //cur为根的二叉树的左子树已经遍历，剩余右子树还没有遍历
            cur = cur.right;
        }
    }

    //十八：后序非递归：跟中序前序遍历(非递归)很想，但是要注意的是这个要判断右子树是否遍历过
    public void postOrderNor(){
        System.out.print("后序遍历(非递归):");
        postOrderNor(root);
    }
    private void postOrderNor(BTNode root) {
        BTNode cur=root;
        BTNode prev=null;//用来标记已经遍历过的节点
        if (root == null) {
            return;
        }

        //若果树是非null

        Stack<BTNode> p=new Stack<>();

        while (cur!=null||!p.empty()){
            //1：找cur为根节点二叉树最左侧的节点：
            while(cur!=null){
                p.push(cur);
                cur=cur.left;
            }

            //2：cur=null的时候，说明该节点的左子树已经遍历完了：
            //现在该拿到该节点的右子树，只能用peek，因为现在的根节点还不能进行遍历
            BTNode top=p.peek();

            //3：遍历top的右子树
            //3.1：右子树为空的情况下：就可以遍历根节点了
            //top的右子树已经遍历完成，就可以遍历根节点
            if(top.right==null||top.right==prev){
                System.out.print(top.val+" ");
                prev=top;
                p.pop();//然后将该节点从栈中pop出
            }else {
                //3.2：右子树不为空的情况下;
                cur=top.right;
            }
        }
        System.out.println();

    }

    //十九：求指定两个节点的最近的公共祖先：
    /*思想1：从双亲表示法中的到的启示
    * 1：写一个找节点路径的方法，并将路径保存在栈中
    * 2：在两个栈中pop()值，当值相等的时候，就是他们的公共祖先：这也包含了一点链表求交点的问题：让长的先走*/
    //思路：
    //保存找两个节点的路径在栈中，然后就相当于与两条链表的相交问题;让路径长的先走差值步，然后依次进行比较

    //1：获取节点的路径
    public static boolean getNodePath(BTNode root,BTNode node,Stack<BTNode> path){
        if(root==null){
            return false;
        }

        path.push(root);
        if(root==node){
            return true;
        }

        //递归到root的左子树||右子树找node的路径
        if(getNodePath(root.left,node,path)||getNodePath(root.right,node,path)){
            return true;//找到了
        }

        //如果递归都完了还没有找到：说明该节点不再这个以root为根节点的额这颗树中，也就是没有共同的祖先
        path.pop();
        return false;//往回退就行了
    }
    public static BTNode lowestCommonAncestor(BTNode root, BTNode p, BTNode q) {
        if(root==null||p==null||q==null){
            return null;
        }

        //获取p,q节点的路径：
        Stack<BTNode> pPath=new Stack<>();
        Stack<BTNode> qPath=new Stack<>();
        getNodePath(root,p,pPath);
        getNodePath(root,q,qPath);

        int sizep=pPath.size();
        int sizeq=qPath.size();

        //两个节点对应的路径的栈，让长的先走差值步即可，直到节点的个数相同
        while(sizep!=0&&sizeq!=0){
            if(sizep>sizeq){
                pPath.pop();
                sizep--;
            }else if(sizep<sizeq){
                qPath.pop();
                sizeq--;
            }else{
                if(pPath.peek()==qPath.peek()){
                    return pPath.peek();
                }else{//两个栈找那个的元素相等的时候
                    pPath.pop();
                    qPath.pop();
                    sizep--;
                    sizeq--;
                }
            }
        }
        return null;
    }

    /*思想2：从线索二叉树中得到的
    * 1：判断是否在同一个子树中，在就返回根节点*/

    //判断是否在同一个子树中，在就直接返回当前的根节点
    public static boolean isNodeInTree(BTNode node,BTNode root){
        if(root==null){
            return false;
        }
        if(root==node) {
            return true;
        }
        if(isNodeInTree(root.left,node)||isNodeInTree(root.right,node)){
            return true;
        }
        return false;
    }
    public static BTNode lowestCommonAncestor1(BTNode root, BTNode p, BTNode q) {
        if(root==null||p==null||q==null){
            return null;
        }
        //如果有一个节点在跟的位置，最近的祖先一定是根节点root
        if(root==p||root==q){
            return root;
        }

        //检测p,q在root子树的那边？
        boolean ispInLeft=false;
        boolean ispInRight=false;
        boolean isqInLeft=false;
        boolean isqInRight=false;

        if(isNodeInTree(root.left,p)){
            ispInLeft=true;
            ispInRight=false;
        }else {
            ispInLeft=false;
            ispInRight=true;//不再左子树里面就在右子树里面
        }

        //检测q在子树中的情况
        if(isNodeInTree(root.left,q)){
            isqInLeft=true;
            isqInRight=false;
        }else {
            isqInLeft=false;
            isqInRight=true;
        }

        //p,q分别在root的左右子树中
        if((ispInLeft&&isqInRight)||(ispInRight&&isqInLeft)){
            return root;
        }else if(ispInLeft&&isqInLeft){
            return lowestCommonAncestor1(root.left,p,q);//在左子树中找
        }else {
            return lowestCommonAncestor1(root.right,p,q);//在右子树中找
        }
    }


    public static void main(String[] args) {
        int[]arr={1,2,3,-1,-1,-1,4,5,-1,-1,6,-1,-1};
        BinTree binTree = new BinTree(arr,-1);

        binTree.preOrder();//这里调用者尽量不传参，因为还要去了解那些参数的概念
        //binTree.preOrder();
        binTree.preOrder1();
        binTree.preOrder2();

        binTree.inOrder();
        binTree.inOrderNor();

        if (binTree.isCompleteBinTree()) {
            System.out.println("It is a complete tree!!!");
        } else {
            System.out.println("It is not a complete tree!!!");
        }


        binTree.levelOrder();

        binTree.levelOrder1();
        //这个是将层次遍历结果保存在一个动态的二维数组中List<List<BtNode>=new LinkedList<BtNode>();

        binTree.postOrder();
        binTree.postOrderNor();

       // System.out.println(lowestCommonAncestor(1,2,3).val);

        System.out.println("二叉树的节点：" + binTree.getNodeCount());
        System.out.println("二叉树的叶子节点个数：" + binTree.getLeafCount());
        System.out.println("二叉树的深度为：" + binTree.getLevelNodeCount(3));
    }
}
