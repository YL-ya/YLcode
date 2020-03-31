import java.util.Arrays;
import java.util.Scanner;
//3：换饮料的个数：
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入你现在手上的饮料个数;");
        int a=input.nextInt();
        System.out.println("可以换的饮料的数量："+change(a));

    }

    /*思想：
    * 每次换的数目是n/3，剩余的瓶数是剩的加换的，
    * 也就是n/3+n%3，用count记录换的个数，直到剩的不够3瓶，则判断是否剩2瓶，是就直接count加一瓶。*/
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
}

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