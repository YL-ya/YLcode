package com.arithmetic.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

//递归的时间复杂度=递归的总的次数*每次递归的时间
//快排的应用场景：数据量大比较随机(数据杂乱)
//递归的深度可能比较深(压入一个栈帧(参数，返回值信息，局部变量))：可能会导致栈溢出
//快速排序：是对冒泡排序的一种改进
/*
* 快速排序的思路：不稳定
* 1：通过一趟排序（在这里定义一个基准线），将要排序的数据分割成两部分，
* 2：其中一部分是小于那个临界值，一部分大于临界值
* 3：继续在那两部分里面进行(快速)排序即可*/
/*缺点：极端：最优：场景：数据乱序；   1：平分区间(平衡二叉树：高度：log2(N)；(平均和最优)时间复杂度：Nlog2(N))
             最差：场景：数据接近有序；2：一个区间没有数据(取到的基本是最值：相当于单支树；树的高度：N;时间复杂度就是O(N^2))
* 1：递归的话，栈容量不够，资源消耗量大
* 2：采取的方法，在最后剩的数据进行插入排序
* 3：递归函数空间复杂度：递归的深度*每次递归所需要的空间
* 4：快排的空间复杂度是log2N*/
public class QuickSort {
    public static void main(String[] args) {
        int[]arr={3,8,2,6,9,7,1,4,0,5};
        quickSort(arr,0,arr.length);//左闭右开的，因为数组最后一个是作为基准值的
        play(arr);
       /* int[]arr={-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));*/

        /*//测试快速排序的事后时间复杂度：随机产生80000个数
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);//生成[0,80000）的随机数
        }

        //将运行的时间进行前后的比较并输出
        Date date1 = new Date();
        //将时间进行格式化：
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + data1);

        //进行插入排序：
        quickSort(arr,0,arr.length-1);

        Date date2=new Date();
        String data2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+data2);*/
    }

    public static void insertSort(int[]arr,int left,int right){

    }
    //2：优化递归次数：当区间中的值很少的情况下就不再使用递归了
    public static void quickSort(int[]arr,int left,int right){
        if(right-left>16) {
            insertSort(arr,left,right);//采用插入排序来优化递归过深的问题(只能减低栈溢出，不能绝度的杜绝)
                                      //当想要绝对的杜绝递归产生的栈溢出的情况：不要再用递归了，使用循环来进行
        }else {
            //这样就是说明区间至少还有两个元素
            //按照基准值对[Left,right)区间进行分割
            int div=partion1(arr,left,right);

            //递归排基准值的左边
            quickSort(arr,left,div);

            //递归排基准值的右边
            quickSort(arr,div+1,right);
        }
    }

    //1：取基准值的优化：
    //从区间最左侧，中间，最右侧去基准值，对该三个位置进行比较，返回比较结果的中间值
    //三数取中法;优化极端的情况
    public static int getIndexOfMiddle(int[]arr,int left,int right){
        int mid=left+((right-left)>>1);
        //int mid=(left+right)>>1;容易溢出
        if(arr[left]<arr[right-1]){
            if(arr[mid]<arr[left]){
                return left;
            }else if(arr[mid]>arr[right-1]){
                return right-1;
            }else {
                return mid;
            }
        }else {
            if(arr[mid]>arr[left]){
                return left;
            }else if(arr[mid]<arr[right-1]){
                return right-1;
            }else {
                return mid;
            }
        }
    }

    //快排：将递归转循环：一般会用到栈(有些情况可以直接进行转化：斐波那契：迭代)
    /*为什么将递归转成循环一般要用到栈？
    * 1：栈的特性：先进后出
    * 2：递归的特性:先调用的方法后退出*/
    public static void quickSort(int []arr){
        Stack<Integer> s=new Stack<>();
        s.push(arr.length);
        s.push(0);
        while (!s.empty()){
            int left=s.pop();
            int right=s.pop();
            if(right-left>1){
                int div=partion1(arr,left,right);
                //形成了两个区间[left,div)[div+1,right)
                s.push(right);
                s.push(div+1);
                s.push(div);
                s.push(left);
            }
        }
    }


    public static void play(int[]arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /*思想：定义两个变量法：
     * 1：定义两个变量：begin和end，一个从前往后(找大的)一个从后往前(找小的)
     * 2：找到之后停止
     * 3：将两个值进行交换
     * 上述三个步骤进行循环即可
     * 4：循环完了之后，将begin所在位置与基准值进行交换*/
    //基准值从数组的最后一个位置开始取
    //[left,right)：划分方法1的时间复杂度是O(N)：也就是说begin和end将整个数组进行了遍历了一遍;空间复杂度：O(1)
    public static int  partion1(int []arr,int left,int right){
        int begin=left;
        int end=right-1;
        int mid=getIndexOfMiddle(arr,left,right);
        swap(arr,mid,right-1);//优化那个最差的情况
        int key=arr[end];//找基准值

        while (begin<end) {
            //1：begin从前往后找比基准值大的元素，找到停下来
            while (begin<end&&arr[begin] <= key) {
                begin++;
            }

            //2：end从后往前找，比基准值小的元素
            while (begin<end&&arr[end] >= key) {
                end--;
            }
        }
        if(begin!=right-1) {//保证区间类中有两个值
            swap(arr, begin, right - 1);
        }
        return begin;
    }

    /*思想：挖坑法：
    * 1：begin从left开始，end从right-1 开始*/
    //基准值从end位置开始：时间复杂度：O(N)：也是两个元素将被整个数组进行遍历了一遍；空间复杂度：O(1)
    public static int partion2(int []arr,int left,int right){
        int begin=left;
        int end=right-1;
        int mid=getIndexOfMiddle(arr,left,right);
        swap(arr,mid,right-1);//优化那个最差的情况
        int key=arr[end];
        while (begin<end){
            //1：begin从前往后找，找到基准值大的元素
            while (begin<end&&arr[begin]<=key){
                begin++;
            }
            //找到了比基准值大的元素，用该元素填end挖的坑
            if(begin<end){
                arr[end]=arr[begin];
                end--;//填完坑之后，将end往前走
            }

            //2：end从后往前找，找到比基准值小的元素
            while (begin<end&&arr[begin]>=key){
                end--;
            }
            //找到了比基准值小的元素
            if(begin<end){
                arr[begin]=arr[end];
                begin++;
            }
        }

        //用可以去填最后一个坑
        arr[begin]=key;
        return begin;
    }
    /*前后的两个索引法：cur和prev
    * 1：cur走，找比基准值小的数：阻断式写法*/
    public static int partion3(int []arr,int left,int right){
        int cur=left;
        int prev=cur-1;
        int mid=getIndexOfMiddle(arr,left,right);
        swap(arr,mid,right-1);//优化那个最差的情况
        int key=arr[right-1];
        while (cur<right){//++prev==cur的时候，什么事情都不做
            if(arr[cur]<key&&++prev!=cur){//当找的数大于基准值的时候，cur往后走，小的时候进行交换即可，然后prev++
                swap(arr,cur,prev);//也就是刚开始的时候，cur和prev是一前一后；
                                  // 一段时间后，cur和prev之间有了距离(prev+1,cur)之间都比基准值大
                ++cur;
            }
        }
        if(++prev!=right-1){
            swap(arr,prev,right-1);
        }
        return prev;
    }

    public static void swap(int []arr,int parent,int child){//为什么不传数组，因为现在数组都是内部元素
        int temp=arr[parent];
        arr[parent]=arr[child];
        arr[child]=temp;
    }

    //快速排序;-9,78,0,23,-567,70
    //思路：设置两个指针，分别在基准的两个边，同时开始进行遍历：
    //第一趟的到的是：-9，-567,0,23,78，70；然后进行递归（左右都进行递归进行判断即可）
    /*public static void quickSort(int[]arr,int left,int right){
        int l=left;
        int r=right;
        //中间值，
        int mid=arr[(l+r)/2];
        int temp=0;//用于进行交换

        //循环的目的：比mid值小的放在左边，大的放右边
        while (l<r){

            //此层循环是在中间值的左边一直找，找到大的值的时候，才退出
            while (arr[l]<mid){
                l++;
            }

            //此层循环是在中间值的右边一直找，找到小的值的时候，才退出
            while (arr[r]>mid){
                r--;
            }

            //如果了l>=r，说明mid的左右两边的值，已经按照左边
            if(l>=r){
                break;
            }

            //如果上述的不满足，则就要进行交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果交换完了之后，发现a[l]==mid，让r--,前移
            if(arr[l]==mid){
                r--;
            }

            //如果交换完了之后，发现a[r]==mid,让l++,后移
            if(arr[r]==mid){
                l++;
            }
        }

        //上面只是进行了将排序的数分成了两部分
        //下面值左右两部分进行递归
        //如果l==r，必须l++,r--,否则栈溢出
        if(l==r){
            l++;
            r--;
        }

        //向左递归：
        if(left<r){
            quickSort(arr,left,r);
        }

        //向右递归
        if(right>l){
            quickSort(arr,l,right);
        }
    }*/
}
