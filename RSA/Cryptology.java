import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description RSA加密解密算法
 *
 */

public class Cryptology {
    private final int p = 47;
    private final int q = 61;
    private final int e = 1223;//公钥

    //快速取模指数算法
    public int mod(int a,int m,int n){
        int c=0 , res=1;
        String s=Integer.toBinaryString(m);
        char[] b= s.toCharArray();
        for(int j = 0;j<s.length();j++){
            c=2*c;
            res=(res*res)%n;
            if(b[j]=='1'){
                c++;
                res=(res*a)%n;
            }
        }

        return res;
    }


    public int euclideanAlgo(int a,int n){//拓展的欧几里德算法，用来求私钥
        int X1=1,X2=0,X3=n;
        int Y1=0,Y2=1,Y3=a;
        int Q;
        while(true){
            if(Y3==0){
                System.out.println("无逆元");
                break;
            }
            if(Y3==1){
                return Y2;
            }
            Q=X3/Y3;
            int T1=X1-Q*Y1;
            int T2=X2-Q*Y2;
            int T3=X3-Q*Y3;
            X1=Y1;
            X2=Y2;
            X3=Y3;
            Y1=T1;
            Y2=T2;
            Y3=T3;
        }
        return 0;
    }

    //将明文转换成对应的十进制数放进哈希表中
    public HashMap<Character, Integer> change(){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0;i<26;i++){
            hashMap.put((char)('a'+i), 1+i);
        }
        hashMap.put(' ', 0);
        return hashMap;
    }

    //将明文转换成十进制数
    public String getRSAClearText(String in){
        HashMap<Character, Integer> hashMap = change();//获取哈希表
        char[] clearText = in.toLowerCase().toCharArray();
        StringBuilder result = new StringBuilder();//接收转换结果
        for(int i=0;i<clearText.length;i++){
            int value = hashMap.get(clearText[i]);
            if(value>=0&&value<=9){//如果value是个位数在前面补0,
                result.append("0").append(value);
            }else{
                result.append(value);
            }
        }
        if(result.length()%4!=0){//保证每组有4个字符
            result.append("00");
        }
        return result.toString();
    }

    /**
     * RSA加密算法
     */
    public void rsaEncryption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入明文：");
        String input = getRSAClearText(sc.nextLine());//从控制台输入明文，并且将明文转换成十进制数
        input = input.replaceAll("(.{4})", "$1 ");//每四个字符添加一个空格
        System.out.println("明文的十进制数表示："+input);
//		String[] inputGroup = new String[input.length()/4];//将明文两个字符作为一组进行分组
//		for(int i=0;i<input.length();i=i+4){ //
//			inputGroup[i/4] = input.substring(i, i+4);
//		}
        String[] inputGroup = input.split(" ");//将明文两个字符作为一组进行分组
        StringBuilder encryReasult = new StringBuilder();//存放加密结果
        int n =p*q;
        for(int i=0;i<inputGroup.length;i++){
            int M = Integer.parseInt(inputGroup[i]);
            int C = mod(M, e, n);
            int len = String.valueOf(C).length();
            while(len<4){
                encryReasult.append("0");
                len++;
            }
            encryReasult.append(C);
        }
        String dencryReasult = encryReasult.toString().replaceAll("(.{4})", "$1 ");
        System.out.println("密文："+dencryReasult);
        System.out.println("-----------------------------------------------------------");
    }

    /**
     * RSA解密算法
     */
    public void rsaDecryption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密文：(不要加空格)");
        String input = sc.nextLine();
        input = input.replaceAll("(.{4})", "$1 ");
        System.out.println("输入的密文为："+input);
        int  n =p*q , s = (p-1)*(q-1);
        int d = euclideanAlgo(e, s); //求私钥
        System.out.println("私钥："+d);
        String[] inputGroup = input.split(" ");
        StringBuilder dencryReasult = new StringBuilder();//存放解密结果
        for(int i=0;i<inputGroup.length;i++){
            int C = Integer.parseInt(inputGroup[i]);
            int M = mod(C,d,n);
            int len = String.valueOf(M).length();
            while(len<4){
                dencryReasult.append("0");
                len++;
            }
            dencryReasult.append(M);
        }
        String encryReasult = dencryReasult.toString().replaceAll("(.{4})", "$1 ");
        System.out.println("明文的十进制数表示："+encryReasult);
        //将明文还原成字符
        HashMap<Character, Integer> hashMap = change();
        String[] encryReasultGroup = encryReasult.split(" ");// 将明文结果进行分块
        StringBuilder result = new StringBuilder();
        for(String group : encryReasultGroup){
            String[] str = group.replaceAll("(.{2})", "$1 ").split(" ");
            for(int i=0;i<str.length;i++){
                int value = Integer.parseInt(str[i]);
                Set<Entry<Character, Integer>> set =hashMap.entrySet();
                Iterator<Entry<Character, Integer>> iterator = set.iterator();
                while(iterator.hasNext()){
                    Entry<Character,Integer> entry = iterator.next();
                    if(entry.getValue()==value){
                        char key = entry.getKey();
                        result.append(key);
                        break;
                    }
                }
            }
        }
        System.out.println("明文："+result.toString().toUpperCase());
        System.out.println("-----------------------------------------------------------");
        sc.close();
    }

}