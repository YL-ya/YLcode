package com.arithmetic.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static com.arithmetic.sort.InsertSort.insertSort;

//希尔排序：也相当于一种插入排序，是比插入排序更高效的排序，也成缩小增量排序；
// 因为当数组为{2,3,4,5,6,1}时，本来只需用交换一次的，但是插入排序需要后移很多次，降低了算法的效率
/*希尔排序：
* 算法的思想：就是将一组数据进行分组，将分的每一组进行插入排序即可，到最后直接成为2/2=1，分组为一组的时候，
*            差不多已经开始有序，然后最后一次继续用插入排序，会很快编程了一个有序数组
* 希尔排序也就是将大的数据尽量往后放*/
public class DonaldSort {
    public static void main(String[] args) {
        /*int[]arr={8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前的数组"+Arrays.toString(arr));
        shellSort2(arr);*/
        //测试希尔排序的事后时间复杂度：随机产生80000个数
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

        //进行希尔排序交换法：
        //shellSort1(arr);
        /*排序前的时间是：2020-15-28 23:15:40
        * 排序后的时间是：2020-15-28 23:15:53*/

        //进行希尔排序移动法：
        shellSort3(arr);
        /*排序前的时间是：2020-21-28 23:21:34
        * 排序后的时间是：2020-21-28 23:21:35*/


        Date date2=new Date();
        String data2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+data2);
    }
    //使用逐步推到的方式，编写希尔排序：在插入的时候使用的是交换法，优化的是移动法
    //交换法的希尔排序算法比插入排序的事后时间复杂度还要低，所以进行优化
    public static void shellSort1(int[]a){
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
            //System.out.println("希尔排序第"+(++temp)+"轮后的数组"+Arrays.toString(a));
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

    //希尔排序的交换法的优化：移位法
    public static void shellSort2(int[]a){
        //增量的控制采用循环,并逐步缩小增量
        for (int i = a.length/2; i >0 ; i/=2) {
            //从i个元素开始，逐个对其所在的组进行直接插入排序
            for (int j = i; j < a.length; j++) {
                int k=j;
                int temp=a[k];
                if(a[k]<a[k-i]){//此处有步长
                    while (k-i>=0&&temp<a[k-i]){
                        //进行移动：
                        a[k]=a[k-i];
                        k-=i;
                    }
                    //当退出while循环后就给temp找到了插入的位置
                    a[k]=temp;
                }
            }
        }
    }

    //希尔排序的另一种算法：时间复杂度：O(N^1.25)~O(1.6N^1.25)：跟gap取值有关，所以时间复杂度是不一样的
    public static void shellSort3(int[]a){
        //int gap=3;
        int gap=a.length;
        while (gap>1) {
            gap=gap/3+1;//gap：每次除以2   可每次取素数
            for (int i = gap; i < a.length; i++) {
                //1：找到待插入的元素在前面的位置：
                int key = a[i];
                int end = i - gap;

                //2：待插入元素为小的情况下进行交换即可：
                while (end >= 0 && key < a[end]) {
                    a[end + gap] = a[end];
                    end -= gap;
                }

                //3：插入元素：
                a[end + gap] = key;
            }
            gap--;
        }
    }
}
