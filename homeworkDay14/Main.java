import org.junit.Test;
import sun.swing.PrintColorUIResource;

import java.math.*;
import java.util.*;
abstract class Aniaml{
    abstract void say();
}
/*给了单词的数组，输出：出现次数最多的前K个单词，如果次数相同，按照字母次序进行排序：TOP-K问题
* TOP-K问题，一定会用到堆--优先级队列
* 思路：
* 1：统计单词出现的次数<单词，次数>
* 2：创建一个堆(也就是创建一个优先级队列)，然后将单词-次数：默认情况下是小堆
* 3：取出前K个单词
* 总结：前K个最大的，进行创建小堆的优先级队列：这样留下来的优先级队列中就是最大的元素
*       前k个最小的，进行创建大堆的优先级队列：这样留下来的是优先级队列最小的元素*/
class Cmp implements Comparator<Map.Entry<String,Integer>>{

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if(o2.getValue() > o1.getValue()){
            return 1;
        }

        if(o2.getValue() == o1.getValue() && o1.getKey().compareTo(o2.getKey()) > 0){
            return 1;
        }

        if(o2.getValue() == o1.getValue() && o1.getKey().compareTo(o2.getKey()) == 0){
            return 0;
        }

        return -1;
    }
}

public class Main{
    public static void main(String[] args) {
        String[] a=new String[]{};

    }
    public static List<String> topK(String[] words,int k){
        //1：统计每个单词出现的次数
        Map<String,Integer> m=new HashMap<>();
        for (int i = 0; i <words.length ; i++) {
            m.put(words[i],m.getOrDefault(words[i],0)+1);
        }

        //2：创建优先级队列：
        PriorityQueue<Map.Entry<String ,Integer>> p=new PriorityQueue<>(new Cmp());
        for (Map.Entry<String,Integer> e:m.entrySet()) {
            p.offer(e);
        }

        List<String> l=new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            l.add(p.poll().getKey());
        }
        return l;
    }
}
//坏键盘：用Set可以了
/*public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            //1：循环接收用户的输入
            String right=sc.nextLine().toUpperCase();
            String wrong=sc.nextLine().toUpperCase();

            //2：将wrong的每个字符放在Set中
            //将正常的键保存在Set中
            Set<Character> s=new HashSet<>();//因为不用有序
            for(int i=0;i<wrong.length();i++){
                s.add(wrong.charAt(i));
            }

            //3：检测right中每个字符是否Set是否出现过
            //本想着Set去重，但是HashSet底层是哈希表，当你输入12345，宾烈结果不一定是12345，所以不能用遍历进行打印
            Set<Character> b=new HashSet<>();
            for (int i = 0; i <right.length() ; i++) {
                char ch=right.charAt(i);

                //检测是否是坏键
                if(!s.contains(ch)){
                    if( b.add(ch)){
                        //如果插入成功就说明，这个是坏键，直接将其顺手就输出了
                        System.out.println(ch);
                    }
                }
            }

           *//* //进行遍历
            for (Character ch:b) {
                System.out.print(ch);
            }*//*
            System.out.println();
        }
    }
}*/
//28：验证尼科彻斯定理：
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            int N = sc.nextInt() ;
            String s = decompose(N) ;
            System.out.println(s);
        }
        sc.close();
    }
    private static String decompose(int n) {
        int[] array = new int[n];
        int mid = n / 2;
        if (n * n % 2 == 0)
            array[mid] = n * n + 1;
        else
            array[mid] = n * n;
        for (int i = mid; i >= 1; i--) {
            int temp = array[i];
            array[i - 1] = temp - 2;
        }
        for (int j = mid; j < n - 1; j++) {
            int temp = array[j];
            array[j + 1] = temp + 2;
        }
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < n; k++) {
            if (k != n - 1)
                sb.append(array[k] + "+");
        }
        sb.append(array[n - 1]);
        return sb.toString();
    }
}*/

//26：两个超长整数的加法：
/*public class Main{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String s1=input.next();
            String s2=input.next();
            BigInteger num1=new BigInteger(s1);//采用BigInteger可以直接进行大整数进行计算
            BigInteger num2=new BigInteger(s2);
            System.out.println(num1.add(num2));
        }
    }*/
/*    public static String AddLongInteger(String addend,String augend) {
        ArrayList<Integer> a = new ArrayList<>();
        int sum = 0;
        for (int i = augend.length() - 1; i >= 0; i--) {
            for (int j = addend.length() - 1; j >= 0; j--) {
                int f1 = addend.charAt(i) - 48;
                int f2 = augend.charAt(i) - 48;
                sum = f1 + f2;
                if (sum >= 10) {
                    sum = sum - 10;
                    int temp = addend.charAt(j - 1) - 48;
                    temp += 1;
                    //addend.charAt(j)=temp+48;
                }
                a.add(sum);
            }
        }
    }*/
   /* static boolean ou(char c){
        System.out.println(c);
        return true;
    }
    */
       /* Thread t = new Thread() {
            @Override
            public void run() {
                dianping();
            }
        };
        t.start();
        System.out.println("dangngln");
    }
    static void dianping(){
        System.out.println("dianping");*/
       /* int i=0;
        for(ou('A');ou('B')&&i<2;ou('C')){
            i++;
            ou('D');
        }*/

//打印出来是good and gbc:字符串是在池中的，一旦创建就不会改变
/*class Example {
    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public static void change(String str, char ch[])
    {
        str = "test ok";
        ch[0] = 'g';
    }
}*/

//24：生成格雷码：
/*public class Main{
    public static String[] getGray(int n) {
        // write code here
        String[] res=null;
        if(n==1){
            res=new String[]{"0","1"};
        }else{
            String[]str=getGray(n-1);
            //每多一位，我们的格雷码长度增加1倍
            res=new String[str.length*2];
            for(int i=0;i<str.length;i++){
                //添加0后变成(000,001,011,010)
                res[i]="0"+str[i];
                //  添加1后需要顺序反向就变成(110,111,101,100）
                res[res.length-1-i]="1"+str[i];
            }
        }
        return res;
    }
}*/

//23：不用辅助变量交换两值
/*public class Main{
    public static void main(String[] args) {
        int[]a=new int[]{1,2};
        System.out.println(Arrays.toString(exchangeAB1(a)));
        System.out.println(Arrays.toString(exchangeAB2(a)));
    }
    public static int[] exchangeAB2(int[] AB) {
        AB[0]=AB[0]^AB[1];
        AB[1]=AB[0]^AB[1];
        AB[0]=AB[0]^AB[1];
        return AB;
    }
    public static int[] exchangeAB1(int[] AB) {
        // write code here
        AB[0]=AB[0]+AB[1];
        AB[1]=AB[0]-AB[1];
        AB[0]=AB[0]-AB[1];
        return AB;
    }
}*/

    /*try{

        }catch (java.io.FileNotFoundException ex){
            System.out.println("a");
        }catch (java.io.IOException ex){
            System.out.println("b");
        }catch (java.lang.Exception ex){
            System.out.println("c");
        }*/
        /*String a="hello";
        String b="he"+new String("llo");
        System.out.println(a==b);*/
   /* public abstract class Main{
        public int cos=5;
        public abstract void meth(int a);
    }*/

//22：数组A构建数组B：B[i]=A[0]*A[1]*...A[i-1]*A[i+1]*A[n-1];也就说不包含A[i]即可
/*
public class Solution {
    public int[] multiply(int[] A) {
        if(A==null||A.length==0){
            return A;
        }
        int[]B=new int[A.length];
        for(int i=0;i<B.length;i++){
            int sum=1;
            for(int j=0;j<A.length;j++){
                if(i!=j){
                    sum*=A[j];
                }
            }
            B[i]=sum;
        }
        return B;
    }
}
*/

//21：升序输出一个整数包含（0~9）数字的个数：
/*public class Main{
    public static void main(String[] args){
        int[] count = new int[] {0,0,0,0,0,0,0,0,0,0};
        Scanner sc = new Scanner(System.in);
        BigInteger N;
        N = sc.nextBigInteger();
        Vector<Integer> num = new Vector<>();
        do {
            BigInteger M = N.mod(BigInteger.valueOf(10));
            num.add(M.intValue());
            N = N.divide(BigInteger.valueOf(10));
        } while (N.compareTo(BigInteger.valueOf(0)) > 0);
        for (int i = 0; i < num.size(); ++i) {
            switch (num.get(i)) {
                case 0:
                    ++count[0];
                    break;
                case 1:
                    ++count[1];
                    break;
                case 2:
                    ++count[2];
                    break;
                case 3:
                    ++count[3];
                    break;
                case 4:
                    ++count[4];
                    break;
                case 5:
                    ++count[5];
                    break;
                case 6:
                    ++count[6];
                    break;
                case 7:
                    ++count[7];
                    break;
                case 8:
                    ++count[8];
                    break;
                case 9:
                    ++count[9];
                    break;
                default:
                    break;
            }
        }
        for (int j = 0; j < 10; ++j) {
            if (count[j] != 0)
                System.out.println(j + ":" + count[j]);
        }
    }
}*/
/*public class Main {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.println("ping");
    }
    static void pong(){
        System.out.println("pong");
    }
}*/
//19：最少步数到裴波那契
/*思路：进行循环构造斐波那契数，直到大于咱们输入的数*/
/*public class Main {
    @Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getMinNum(m));
    }
    private static int getMinNum(int m) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(1);
        int n = 2;
        while (list.get(n) <= m) {
            n++;
            list.add(list.get(n - 1) + list.get(n - 2));
        }
        //退出循环是，咱们的菲数已经大于咱们输入的数，济宁前后比较，输出最小的数即可
        if (list.get(n) - m < m - list.get(n - 1)) {
            return list.get(n) - m;
        } else {
            return m - list.get(n - 1);
        }
    }
}*/
//18：阶乘结果末尾是几个0
/*
public class Main {
    public static void main1(String[] args){
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()){
            int a=sc.nextInt();
            int b=Jc(a);
            System.out.println(b);
        }
    }
    public static int Jc(int a){
        if(a<5){
            return 0;//因为小于5阶乘的结果数是没有0的
        }
        long sum=1;//边乘边取0
        //求阶乘：
        int count=0;
        for (int i = 2; i <=a ; i++) {
            sum*=i;

            while (sum>0){
                if(sum%10>0){
                    break;//个位不是0，直接跳出循环
                }
                count++;//个位是0的
                sum/=10;//去挑个位继续检查
            }
        }
        return count;
    }
*/
    //17：翻转字符串

    /*//求阶乘：不能这样，会超出数值的范围
    public static int Jc(int a){
        if(a==1||a==0){
            return 1;
        }
        return a*Jc(a-1);
    }
}*/
   /* *//*public class TestClassi{*//*
    private static void testMethod( ) {
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        ((Main)null).testMethod();
    }*/

   /* public static void main(String[] args) {
        int index = getLastDeletedIndex(8);
        System.out.println("The last index deleted is " + index);*/


/*
        Scanner sc = new Scanner(System.in);
        int[]a=new int[1000];
        int count=0;
        while (sc.hasNext()) {
            for (int i = 0; i <a.length ; i++) {
                a[i]=sc.nextInt();
                count++;
            }
        }
        int[]b=new int[count];
        for (int i = 0; i <b.length ; i++) {
            b[i]=a[i];
        }
*/



/*    public static int getLastDeletedIndex(int len) {
        if (len <= 0) { // 如果数组长度不满足要求则返回 -1
            return -1;
        }

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) { // 初始化每个元素的值为当前下标
            arr[i] = len;
        }

        final int DELFLAG = len + 1; // 删除标志位
        int currentSize = len; // 记录数组当前有效长度（即未被置为删除标志的元素个数），最后变为 0
        final int STEP = 2; // 步长
        int count = 0; // 步长计数
        int lastDelIndex = 0; // 记录最后被删除的元素的下标
        int i = 0; // 循环下标

        while (currentSize != 0) {
            if (arr[i] != DELFLAG) { // 判读当前元素是否等于删除标志
                if (count++ == STEP) { // 当步长计数满足步长则
                    arr[i] = DELFLAG; // 将元素置为删除标志位
                    lastDelIndex = i; // 记录该处下标
                    currentSize--; // 有效数组长度减 1
                    count = 0; // 步长计数归零
                    System.out.println("Deleted index is " + i % len);
                }
            }
            i = (i + 1) % len; // 下标取余实现循环下标
        }
        return lastDelIndex;
    }
}*/
//16：找出n个数中最小的k个
/*public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> a=new ArrayList<>(100);
        while (sc.hasNext("stop")){
            a.add(sc.nextInt());
        }
        int key=a.get(a.size()-1);
        a.remove(a.size()-1);
        peek(a,key);
    }
    public static void peek(ArrayList<Integer> a,int b){
       int[]c=new int[a.size()];
        for (int i = 0; i <a.size() ; i++) {
            c[i]=a.get(i);
        }
        Arrays.sort(c);
        for (int i = 0; i <b ; i++) {
            System.out.print(c[i]+" ");
        }
    }
}*/

//13：放蛋糕：
/*
public class Main{
    public static void main(String[] args) {
        int a=3;
        int b=2;
    }
}
*/

//14：最小公倍数
/*
public class Main{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        jude(a,b);
    }
    public static void jude(int a,int b){
        if(a<=0||b<=0){
            System.out.println("无法计算");
        }else if(a%b==0){
            System.out.println(a);
        }else if(b%a==0){
            System.out.println(b);
        }else{
            int sum=1;
            int chushu=2;//从2开始除
            int min=Math.min(a,b);
            while(chushu<=min){
                if(a%chushu==0&&b%chushu==0){
                    a=a/chushu;
                    b=b/chushu;
                    sum*=chushu;
                }
                if(a%chushu!=0||b%chushu!=0){
                    chushu++;
                }
            }
            //退出循环是a，b两值都为质数的时候
            System.out.println(a*b*sum);
        }
    }
}*/

//9：神奇口袋，总量40，方法多少种
/*
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int kinds = scanner.nextInt();
            int[] arr = new int[kinds];
            for (int i = 0; i < kinds; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(differentkinds(arr, kinds, 40,0));
        }
    }

    public static int differentkinds(int[] arr, int n, int v,int index) {
        if (v == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }else {
            //从后往前装，最后一个开始，装上n个后，体积减少，继续往前
            //装上n个后，如果无解。删除该包。然后从n-1开始继续往前装
            return differentkinds(arr,n-1,v-arr[index],index+1)
                    +differentkinds(arr,n-1,v,index+1);
        }
    }
}*/


//10：利用两个栈实现一个队列：
/*
public class Main {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if(stack2.size()<=0){//保证stack2的栈中是没有元素的情况下
            while(stack1.size()!=0){
                stack2.push(stack1.pop());//循环将栈1中的值，push到栈2中
            }
        }
        return stack2.pop();
    }
}*/

//8：删除第二个字符串中所包含的元素
/*
public class Main {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String a=input.nextLine();
        String b=input.nextLine();
        System.out.println(jude(a,b));
    }

    public static String jude(String a,String b){
        StringBuffer c=new StringBuffer();
        for (int i = 0; i <a.length() ; i++) {
            for (int j = 0; j <b.length() ; j++) {
                if(a.charAt(i)!=b.charAt(j)){
                    continue;
                }else {
                    i++;
                }
            }
            c.append(a.charAt(i));
        }
        return c.toString();
    }
}*/


//7：选6袋和8袋
/*
public class Main {
    public static void main(String[] args) {
        int a=20;
        int s=0;
        int count=0;
        int count1=0;
        int m=0;
        while (a>0) {
            if (a % 8 == 0) {//袋数直接是8的倍数的，直接返回倍数即可
                System.out.println(a / 8);
                return;
            } else {
                s = a % 8;//余数
                count = a / 8;//袋数
                if (s % 6 == 0) {
                    count1 = a / 6;
                } else {//当剩余的袋数不是6的倍数的时候，也就是可能有8
                    while (s % 6 != 0) {
                        m = a - (count - 1) * 8;
                        s = m % 6;
                        count--;
                        if (count < 1) {
                            System.out.println(-1);
                        }
                    }
                    count1 = m / 6;
                }
            }
            System.out.println(count+count1);
            return;
        }
    }
}*/

//6：括号匹配问题：
/*
public class Main {
    public static void main(String[] args) {
        String a="()()()(";
        System.out.println(jude(a));

    }
    public static boolean jude(String a){
        Stack b=new Stack();
        Stack c=new Stack();
        for (int i = 0; i <a.length() ; i++) {
            char d=a.charAt(i);
            if(d=='('){
                b.push(d);
            }else if(d==')'){
                c.push(d);
            }
        }

        while (b.size()>0&&c.size()>0){
            b.pop();
            c.pop();
        }
        if(b.size()>0||c.size()>0){
            return false;
        }
        return true;
    }
}
*/

//5：输入一个字符串，输出字符串中连续最长的数字串
/*思想：
* 1：将数字部分全部放进一个StringBuffer中，不是数字的部分用空格符号
* 2：然后将StringBuffer转成String：String c=b.toString();
* 3：以空格分隔字符串，用字符串数组存起来
* 4：循环遍历字符串数组比较字符串的长度大小*/
/*
public class Main {
    public static void main(String[] args) {
        //Scanner input=new Scanner(System.in);
        //String a=input.nextLine();
        String a="abcd12345ed125ss123456789";
        System.out.println(length(a));
    }

    public static String length(String a){
        StringBuffer b = new StringBuffer();
        for (int i = 0; i <a.length() ; i++) {
            if(a.charAt(i) >= '0' && a.charAt(i) <='9') {
                b.append(a.charAt(i));
            }else {
                b.append(" ");
            }
        }
        String c=b.toString();
        //空格分开
        String[] nums = c.split("\\s+");

        int count=nums[0].length();//假设第一个最长
        for (int i = 1; i < nums.length; i++) {
            if(nums[i].length()>count){
                count=nums[i].length();
            }
        }

        String d=new String();
        for (int i = 0; i <nums.length ; i++) {
            if(count==nums[i].length()){
               d=nums[i];
            }
        }
        System.out.println("最长的数字串长度为："+count);
        return d;
    }
}*/

//3：换饮料的个数：
/*
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入你现在手上的饮料个数;");
        int a=input.nextInt();
        System.out.println("可以换的饮料的数量："+change(a));

    }

    *//*思想：
    * 每次换的数目是n/3，剩余的瓶数是剩的加换的，
    * 也就是n/3+n%3，用count记录换的个数，直到剩的不够3瓶，则判断是否剩2瓶，是就直接count加一瓶。*//*
    public static int change(int n){
        int count=0;//换饮料的数量
        while (n/3!=0){
            count=count+n/3;//换的饮料
            n=n/3+n%3;//手中的饮料=换+剩余的
        }
        if(n==2){//剩下的饮料如果是两个的话
            count++;
        }
        return count;
    }
}*/

//4：逆序对：
/*
public class Main {
    public static void main(String[] args) {
        int[]a={1,2,3,4,5,6,7,0};
        System.out.println(count(a,a.length));
    }
    public static int count(int[] A, int n) {
        int count=0;
        for (int i = 0; i <A.length ; i++) {
            for (int j = i+1; j <A.length ; j++) {
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
*/

//2：找出第K大的数：
/*
public class Main {
    public static void main(String[] args) {
        int[]a={1,3,5,2,2};
        System.out.println(findKth(a,a.length,3));
    }
    public static int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        // write code here
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    count = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = count;
                }
            }
            if (flag == false) {
                break;
            } else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(a));
        int max = 0;
        for (int i = 0; i <=K; i++) {
            max = a[i];
        }
        return max;
    }
}*/

//1：判断回文数的个数：
/*
public class Main {
    public static void main(String[] args) {
        //Scanner input=new Scanner(System.in);
        String a="aba";
        String b="b";
        System.out.println(jude(a,b));
    }

    //方法数：
    public static int jude(String a,String b){
        int count=0;
        for (int i = 0; i <a.length() ; i++) {
            StringBuffer d=new StringBuffer();
            int e=i;
            for (int j = 0; j <e ; j++) {
                d.append(a.charAt(j));
            }
            d.append(b.charAt(0));
            for (int j=i;j<a.length();j++){
                d.append(a.charAt(j));
            }
            if(isH(d)){
                count++;
            }
        }

        return count;
    }

    //判断回文数的方法：
    public static boolean isH(StringBuffer c){
        int left=0;
        int right=c.length()-1;
        while (left<right){
            if(c.charAt(left)!=c.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
*/

 /*  d.append(b);
        for (int i = 0; i <a.length() ; i++) {
            d.append(a.charAt(i));
        }

        d.append(a.charAt(0));
        d.append(b);
        for (int i = 1; i <a.length() ; i++) {
            d.append(a.charAt(i));
        }

        d.append(a.charAt(0));
        d.append(a.charAt(1));
        d.append(b);
        for (int i = 2; i <a.length() ; i++) {
            d.charAt(i);
        }
*/