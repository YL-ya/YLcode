package homework;
import java.util.Arrays;
public class Day5 {
    /*
    * 题目1：给定一个整数数组，判断是否存在重复元素。
      如果任何值在数组中出现至少两次，函数返回 true。
      如果数组中每个元素都不相同，则返回 false。*/
    public static void main1(String[] args) {
        int[] num = {3, 1};
        System.out.println(containsDuplicate(num));
    }

    public static boolean containsDuplicate(int[] nums) {
        /*int[]a= Arrays.copyOf(nums,nums.length);*/
        /*for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }*/

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * 题目2：你的朋友正在使用键盘输入他的名字 name。
    * 偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
      你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），
      那么就返回 True。*/
    public static void main(String[] args) {
        String name="asxc";
        String typed="asssxc";
        System.out.println(isLongPressedName(name,typed));
    }


    public static boolean isLongPressedName(String name, String typed) {
        //1：将其中一个转成数组
        char[] a = typed.toCharArray();
        //2：进行循环匹配，如果匹配到了直接将数组中那个变成0即可
        for (int i = 0; i < name.length(); i++) {
            int j = judge(a, name.charAt(i));
            //3：如果在数组中找到的话，将其返回即可
            if (j != -1) {
                a[j] = '0';
            } else {
                return false;
            }
        }
        return true;
    }

    public static int judge(char[] a, char b) {
        for (int i = 0; i < a.length; i++) {
            if (b == a[i]) {
                return i;
            }
        }
        return -1;
    }
}
