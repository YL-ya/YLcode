package com.arithmetic.sort;
/*
* 选择排序：选择排序属于内部排序法，是想要从排序的数据当中，
*          按照指定的规则选取出某一个元素，再依照规定交换位置后达到排序的效果
* 思路：每一轮选取最小的，结果的到从小到大的结果；每一轮选取最大的，则的到的是从大到小
* 特点：
* 1：选择排序一共要进行数组大小-1次排序
* 2： 每一轮排序又是一次循环
* 2.1：先假定当前的数是最小的
* 2.2：然后和后面的每个数进行比较，如果发现有比当前数更小的数就重新确定最小的数，并得到下标
* 2.3：当遍历到数组的最后的时候，就得到本轮最小数的下标
* 2.4：然后进行交换即可
* 3：时间复杂度：
* 事前：O(n^2)
* 事后：大约是6秒*/

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/*
* 要求：将一组数从小到大进行排序：*/
public class SelectSort {
    public static void main(String[] args) {
        /*int[]arr={101,34,119,1};
        System.out.println("排序前的数组："+Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后的数组为："+Arrays.toString(arr));*/

        //测试事后的时间复杂度：随机产生80000个数
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

        //排序：
        selectSort(arr);
        Date date2=new Date();
        String data2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+data2);
    }

    //总结规律写出选择排序的算法：采用两层循环即可
    public static void selectSort(int[] a){
        for (int i = 0; i <a.length ; i++) {
            int minIndex=i;
            int min=a[i];
            for (int j = i+1; j < a.length; j++) {
                if(min>a[j]){//这里是从小到大开始排序，若编程从大到小：min<a[j]即可
                    minIndex=j;
                    min=a[j];
                }
            }
            if(minIndex!=i) {
                a[minIndex] = a[i];
                a[i] = min;
            }//这里发现如果最小值就在该位置上就无须发生交换
        }
        //System.out.println("选择排序排好的数组为："+Arrays.toString(a));
    }

    //选择排序：101,34，119，1
    public static void selectSort1(int[]a){
        //使用思路进行编写：
        // 先写出第一轮的选择排序：1，34，119,101
        int minDex=0;
        int min=a[0];
        for (int i = 0+1; i < a.length; i++) {
            if(a[i]<min){
                min=a[i];//将最小的数进行重置
                minDex=i;
            }
        }
        //退出循环，则将最小值，放在a[0]，即交换
        a[minDex]=a[0];
        a[0]=min;
        System.out.println("第一轮后的数组："+ Arrays.toString(a));


        //第二轮：
        minDex=1;
        min=a[1];
        for (int i = 0+1+1; i < a.length; i++) {
            if(a[i]<min){
                min=a[i];//将最小的数进行重置
                minDex=i;
            }
        }
        //退出循环，则将最小值，放在a[0]，即交换
        a[minDex]=a[1];
        a[1]=min;
        System.out.println("第二轮后的数组："+Arrays.toString(a));

        //第三轮：
        minDex=2;
        min=a[2];
        for (int i = 0+1+1+1; i <a.length ; i++) {
            if(a[i]<min){
                min=a[i];//将最小的数进行重置
                minDex=i;
            }
        }
        //退出循环，则将最小值，放在a[0]，即交换
        a[minDex]=a[2];
        a[2]=min;
        System.out.println("第三轮后的数组："+Arrays.toString(a));
    }
}
