package homework;

public class Day11 {
    /*
    * 题目1：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。*/
    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        //1：将字符串转成字符数组
        char[]a=s.toCharArray();
        int i=0;
        int j=a.length-1;
        //2：进行循环判断
        while(i<j){
            //Character.isLetterOrDigit：判断是数字还是字母
            if(!Character.isLetterOrDigit(a[i]))
                i++;
            else if(!Character.isLetterOrDigit(a[j]))
                j--;
            else if(Character.toLowerCase(a[i]) == Character.toLowerCase(a[j])){
                //Character.toLowerCase：字母的小写化
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    /*
    * 题目2：*/
    public static void main1(String[] args) {
        char []chars={'a','a','b','b','b','c','c'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }else {
            int temp=0;
            int cur=1;
            char a='0';
            while(cur!=chars.length){
                if(chars[cur]==chars[temp]){
                    cur++;
                    continue;
                }
            }
        }
        return 1;
    }
}
