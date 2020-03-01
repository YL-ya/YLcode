package com.arithmetic.sort;

import java.util.Arrays;

//快速排序：是对冒泡排序的一种改进
/*
* 快速排序的思路：通过一趟排序（在这里定义一个基准线），将要排序的数据分割成两部分，其中一部分是小于那个临界值，一部分大于临界值
* 继续在那两部分里面进行排序即可*/
public class QuickSort {
    public static void main(String[] args) {
        int[]arr={-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序;-9,78,0,23,-567,70
    //思路：设置两个指针，分别在基准的两个边，同时开始进行遍历：
    //第一趟的到的是：-9，-567,0,23,78，70；然后进行递归（左右都进行递归进行判断即可）
    public static void quickSort(int[]arr,int left,int right){
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
    }
}
