package com.arithmetic.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//快速排序：是对冒泡排序的一种改进
/*
* 快速排序的思路：
* 1：通过一趟排序（在这里定义一个基准线），将要排序的数据分割成两部分，
* 2：其中一部分是小于那个临界值，一部分大于临界值
* 3：继续在那两部分里面进行(快速)排序即可*/
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

    public static void quickSort(int[]arr,int left,int right){
        if(right-left>1){
            //这样就是说明区间至少还有两个元素
            //按照基准值对[Left,right)区间进行分割
            int div=partion(arr,left,right);

            //递归排基准值的左边
            quickSort(arr,left,div);

            //递归排基准值的右边
            quickSort(arr,div+1,right);
        }
    }

    public static int partion(int []arr,int left,int right){
        int cur=left;
        int prev=cur-1;
        int key=arr[right-1];
        while (cur<right){
            if(arr[cur]<key&&++prev!=cur){
                swap(arr,cur,prev);
                ++cur;
            }
        }
        if(++prev!=right-1){
            swap(arr,prev,right-1);
        }
        return prev;
    }
    public static void play(int[]arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /*思想：
     * 1：定义两个变量：begin和end，一个从前往后(找大的)一个从后往前(找小的)
     * 2：找到之后停止
     * 3：将两个值进行交换
     * 上述三个步骤进行循环即可
     * 4：循环完了之后，将begin所在位置与基准值进行交换*/
    //基准值从数组的最后一个位置开始取
    //[left,right)
    public static int  partion1(int []arr,int left,int right){
        int begin=left;
        int end=right-1;
        int key=arr[arr.length-1];//找基准值

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
        if(begin!=right-1) {
            swap(arr, begin, right - 1);
        }
        return begin;
    }

    /*思想：挖坑法：
    * 1：begin从left开始，end从right-1 开始*/
    //基准值从end位置开始
    public static int partion2(int []arr,int left,int right){
        int begin=left;
        int end=right;
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
    public static void swap(int[]arr,int parent,int child){//为什么不传数组，因为现在数组都是内部元素
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
