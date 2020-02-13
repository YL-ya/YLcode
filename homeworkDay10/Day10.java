package homework;

import java.util.Arrays;

public class Day10 {
    /*
     * 题目1：给定一个按照升序排列的整数数组 nums，和一个目标值 target。
     * 找出给定目标值在数组中的开始位置和结束位置。*/
    public static void main1(String[] args) {
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] a = new int[2];
        boolean j = judge(nums, target);
        if (j == false) {
            a[0] = -1;
            a[1] = -1;
            return a;
        } else {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                if (nums[left] == target && nums[right] == target) {
                    a[0] = left;
                    a[1] = right;
                    return a;
                } else if (nums[left] == target && nums[right] != target) {
                    a[0] = left;
                    right--;
                    if (nums[right] == target) {
                        a[1] = right;
                    }
                } else {
                    left++;
                }
            }
        }
        return a;
    }

    public static boolean judge(int[] b, int target) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] == target) {
                return true;
            }
        }
        return false;
    }

    /*
     * 题目2：将字符串转成整数：正负之分*/
    public static void main(String[] args) {
        String str = "4193 with";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
    //1：将字符串转化成字符数组
    char[] a = str.toCharArray();
    int num = 0;
    //2：进行匹配
    labe:for (int i = 0; i < a.length; i++) {
        //3：如果遇到的是空格，直接掏出当前循环
        if (a[i] == ' ') {
            continue;
        }
        if (a[i] == '-') {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > '9' || a[j] < '0') {
                    return 0;//不能进行有效转化的时候直接返回0即可
                } else {
                    num = num * 10 + a[j] - '0';
                }
            }
            return -num;
        } else if (a[i] == '+') {
            for (int k = i + 1; k < a.length; k++) {
                if (a[k] > '9' || a[k] < '0') {
                    return 0;
                } else {
                    num = num * 10 + a[k] - '0';
                }
            }
            return num;
        } else {
            for (int h = 0; i < a.length; h++) {
                if (a[h] > '9' || a[h] < '0'||a[h]==' ') {
                    break labe;
                } else {
                    num = num * 10 + a[h] - '0';
                }
            }
        }
    }
    return num;
}
}
        /*if(a[0]=='-'){
            for (int i = 1; i <a.length ; i++) {
                if(a[i]>'9'||a[i]<'0'){
                    return 0;//不能进行有效转化的时候直接返回0即可
                }else {
                    num=num*10+a[i]-'0';
                }
            }
            return -num;
        }else if(a[0]=='+'){
            for (int i = 1; i <a.length ; i++) {
                if(a[i]>'9'||a[i]<'0'){
                    return 0;
                }else {
                    num=num*10+a[i]-'0';
                }
            }
            return num;
        }else {
            for (int i = 0; i <a.length ; i++) {
                if(a[i]>'9'||a[i]<'0'){
                    return 0;
                }else {
                    num=num*10+a[i]-'0';
                }
            }
        }
        return num;
    }*/
