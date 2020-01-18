package homework;

public class Day1 {
    /*
     * 题目1：实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
     * 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。*/
    class Solution {
        public String toLowerCase(String str) {
            //1:先将字符串转成字符数组：在这个期间将大写的字母转换成小写的字母
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= 'A' && array[i] <= 'Z') {
                    array[i] += 32;
                }
            }
            //2:将字符数组转化成字符串
            String str1 = "";
            for (int j = 0; j < array.length; j++) {
                str1 += array[j];
            }
            return str1;
        }
    }

    /*
     * 题目2：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。*/
    public void rotate(int[] nums, int k) {
        int a = nums.length;
        while (k > 0) {//外层是要移动的k次
            int c = nums[a - 1];
            for (int i = a - 1; i > 0; i--) {//内层是用来依次移动的
                nums[i] = nums[i - 1];
            }
            nums[0] = c;
            k--;
        }
    }
}

