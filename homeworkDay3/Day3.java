package homework;
public class Day3 {
    /*
     * 题目1：给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
     * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
     * 如果可以构成，返回 true ；否则返回 false。*/
    /*自己写的：立扣上执行通不过*/
   /* public static void main1(String[] args) {
        String ransomNote = "aab";
        String magazine = "aaaa";
        boolean a = canConstruct(ransomNote, magazine);
        System.out.println(a);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        //1:首先magazine的长度必须大于ransomNote的长度，因为是包含
        char[] a = magazine.toCharArray();
        if (a.length < ransomNote.length()) {
            return false;
        }
        //2：进行匹配
        for (int i = 0; i < ransomNote.length(); i++) {
            int b = jude(a, ransomNote.charAt(i));
            if (b == -1) {
                return false;
            } else {
                a[i] = '0';//避免重复的字母
            }
        }
        return true;
    }
    public static int jude(char[] a, char c) {
        for (int i = 0; i < a.length; i++) {
            //依次进行匹配
            if (c == a[i]) {
                return i;
            }
        }
        //如果循环结束都没有找到匹配的，就返回-1；
        return -1;
    }*/


    /*博客上写的：*/
    public static void main1(String[] args) {
        String ransomNote = "aab";
        String magazine = "aaac";
        boolean a = canConstruct(ransomNote, magazine);
        System.out.println(a);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        //首先 ransomNote的长度肯定要小于 magazine的长度。
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        //
        for (int i = 0; i < ransomNote.length(); i++) {
            //判断师傅有相同字符
            int j = judge(chars, ransomNote.charAt(i));
            if (j != -1) {
                //每出现一次相同字符将magazine中的字符变成 '0'，
                //这样就不怕几个字符对应magazine中一个字符
                chars[j] = '0';
            } else {
                return false;
            }
        }
        return true;
    }

    public static int judge(char[] chars, char a) {
        //判断magazine里面的是否有这个字符
        for (int i = 0; i < chars.length; i++) {
            if (a == chars[i]) {
                return i;
            }
        }
        return -1;
    }


    /*
     * 题目2：判断一个整数是否是回文数。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。*/
//方法1：:
    public static void main(String[] args) {
        int a = 121;
        System.out.println(isPalindrome(a));
    }
    public static boolean isPalindrome(int x) {
        //第一步：进行<0和>0判断
        if (x < 0) {
            return false;
        }
        //第二步：将整数存入数组
        int count = 0;
        int a = x;
        while (a != 0) {
            a = a / 10;
            count++;
        }
        int[] b = new int[count];
        for (int i = 0; i < count; i++) {
            if (x != 0) {
                b[i] = (x % 10);
                x = x / 10;
            }
        }
        //第三步：进行匹配
        int left = 0;
        int right = b.length - 1;//1
        //121
        while (left < right) {
            if (b[left] == b[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

//方法2：
/*
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String a=x+"";
        int b=a.length();
        char[]c=new char[b];
        for(int i=0;i<b;i++){
            c[i]=a.charAt(i);
        }
        int left=0;
        int right=b-1;
        while(left<right){
            if(c[left]==c[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}*/

