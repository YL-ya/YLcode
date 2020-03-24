package com.dataStrcture;

import java.util.Arrays;

//自定义优先级队列：让用户自己进行选择大小堆：利用多态，动态绑定：但是这个比较的接口，是自己写的，用的时候还得告诉用户的操作
//为了实现简单，我们的自定义优先级队列中放的是int型
//假设是实现一个小堆
interface Comp{
     int compare(int left,int right);//实现该接口的类里面要进行重写该方法
}
class Less implements Comp{
    //0:left==right
    //>0:left>right
    //<0left<right
    public int compare(int left,int right){
        return left-right;//小堆
    }
}

class Greater implements Comp{
    public int compare(int left,int right){
        return right-left;//大堆
    }
}


public class MyPriorityQueue {
    private int[]arr;
    private int size;//表示优先级队列中有效元素的个数,不能用arr.length表示有效元素个数，因为length表示的数组的大小
    Comp compare=null;

    //构造方法1：
    public MyPriorityQueue(Comp comp){
        //默认的容量大小是11
        arr=new int[11];
        size=0;
        compare=comp;
    }

    //构造方法2：
    public MyPriorityQueue(int Capacity,Comp comp){
        if(Capacity<1){
            //标准库：抛出一个非法参数的异常
            Capacity=11;
        }
        arr=new int[Capacity];//默认要为11
        compare=comp;
//        size=0;
    }

    //构造方法3：
    //注意：标准库中没有该种接口，是用的ArrayList，也就是说采用的是集合的方式来构造优先级队列的
    public MyPriorityQueue(int[]array,Comp comp){
        arr=new int[array.length];//自己根据用户提供的的参数进行构造多大的优先级队列


        //将提供的数组元素放进优先级队列
        for (int i = 0; i <array.length ; i++) {
            arr[i]=array[i];
        }
        //将arr中的元素进行调整，满足堆的性质

        size=arr.length;
        compare=comp;

        //找倒数第一个非叶子节点：也就是最后的一个叶子节点(数组中的最后一位)的双亲：(arr.length/2+1）
        int lastLeaf=arr.length>>1-1;
        for(int root=lastLeaf;root>=0;root--){
            shiftDown(root);
        }
    }

    //1：实现优先级队列中的peek方法：也就是获取堆顶元素：
     int peek(){
        //标准库中，如果优先级队列是空，无法获取堆顶元素，因此返回null
        return arr[0];
    }

    //2：实现优先级队列中的offer方法：也就是入队列：扩容
    boolean offer(int x){
        //0：检测是否需要扩容：
        if(size>=arr.length){
            grow();
        }
        //1：先将元素尾插到数组中，尾插
        arr[size++]=x;
        //2：是否破坏小堆的性质
        shiftUp(size-1);//尾插在数组的最后 ，此处不能使用size--，这样就减少了数组中的有效元素

        return true;
    }

    //3：实现优先级队列中的poll方法：也就是出队列，删除
    //每次删除的是堆顶的元素
    /*删除的思想：
    * 1：删除堆顶元素，也就是数组的第一个元素，方法：将第一个元素和最后元素进行交换一下
    * 2：然后有效元素个数减1，size-1
    * 3：3.1：重新构造堆
    *    3.2：因为只是交换了一下，所以其他位置上都还是满足小堆的性质，也就是说直接进行向下调整即可*/
    int poll() {
        //1：先将堆顶元素进行保存
        int ret=arr[0];
        //2：和数组最后一个元素进行交换
        swap(ret,size-1);
        //3：size-1：有效元素的个数减1，即将堆顶元素进行删除
        size=size-1;
        //4：因现在只有堆顶元素不满足小堆的性质，现在只用进行向下调整即可
        shiftDown(0);
        //5：然后返回的堆顶元素
        return ret;
    }

    //4：实现优先级队列中isEmpty方法：也就是判断优先级队列是否为null
    boolean isEmpty(){
        return size==0;

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
        //int size=arr.length;

        while (child<size) {//就是没有孩子节点的时候


            //在比较左右孩子的时候，一定保证右孩子存在：while()：该循环已经保证左孩子的存在了
            //if (child+1<size&&arr[child + 1] < arr[child]) {
            if (child+1<size&&compare.compare(arr[child+1],arr[child])<0) {
                child += 1;
            }

            //检测双亲是否比较小的孩子小：
            //if (arr[child] < arr[parent]) {
            if(compare.compare(arr[child],arr[parent])<0){//孩子比较小
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

    //插入元素到堆中，采用的是向上调整
    private void shiftUp(int child){
        int parent=(child-1)>>1;
        while (child!=0){
            //if(arr[child]<arr[parent]){
            if(compare.compare(arr[child],arr[parent])<0){//利用我们自己写的比较器
                swap(child,parent);
                child=parent;
                parent=(child-1)>>1;
            }else {//不进行调整
                return;
            }
        }

    }

    //实现扩容：只是模拟标准库中的优先级队列的扩容的一部分
    private void grow(){
        int oldCapacity=arr.length;
        int newCapacity=oldCapacity+((oldCapacity<64)?(oldCapacity+2):(oldCapacity>>1));
        Arrays.copyOf(arr,newCapacity);//进行扩容
    }

    int size(){
        return size;
    }

    void clear(){
        size=0;//将队列中清空
    }

    private void swap(int parent,int child){//为什么不传数组，因为现在数组都是内部元素
        int temp=arr[parent];
        arr[parent]=arr[child];
        arr[child]=temp;
    }

    //测试一下：
    public static void main(String[] args) {
        int []arr={5,3,7,1,3,6,8,0,2};
        MyPriorityQueue mp=new MyPriorityQueue(arr,new Less());
        /*new一个对象：
        * 1：在堆上分配内存空间
        * 2：调用构造函数进行初始化*/
        mp.offer(9);
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.offer(-1);
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.poll();
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.clear();
        if(mp.isEmpty()){
            System.out.println("已经清空了");
        }else {
            System.out.println("非空");
        }

    }
}
