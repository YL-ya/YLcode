package homework;

public class Day2 {
    /*
     * 题目1：给定一个数组 nums 和一个值 val，
     * 你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。*/
    class Solution {
        public int removeElement(int[] nums, int val) {
//思路：因为不能使用额外数组空间，所以只能进行覆盖
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }
    /*
     * 题目2：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。*/
    public int searchInsert(int[] nums, int target) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                temp = i;
                break;
            } else if (nums[0] > target) {
                temp = 0;
                break;
            } else if (nums[nums.length - 1] < target) {
                temp = nums.length;
                break;
            } else if ((nums[i] < target) && (nums[i + 1] >= target)) {
                temp = i + 1;
                break;
            }
        }
        return temp;
    }
}
