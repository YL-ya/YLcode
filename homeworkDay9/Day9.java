package homework;
import java.util.Arrays;
public class Day9 {
    /*
     * 题目1：给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。*/
    public static void main1(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(a, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        int count = 0;
        //跳出双层循环可以用标记
        labe:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                a[0] = i;
                if (nums[i] + nums[j] == target) {
                    count = j;
                    break labe;
                }
            }
        }
        a[1] = count;
        return a;
    }

    /*
     * 题目2：给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。*/
    //自己写的：有局限性
    public static void main(String[] args) {
        String a = "1110110101";
        String b = "1110111011";
        System.out.println(addBinary1(a, b));
    }

    public static String addBinary(String a, String b) {
        //1：将字符串转成数字
        long c = rang(Integer.parseInt(a));
        long d = rang(Integer.parseInt(b));
        //2：算出两数的和
        long e = c + d;
        if (e == 0) {
            return e + "";
        }
        //3：将十进制转成二进制
        String f = String.copyValueOf(change(e));
        return f;
    }

    public static int rang(long c) {
        double sum = 0;
        double count = 0;
        while (c != 0) {
            sum += (c % 10) * Math.pow(2, count);
            c /= 10;
            count++;
        }
        return (int) sum;
    }

    public static char[] change(long a) {
        int cur = 0;
        long c = a;
        while (c != 0) {
            cur++;
            c = c / 2;
        }
        char[] b = new char[cur];
        int count = 0;
        while (a != 0) {
            b[count] = ((a % 2) + "").charAt(0);
            a = a / 2;
            count++;
        }
        /*char[]c=Arrays.copyOf(b,count);*/
        int left = 0;
        int right = b.length - 1;
        while (left < right) {
            char temp = b[left];
            b[left] = b[right];
            b[right] = temp;
            left++;
            right--;
        }
        return b;
    }

    //博客上面写的：
    public static String addBinary1(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        StringBuffer sb = new StringBuffer();
        int c = 0;
        for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            int num = c;
            /*num+=((a.charAt(i)-'0')+(b.charAt(j)-'0'));*/
        //1：将字符串字符从后往前相加
            num += (i >= 0 ? a.charAt(i) - '0' : 0);
            num += (j >= 0 ? b.charAt(j) - '0' : 0);
            //判断j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值
            sb.append(num % 2);//连接一个字符串到字符串的末尾
            c = num / 2;
        }
        //2：出了循环之后商为1直接在字符串sb直接添加上即可，因为如果是0没必要在算了
        if (c == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}

