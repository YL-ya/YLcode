package com.arithmetic.sort;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*归并排序的原理：
* 1：直接从数组的中间进行划分
* 2：然后进行归的部分
* 3：然后进行拷贝*/
//归并排序的时间复杂度：O(Nlog2N)
//空间内复杂度：O(log2N+N)==O(log2N):N一般是常量，在长须编译的过程中已经定义好了，所以Nlog2N就是log2N
//归并排序：用的思想是分而治之：属于外部排序
/*1·归并排序的时间复杂度是很低的：因为他的复杂度只是数量减一即可
 * 2·归并排序需要额外的空间开销*/
public class MergeSort {
    public static void main(String[] args) {
        int[]arr={8,4,5,7,1,3,6,2};
        System.out.println("排序之前的数组："+Arrays.toString(arr));
        //int[]temp=new int[arr.length];
        //mergeSort(arr,0,arr.length-1,temp);
        mergeSortNor(arr);
        System.out.println("排序之后的数组："+Arrays.toString(arr));
        //测试归并排序的事后时间复杂度：随机产生80000个数
       /* int[] arr = new int[80000];
        int[]temp=new int[arr.length];
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
        mergeSort(arr,0,arr.length-1,temp);

        Date date2=new Date();
        String data2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+data2);*/
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

    //优化：没必要一直进行分，直到那个还有16个时候，进行快排
    private static void mergeSort1(int[]array,int left,int right,int[]temp) {
        if (right - left > 16) {
            //insertSort(array, left, right);
        }else {
            int mid = left + ((right - left) >> 1);
            //左半部分:[left,mid)
            mergeSort1(array, left, mid, temp);

            //右半部分：[mid,right)
            mergeSort1(array, mid, right, temp);

            //上面是进行分的部分下面进行归的部分：
            mergeData(array, left, mid, right, temp);

            //归并结束后，有序的数列在temp中
            //将temp中的数据拷贝到array数组中去
            //Arrays.copyOf();//这个的底层就是用的System.arraycopy();并且在底层自己申请了空间
            System.arraycopy(temp,left,array,left,right-left);//是Native方法；并且是浅拷贝
        }
    }

    //合并数组称为有序的：[left,mid),[mid,right)
    private static void mergeData(int[] array,int left,int mid,int right,int[] temp){
        int index=left;
        int begin1=left,end1=mid;
        int begin2=mid,end2=right;
        while (begin1<end1&&begin2<end2){
            if(array[begin1]<=array[begin2]){//当时两个数相等的时候，我们先搬1区间中的数字，所以该算法稳定
                temp[index++]=array[begin1++];
            }else {
                temp[index++]=array[begin2++];
            }
        }

        //退出循环的话，就是要摸区间1走完了，直接将剩余的区间2中的数字进行搬动即可
        while (begin1<end1){
            //1：这样说明的是区间1中还有数据，直接搬动即可
            temp[index++]=array[begin1++];
        }

        while (begin2<end2){
            //2：也就说区间2中海油数据，直接搬动即可
            temp[index++]=array[begin2++];
        }
    }

    //循环的归并：
    public static void mergeSortNor(int[]array){
        int[]temp=new int[array.length];
        int gap=1;
        while (gap<array.length){
            for (int i = 0; i <array.length ; i+=gap*2) {
                int left=i;
                int mid=left+gap;
                int right=mid+gap;
                //保证mid和right不会越界
                if(mid>array.length){
                     mid=array.length;
                }
                if(right>array.length){
                    right=array.length;
                }
                mergeData(array,left,mid,right,temp);
            }

            System.arraycopy(temp,0,array,0,array.length);
            //gap*=2;
            //gap=gap<<1;
            gap<<=1;
        }


    }

    //封装：
    public static void mergeSort1(int[]array){
        int[]temp=new int[array.length];
        mergeSort1(array,0, array.length,temp);
    }
}
