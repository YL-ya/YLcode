package com.dataStrcture;

//自定义优先级队列：
//为了实现简单，我们的自定义优先级队列中放的是int型
//假设是实现一个小堆
public class MyPriorityQueue {
    private int[]arr;
//    private int size;//表示优先级队列中有效元素 的个数

    //构造方法1：
    public MyPriorityQueue(){
        //默认的容量大小是11
        arr=new int[11];
//        size=0;
    }

    //构造方法2：
    public MyPriorityQueue(int Capacity){
        if(Capacity<1){
            //标准库：抛出一个非法参数的异常
            Capacity=11;
        }
        arr=new int[Capacity];//默认要为11
//        size=0;
    }

    //构造方法3：
    //注意：标准库中没有该种接口，是用的ArrayList，也就是说采用的是集合的方式来构造优先级队列的
    public MyPriorityQueue(int[]array){
        arr=new int[array.length];//自己根据用户提供的的参数进行构造多大的优先级队列

        //将提供的数组元素放进优先级队列
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=array[i];
        }
        //将arr中的元素进行调整，满足堆的性质

        //找倒数第一个非叶子节点：也就是最后的一个叶子节点(数组中的最后一位)的双亲：(arr.length/2+1）
        int lastLeaf=arr.length>>1-1;
        for(int root=lastLeaf;root>=0;root--){
            shiftDown(root);
        }
    }

    //parent：表示本次需要调整的节点的下标
    //调整以parent为根的的二叉树
    //注意：调整之前，一定要满足parent的左右子树已经满足小堆的性质，才可以调整好

    /*如果检测parent是否满足小堆的的性质，只需要使用parent与其孩子进行比较
     *满足小堆性质：说明以parent为根节点的二叉树已经是小堆
     *不满足小堆的性质：水命parent比他的孩子大，这时候，parent和较小的孩子进行交换，
                     *交换之后，parent较大的元素进行下移，看呢过导致子树不满足校队的性质，需要继续调整其子树即可*/
    private void shiftDown(int parent){
        //标志较小的孩子：child
        //默认情况下先让其标记左孩子，因为parent可能有左孩子，但是没有右孩子
        int child=parent*2+1;
        int size=arr.length;

        while (child<size) {//就是没有孩子节点的时候


            //在比较左右孩子的时候，一定保证右孩子存在：while()：该循环已经保证左孩子的存在了
            if (child+1<size&&arr[child + 1] < arr[child]) {
                child += 1;
            }

            //检测双亲是否比较小的孩子小：
            if (arr[child] < arr[parent]) {
                //说明parent不满足小堆的性质：让双亲和孩子进行交换即可，也就是让parent和child进行交换
                swap(parent, child);

                //parent较大的元素向下移动的时候可能就会导致子树不满足小堆的性质
                //向下继续调整即可：

                parent = child;
                child = parent * 2 + 1;//在这还要继续判断，所以可以采用循环
            } else {
                //表示以parent为根的二叉树已经满足小堆的情况
                return;
            }
        }
    }

    private void swap(int parent,int child){//为什么不传数组，因为现在数组都是内部元素
        int temp=arr[parent];
        arr[parent]=arr[child];
        arr[child]=temp;
    }

    //测试一下：
    public static void main(String[] args) {
        int []arr={5,3,7,1,3,6,8,0,2};
        MyPriorityQueue mp=new MyPriorityQueue(arr);
        /*new一个对象：
        * 1：在堆上分配内存空间
        * 2：调用构造函数进行初始化*/

    }
}
