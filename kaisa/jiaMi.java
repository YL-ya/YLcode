package kaisa;
import java.util.Scanner;
public class jiaMi {
    public static void main(String[] args) {
        System.out.println("请输入明文：");
        Scanner zx=new Scanner(System.in);//创建Scanner对象
        String z=zx.nextLine();
        System.out.println("请输入密钥:");
        Scanner zx1=new Scanner(System.in);
        int key=zx1.nextInt();//将下一输入项转换成int类型
        Encryption(z,key);//调用Encryption方法
    }

    public static void Encryption(String str, int k) {
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
            }
            if(c>='A'&&c<='Z')//如果字符串中的某个字符是大写字母
            {
                c+=k%26;//移动key%26位
                if(c<'a')
                    c+=26;//向左超界
                if(c>'z')
                    c-=26;//向右超界
            }
            string +=c;//将解密后的字符连成字符串
        }
        System.out.println("加密后为："+string);
    }

}
