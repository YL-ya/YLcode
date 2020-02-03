package homework;

import java.util.Arrays;

public class Day10 {
    /*
    * 题目1：给定一个按照升序排列的整数数组 nums，和一个目标值 target。
    * 找出给定目标值在数组中的开始位置和结束位置。*/
    public static void main(String[] args) {
        int[]nums={2,2};
        System.out.println(Arrays.toString(searchRange(nums,2)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[]a=new int[2];
        boolean j=judge(nums,target);
        if(j==false){
            a[0]=-1;
            a[1]=-1;
            return a;
        }else {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                if(nums[left]==target&&nums[right]==target){
                    a[0]=left;
                    a[1]=right;
                    return a;
                }else if(nums[left]==target&&nums[right]!=target){
                    a[0]=left;
                    right--;
                    if(nums[right]==target){
                        a[1]=right;
                    }
                }else {
                    left++;
                }
            }
        }
        return a;
    }
    public static boolean judge(int[]b,int target){
        for(int i=0;i<b.length;i++){
            if(b[i]==target){
                return true;
            }
        }
        return false;
    }
}
