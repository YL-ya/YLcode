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
        //思路：定义两个指针，一个从前面开始，一个从数组的后面开始即可
        int[]a=new int[2];
       //1：写一个方法判断数组中是否含有target这个值
        boolean j=judge(nums,target);
       //2：判断是否含有，如果不含有直接将子案件的数组全部置为-1；然后返回。
        if(j==false){
            a[0]=-1;
            a[1]=-1;
            return a;
        }else {
       //3：如果含有，则定义两个指针即可
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
