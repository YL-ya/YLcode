import java.util.*;
//13：放蛋糕：
public class Main{
    public static void main(String[] args) {
        int a=3;
        int b=2;
        

    }
}
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