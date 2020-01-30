package homework;

import java.util.Arrays;

public class Day7 {
    /*
    * 题目1：给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。*/
    public static void main1(String[] args) {
        int[]A={4,1,3,6,8};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }
    public static int[] sortArrayByParity(int[] A) {
        int[]a=new int[A.length];
        int count=0;
        int cur=A.length-1;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                a[count]=A[i];
                count++;
            }else{
                a[cur]=A[i];
                cur--;
            }
        }
        return a;
    }

    /*
    * 题目2：给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。*/
    public static void main(String[] args) {
        /*int[]a={-1,-1,-1,-1,-1,-1};*/
        /*int[]a={-1,-1,-1,0,1,1};*/
        /*int[]a={1,7,3,6,5,6};*/
        /*int[]a={-1,-1,-1,-1,-1,0};*/
        int[]a={-1,-1,0,1,1,0};

        System.out.println(pivotIndex(a));
    }
    public static int pivotIndex(int[] nums) {
        //1：对数组进行遍历，并挨个进行比较
        for (int i = 0; i < nums.length; i++) {
            int k = judge(nums, i);
            if (k == 1) {
                /*if(nums[i]==-1){
                    return -1;
                }*/
                return i;
            } else if(k==0){
                return 0;
            }else {
                continue;
            }
        }
        return -1;
    }
    public static int judge(int[]num,int a){
        int sum=0;
        int cur=0;
        for(int j=0;j<a;j++){
            sum+=num[j];
        }
        for (int i = a+1; i <num.length ; i++) {
            cur+=num[i];
        }
        /*if(0==cur){
            return 0;
        }*/
        if(sum==cur){
            return 1;
        }
        return -1;
    }
}
