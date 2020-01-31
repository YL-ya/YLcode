package homework;

import java.util.Arrays;

public class Day8 {
    /*
    * 题目1：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。*/
    public static void main1(String[] args) {
        int[] a = {9};
        System.out.println(Arrays.toString(plusOne(a)));
    }

    public static int[] plusOne(int[] digits) {
        int i=digits.length-1;
        digits[i]++;
        if(digits[i]>9){//此处产生进位
            while(i>0&&digits[i]>9){
                digits[i]=0;
                digits[--i]++;
            }
            //2：第一位大于9的时候要进行扩容
            if(i==0&&digits[i]>9){
                digits=new int[digits.length+1];
                digits[0]=1;
            }
            return digits;
        }
        return digits;
    }


    /*
    * 题目2：给定一个非空数组，返回此数组中第三大的数。
    * 如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。*/
    public static void main(String[] args) {
        int[]a={1,2,3,6};
        System.out.println(thirdMax(a));
    }
    public static int thirdMax(int[] nums) {
        //1：先给数组进行排序：
        Arrays.sort(nums);
        //2：判断数组中有多少不重复的数字
        int j=judge(nums);
        System.out.println(j);
        //3：如果有两个不同的数字的话，直接返回的是最大的，也就是数组的最后一个
        if(j==2){
            return nums[nums.length-1];
        }
        //4：如果是大于或者等于3的返回的是第三大的数字
        int count=0;
        int max=nums[nums.length-1];
        for (int i = nums.length-2; i >=0 ; i--) {
            if(max>nums[i]){
                max=nums[i];
                count++;
                if(count==2){
                    break;
                }
            }else{
                continue;
            }
        }
        return max;
    }
    public static int judge(int[]a){
        int count=1;
        int max=a[0];
        for (int i= 1;i<a.length;i++) {
            if(a[i]!=max){
                max=a[i];
                count++;
            }else{
                continue;
            }
        }
        return count;
    }
}