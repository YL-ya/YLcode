package homework;
import java.util.Arrays;
public class Day5 {
    /*
    * 题目1：*/
    public static void main(String[] args) {
        int []num={3,1};
        System.out.println(containsDuplicate(num));
    }
    public static boolean containsDuplicate(int[] nums){
        /*int[]a= Arrays.copyOf(nums,nums.length);*/
        /*for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }*/

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
