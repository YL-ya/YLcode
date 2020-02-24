package com.arithmetic.sort;

import java.util.Arrays;

//冒泡排序：对待排序序列从前向后进行排序（从前向后）依次比较相邻元素的值，若发现逆序则进行交换，使得值较大的数字逐渐往后移动
//涉及优化：下一趟比较一次都没有进行交换，说明数组已经有序了，
// 因此要在排序的过程中设置一个标志flag判断是否交换过，从而减少不必要的比较（可以在冒泡排序之后进行优化）
/*
* 冒泡排序特点：
* 1：一共要进行数组大小减一的次数
* 2：每一趟排序的次数在减少
* 3：优化：如果我们发现在某趟排序中，没有发生过一次交换，可以提前结束冒泡排序*/
public class BubbleSort {
    public static void main(String[] args) {
        int[]arr={3,9,-1,10,-2};

        //第一趟排序是将最大的数排在数组的最后：时间复杂度：O(n^2)
        int temp=0;
        boolean flag=false;
        for (int j= 0; j <arr.length ; j++) {

            for (int i = 0; i < arr.length -1-j; i++) {//五个变量要进行四次交换：j是0~3
                //如果前面的数大于后面的数，则进行交换
                if (arr[i] > arr[i + 1]) {
                    flag=true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            //优化：就是将一趟排序完成后判断是会否发生过交换即可
            //一趟排序完了之后发该趟排序中没有发生一次交换，则认为已经排序好了
            if(flag==false){//if(!flag)
                break;//提前结束冒泡排序，因为已经有序
            }else {
                flag=false;//在这里重置flag置为了判断下一趟的排序
            }
        }
        System.out.println("趟排序后的数组："+ Arrays.toString(arr));
    }
}

        /*//第一趟排序是将最大的数排在数组的最后
         for (int i = 0; i <arr.length -1-0; i++) {//五个变量要进行四次交换
            //如果前面的数大于后面的数，则进行交换
            if(arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println("第二趟排序后的数组："+ Arrays.toString(arr));

        //第二趟排序是将第二大的数排在数组的倒数第二位
        for (int i = 0; i <arr.length -1-1; i++) {//四个变量要进行三次交换（因为数组的最后一位已经确定是最大的不用再进行排序了）
            //如果前面的数大于后面的数，则进行交换
            if(arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println("第二趟排序后的数组："+ Arrays.toString(arr));

        //第三趟排序是将第三大的数排在数组的倒数第三位
        for (int i = 0; i <arr.length -1-1-1; i++) {//三个变量要进行两次交换
            //如果前面的数大于后面的数，则进行交换
            if(arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println("第三趟排序后的数组："+ Arrays.toString(arr));

        //第四趟排序是将第四大的数排在数组的倒数第四位
        for (int i = 0; i <arr.length -1-1-1-1; i++) {//两个变量要进行一次交换
            //如果前面的数大于后面的数，则进行交换
            if(arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println("第四趟排序后的数组："+ Arrays.toString(arr));*/

