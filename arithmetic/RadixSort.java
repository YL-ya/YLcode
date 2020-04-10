package com.arithmetic.sort;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//前面的排序方法都是需要进行比较的，但是基数排序不进行比较的
/*基数排序：鸽巢原理：主要用于数据密集集中在某个范围内
* 1：统计次数
* 2：挨个回收*/

//桶排序：属于分配式排序，又称桶排序，它是通过键值的各个位的值，将要排序的元素分配到某些“桶”中，达到排序的作用
//通俗的来讲，就是一次比较个位，十位，百位，直到比较完最长的数即可停止，
// 也就是排序次数去取决于数组中最大的那个数的长度：LSD(低关键码优先：个位，十位，百位)  MSD(高关键码优先：百位，十位，个位)
/*特点：
* 1：基数排序是较为稳定的排序，效率也比较的高：也就是说有重复的数字时，前后顺序是不会发生变化的
* 2：基数排序是桶排序的扩展
* 3：速度很快*/
/*思路：
* 1：将每个数的个位数取出，然后看这个数应该放在哪个对应的桶(一位数组)
* 2：按照这个桶的顺序(一位数组的下标一次取出数据，放入到原来的数组)*/
public class RadixSort {
    public static void main(String[] args) {
        /*int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);*/
        int[]arr={3,7,2,8,3,1,9,0,4,6,5};
        //测试归并排序的事后时间复杂度：随机产生80000个数
        /*int[] arr = new int[80000];
        int[]temp=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);//生成[0,80000）的随机数
        }

        //将运行的时间进行前后的比较并输出
        Date date1 = new Date();
        //将时间进行格式化：
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + data1);*/

        //进行基数排序：
        radixSort(arr);

       /* Date date2=new Date();
        String data2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+data2);*/
    }

    //基数排序：(比特)：适用场景：数据集中某个范围内
    /*时间复杂度：O(N)：N 表示区间中元素的个数
    * 空间复杂度：O(M)：M 表示区间中元素种类的个数
    * 稳定性：稳定的*/
    public static void countSort(int[]arr){
        //1：统计元素范围
        int minValue=arr[0];
        int maxValue=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>maxValue){
                maxValue=arr[i];
            }
            if(arr[i]<minValue){
                minValue=arr[i];
            }
        }
        //循环完了只有得出范围：
        int range=maxValue-minValue+1;
        int[] arrCount=new int[range];

        //2：统计每个数出现的次数
        for (int i=0;i<arr.length;i++){
            arrCount[arr[i]-minValue]++;
        }

        //3：对元素进行回收：排序
        int index=0;
        for (int i = 0; i < range ; i++) {
            while (arrCount[i]!=0){
                arr[index]=i+minValue;
            }
        }
    }

    //桶排序：
    public static void radixSort(int[] arr) {
        //根据前面的推导过程，得到最终的基数排序的代码
        /*1：首先得到最大数
         * 2：得到最大数的位数*/
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //2：得到最大数的位数
        //巧妙的方法：将它变成字符串
        int maxLength = (max + "").length();
        //第一轮排序：针对数组中的数组的个位数
        //定义一个二维数组，表示10个桶
        //二位数组的每一行都是一个一维数组(用来表示桶)
        /*说明：1：二维数组包含10个一位数组
         * 2：为了防止在桶中放数据的时候发生溢出，则每个桶的大小定义为arr.length
         * 3：基数排序的经典的空间换时间的算法*/
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶实际存放了多少数据，我们定义一个一维数组来记录每个桶中每次放入数据的个数
        //bucketElementCounts[0]放的就是bucket[0]桶中放入数据的个数
        int[] bucketElementCounts = new int[10];

        //利用循环将代码进行处理：
        for (int b = 0, n = 1; b < maxLength; b++, n *= 10) {
            //最外层的循环是，是区分个位，十位，百位的
            for (int i = 0; i < arr.length; i++) {
                //取出元素的个数进行统计
                //取出元素的个位，十位，百位上对应位置的值即可
                int digitOfElement = arr[i] / n % 10;
                //放入到对应的桶中即可
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序(一维数组的下标一次取出数据，放进原来的数组)
            int index = 0;
            //遍历每个桶，并将桶中的数据
            for (int j = 0; j < bucketElementCounts.length; j++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[j] != 0) {//如果桶中有元素，就放入到原来的数组
                    //如果有数组，就循环第j个桶，放入即可
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        //取出的元素放进arr原数组中
                        arr[index++] = bucket[j][k];//先用再加
                    }
                }
                //第b+1轮排序完成后，一定将桶中的元素进行清0，也就是bucketElementCounts[j]==0
                bucketElementCounts[j] = 0;
            }
            /*System.out.println("第" + (b + 1) + "轮排序：" + Arrays.toString(arr));*/
        }
    }
}

        /*//第一轮：遍历数组取出元素的个位
        for (int i = 0; i < arr.length; i++) {
            //取出元素的个数进行统计
            int digitOfElement = arr[i] % 10;
            //放入到对应的桶中即可
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标一次取出数据，放进原来的数组)
        int index = 0;
        //遍历每个桶，并将桶中的数据
        for (int j = 0; j < bucketElementCounts.length; j++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCounts[j] != 0) {//如果桶中有元素，就放入到原来的数组
                //如果有数组，就循环第j个桶，放入即可
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    //取出的元素放进arr原数组中
                    arr[index++] = bucket[j][k];//先用再加
                }
            }
            //第一轮排序完成后，一定将桶中的元素进行清0，也就是bucketElementCounts[j]==0
            bucketElementCounts[j]=0;
        }
        System.out.println("第一轮排序："+Arrays.toString(arr));

        //第二轮：取出十位
        for (int i = 0; i < arr.length; i++) {
            //取出元素的个数进行统计
            int digitOfElement = arr[i]/10 % 10;
            //放入到对应的桶中即可
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标一次取出数据，放进原来的数组)
        index = 0;
        //遍历每个桶，并将桶中的数据
        for (int j = 0; j < bucketElementCounts.length; j++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCounts[j] != 0) {//如果桶中有元素，就放入到原来的数组
                //如果有数组，就循环第j个桶，放入即可
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    //取出的元素放进arr原数组中
                    arr[index++] = bucket[j][k];//先用再加
                }
            }
            //将桶中的元素进行清0处理
            bucketElementCounts[j]=0;
        }
        System.out.println("第二轮排序："+Arrays.toString(arr));

        //第三轮：对百位进行处理：
        for (int i = 0; i < arr.length; i++) {
            //取出元素的个数进行统计
            int digitOfElement = arr[i]/10/10 % 10;
            //放入到对应的桶中即可
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标一次取出数据，放进原来的数组)
        index = 0;
        //遍历每个桶，并将桶中的数据
        for (int j = 0; j < bucketElementCounts.length; j++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCounts[j] != 0) {//如果桶中有元素，就放入到原来的数组
                //如果有数组，就循环第j个桶，放入即可
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    //取出的元素放进arr原数组中
                    arr[index++] = bucket[j][k];//先用再加
                }
            }

        }
        System.out.println("第三轮排序："+Arrays.toString(arr));
        */
