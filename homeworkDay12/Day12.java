package homework;

public class Day12 {
    public static void main(String[] args) {
        int[]nums={2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++) {
            if (max > nums[i]) {
                r = i;
            } else {
                max = nums[i];
            }
        }
        for(int i=0;i<len;i++){
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }
}
