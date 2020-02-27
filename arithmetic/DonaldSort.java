package com.arithmetic.sort;

import java.util.Arrays;

//希尔排序：也相当于一种插入排序，是比插入排序更高效的排序，也成缩小增量排序；
// 因为当数组为{2,3,4,5,6,1}时，本来只需用交换一次的，但是插入排序需要后移很多次，降低了算法的效率
/*希尔排序：
* 算法的思想：就是将一组数据进行分组，将分的每一组进行插入排序即可，到最后直接成为2/2=1，分组为一组的时候，
*            差不多已经开始有序，然后最后一次继续用插入排序，会很快编程了一个有序数组
* 希尔排序也就是将大的数据尽量往后放*/
public class DonaldSort {
    public static void main(String[] args) {
        int[]arr={8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前的数组"+Arrays.toString(arr));
        shellSort(arr);


    }
    //使用逐步推到的方式，编写希尔排序：在插入的时候使用的是交换法，优化的是移动法
    public static void shellSort(int[]a){
        //根据逐步分析找到规律：使用循环就能解决问题
        int count=0;
        int temp=0;
        for (int k = a.length/2;k >0; k/=2) {//外层循环是进行分组的体现,步长：就是距离
            for (int i = k; i <a.length ; i++) {
                //内循环是用来遍历每一组的成员
                for (int j = i-k; j>=0 ; j-=k) {
                    //如果当前元素大于加上步长后的元素，说明交换
                    if(a[j]>a[j+k]){
                        count=a[j];
                        a[j]=a[j+k];
                        a[j+k]=count;
                    }
                }
            }
            System.out.println("希尔排序第"+(++temp)+"轮后的数组"+Arrays.toString(a));
        }


        /*//希尔排序的第一轮：是将十个数字分成了五组
        for (int i = 5; i <a.length ; i++) {
            //内循环是用来遍历每一组的成员
            for (int j = i-5; j>=0 ; j-=5) {
                //如果当前元素大于加上步长后的元素，说明交换
                if(a[j]>a[j+5]){
                    int tamp=a[j];
                    a[j]=a[j+5];
                    a[j+5]=tamp;
                }
            }
        }
        System.out.println("第一轮排序后的数组："+ Arrays.toString(a));

        //希尔排序第二轮：是将十个数分成了5/2=2组
        for (int i = 2; i <a.length ; i++) {
            //内循环是用来遍历每一组的成员
            for (int j = i-2; j>=0 ; j-=2) {
                //如果当前元素大于加上步长后的元素，说明交换
                if(a[j]>a[j+2]){
                    int tamp=a[j];
                    a[j]=a[j+2];
                    a[j+2]=tamp;
                }
            }
        }
        System.out.println("第二轮排序后的数组："+ Arrays.toString(a));

        //希尔排序第三轮：是将十个数分成了2/2=1组
        for (int i = 1; i <a.length ; i++) {
            //内循环是用来遍历每一组的成员
            for (int j = i-1; j>=0 ; j-=1) {
                //如果当前元素大于加上步长后的元素，说明交换
                if(a[j]>a[j+1]){
                    int tamp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tamp;
                }
            }
        }
        System.out.println("第三轮排序后的数组："+ Arrays.toString(a));*/



    }

}
