package homework;

import java.util.Arrays;

public class Day6 {
    /*
     * 题目1：给定一个按非递减顺序排序的整数数组 A，
     * 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。*/
    public static void main1(String[] args) {
        int[] a = {1, -3, 5, 7};
        System.out.println(Arrays.toString(sortedSquares(a)));
    }

    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /*
     * 题目2：给定一个字符串 S，
     * 返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转*/
    public static void main(String[] args) {
        String str = "dc-ab";
        System.out.println(reverseOnlyLetters(str));
    }

    public static String reverseOnlyLetters(String S) {
        if(S==null){
            return S;
        }
        //1：取得所有的字母，组成一个字母字符串
        StringBuffer str=new StringBuffer("");
        for (int i = 0; i <S.length() ; i++) {
            char val = S.charAt(i);
            if ((val > 'a' && val < 'z') || (val > 'A' && val < 'Z')) {
                str.append(val);//将从字符串中取出的每个字母字符串在一起成为一个字符串
            }
        }
        //2：反转所所有的字母字符：
        str.reverse();//该方法是将字符串进行反转的
        StringBuffer s1=new StringBuffer(S);
        //3：将反转后的字代替掉原来的字母
        int count=0;
        for (int i = 0; i <s1.length() ; i++) {
            char val = s1.charAt(i);
            if ((val > 'a' && val < 'z') || (val > 'A' && val < 'Z')) {
                String value = "" + str.charAt(count);//将字符转化成字符串
                s1.replace(i, i + 1, value);
                count++;
            }
        }
        return s1.toString();
    }
}
    //自己写的有缺陷：
    /*public String reverseOnlyLetters1(String S) {
        char[] a = S.toCharArray();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if ((a[left] > 'a' && a[left] < 'z') || (a[left] > 'A' && a[left] < 'Z')) {
                char temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
            } else if ((a[right] > 'a' && a[right] < 'z') || (a[right] > 'A' && a[right] < 'Z')) {
                char temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                right--;
            } else if ((a[right] > 'a' && a[right] < 'z' && a[left] > 'a' && a[left] < 'z') || (a[right] > 'A' && a[right] < 'Z' && (a[left] > 'A' && a[left] < 'Z'))) {
                char temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            } else {

                continue;
            }
        }
        return new String(a);
    }
}*/