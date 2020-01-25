package homework;
import java.util.Arrays;
public class Day5 {
    /*
    * 题目1：给定一个整数数组，判断是否存在重复元素。如果任何值在数组中重复出现至少两次，函数返回true。
      如果数组中，每个元素都不同，则返回false。*/
    public static void main(String[] args) {
        int []num={3,1};
        System.out.println(containsDuplicate(num));
    }
    public static boolean containsDuplicate(int[] nums){
        /*int[]a= Arrays.copyOf(nums,nums.length);*/
        /*for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }*/
//1：利用两个循环进行判断即可，因为要判断出自身以外的，所以要将本身的那个除外
        for (int i = 0; i <nums.length ; i++) {
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
