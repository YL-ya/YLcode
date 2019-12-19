package com.dataStrcture;
import java.util.Arrays;
//归并排序：用的思想是分而治之
/*1·归并排序的时间复杂度是很低的：因为他的复杂度只是数量减一即可
* 2·归并排序需要而外的空间开销*/
public class mergeSort {
    public static void main(String[] args) {
        int[]arr={8,4,5,7,1,3,6,2};
        System.out.println("排序之前的数组："+Arrays.toString(arr));
        int[]temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("排序之后的数组："+Arrays.toString(arr));
    }
    //分+合并
    public static void mergeSort(int[] arr,int left,int right,int[]temp){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);//到此为止只是将一组数据进行了分解，该位置的时候已经只有一个数据的时候了

            merge(arr,left,mid,right,temp);
        }
    }
    //合并的方法(也就是将其分排序的方法)
    /*
    * arr排序的数组
    * left左边有序序列的初始索引
    * mid中间索引
    * right右边索引
    * temp中转数组
    * */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//初始化i，左边有序数组的初始索引
        int j=mid+1;//初始化j，右边有序数组的初始索引
        int t=0;//开销数组的初始索引

        //（1）先把左右两边（有序）的数据拷贝到temp数组中，直到又一边的数组已经拷贝完成
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){//当左边的数小于右边的数，就把左边的数拷贝进temp数组
                temp[t]=arr[i];
                t++;
                i++;
            }else{
                temp[t]=arr[j];
                t++;
                j++;
            }
        }

        //（2）当上面的循环跳出后，就是还有一边的数组还没有走完，进行将剩余的数全部拷贝进temp数组中
        while(i<=mid){//说明左边的没有走完
            temp[t]=arr[i];
            t++;
            i++;
        }
        while(j<=right){//说明左边的没有走完
            temp[t]=arr[j];
            t++;
            j++;
        }

        //（3）将temp的数组中的数拷贝或arr数组,这时候的temp的下标已经不为0了,所以要重新将t值赋值为0
        t=0;
        int tempLeft=left;//为了不让left一定，创建一个变量，让其移动即可
        while(tempLeft<=right){//不一定将temp数组全部拷贝到arr数组中
            arr[tempLeft]=temp[t];
            tempLeft++;
            t++;
        }
    }

}
