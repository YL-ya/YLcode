package com.arithmetic.sort;
//插入排序：也是内部排序法，想要将进行排序的元素以插入的方式找寻该元素的适当位置，达到排序的效果
/*
* 思路：将一组数组看成一个无序表和一个有序表组成，开始的时候有序表中只有1个元素，无序表中有n-1个元素，
*       排序过程中每次从无序表中去除一个数据插入到有序表中去即可
* 插入排序的特点：
* 1：排序需要数组大小-1趟排序
* 2：排序是直接将第一位上的数组认为是一个有序的表
* 直接插入排序的优化：
* 1：通过二分查找位置，而不是挨个济宁比较：快
* 2：搬移元素
* 3：插入*/

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[]arr={101,34,119,1};
        System.out.println("排序前的数组："+Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后的数组："+Arrays.toString(arr));


        /*//测试事后的时间复杂度：随机产生80000个数
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
        insertSort(arr);

        Date date2=new Date();
        String data2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+data2);*/
    }

    //插入排序：
    public static void insertSort(int[]a){
        for (int i = 1; i <a.length ; i++) {//从1号下标开始，因为第一个数不用进行比较
            int insertVal=a[i];
            int insertIndex=i-1;

            while(insertIndex>=0&&insertVal<a[insertIndex]){//保证那个i-1时，数组不会越界
                a[insertIndex+1]=a[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=i){//这里说明排除此时要插入的位置就是当前所在的位置
                a[insertIndex+1]=insertVal;
            }
        }

        /*//第一趟排序：{101,34,119,1}→{34,101,119,1}
        //定义待插入的数
        int insertVal=a[1];//这是待插入的数值
        int insertIndex=1-1;//要进行比较的下标

        //给insertVal找到需要插入的位置：要进行循环遍历前面的有序列表
        *//*
        * 1：insertIndex>=0：保证进行循环的时候不会发生越界的情况
        * 2：insertVal<a[insertIndex])：说明还没有找到需要插入的位置
        * 3：将a[insertIndex]往后移*//*
        while (insertIndex>=0&&insertVal<a[insertIndex]) {
            a[insertIndex+1]=a[insertIndex];
            insertIndex--;//{101,101,119,1}
            //上面的语句就是用来循环有序列表，找到要插入的位置
        }
        //退出循环就是找到了需要插入的位置
        a[insertIndex+1]=insertVal;
        System.out.println("第一趟排序后的数组："+Arrays.toString(a));

        //第二趟排序：
        insertVal=a[2];
        insertIndex=2-1;

        while (insertIndex>=0&&insertVal<a[insertIndex]){
            a[insertIndex+1]=a[insertIndex];
            insertIndex--;
        }

        a[insertIndex+1]=insertVal;
        System.out.println("第二趟排序后的数组："+Arrays.toString(a));


        //第三趟排序：
        insertVal=a[3];
        insertIndex=3-1;

        while (insertIndex>=0&&insertVal<a[insertIndex]){
            a[insertIndex+1]=a[insertIndex];
            insertIndex--;
        }

        a[insertIndex+1]=insertVal;
        System.out.println("第三趟排序后的数组："+Arrays.toString(a));*/

    }
}
