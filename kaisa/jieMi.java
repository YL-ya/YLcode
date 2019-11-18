package kaisa;
import java.util.Scanner;
public class jieMi {
    public static void main(String[] args) {
        System.out.println("请输入密文:");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println("请输入密钥：");
        Scanner sc1=new Scanner(System.in);
        int key=sc1.nextInt();
        Decrypt(s,key);//调用Encryption方法
    }

    public static void Decrypt(String str, int n) {
        // TODO Auto-generated method stub
        //解密
        int k=Integer.parseInt("-"+n);
        String string="";
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if(c>='a'&&c<='z')//如果字符串中的某个字符是小写字母
            {
                c+=k%26;//移动key%26位
                if(c<'a')
                    c+=26;//向左超界
                if(c>'z')
                    c-=26;//向右超界
            }else if(c>='A'&&c<='Z')//如果字符串中的某个字符是大写字母
            {
                c+=k%26;//移动key%26位
                if(c<'A')
                    c+=26;//向左超界
                if(c>'Z')
                    c-=26;//向右超界
            }
            string +=c;//将解密后的字符连成字符串
        }
        System.out.println("解密后为："+string);
    }

}
