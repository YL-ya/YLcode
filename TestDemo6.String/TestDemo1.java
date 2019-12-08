package string;

import java.util.Scanner;
public class TestDemo1 {
    //1·将输入的一个字符串以空格分割开来
    public static String fuc(String str){
        String[] strs=str.split(" ");
        String ret="";
        for (String s:strs){
            ret+=s;
        }
        return ret;
    }
    public static void main1(String[] args){
        Scanner input=new Scanner(System.in);
        String  str =input.nextLine();//abc def
        String ret=fuc(str);
        System.out.println(ret);
    }

    public static String reverse(String str,int left,int right) {
        char[] value = str.toCharArray();
        while (left < right) {
            char tmp = value[left];
            value[left] = value[right];
            value[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(value);
    }

    public static String func(String str,int k) {
        if(str == null || k <= 0) {
            return null;
        }
        str = reverse(str,0,k-1);//
        str = reverse(str,k,str.length()-1);
        str = reverse(str,0,str.length()-1);
        return str;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();//当有nextInt时，下面不能用nextLine,只能用next;
        int k = scan.nextInt();
        String ret = func(str,k);
        System.out.println(ret);
    }
}
