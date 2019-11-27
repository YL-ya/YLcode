package lanqiaobei;
import java.util.Scanner;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入单词长度：");
        int size=sc.nextInt();
        String[] a=new String[size];
        System.out.println("输入单词：");
        for (int i = 0; i <size ; i++) {
            a[i]=sc.next();
        }
        for (int i = 0; i <size-1 ; i++) {
            String temp=a[i];
            switch (temp){
                case "a":
                    System.out.println('a');
                    break;
                case "e":
                    System.out.println('e');
                    break;
                case "i":
                    System.out.println('i');
                    break;
                case "o":
                    System.out.println('o');
                    break;
                case "u":
                    System.out.println('u');
                    break;
                default:
                    System.out.println('n');
                    break;
            }
            break;
        }
    }
    public static void main8(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你是几行几列的矩阵");
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] a = new int[m][n];
        int right = 1, down = 2, left = 3, up = 4;//上下左右四个方向
        int dir = right;
        int i = 0, j = 0;
        int count = m * n;
        for (int p = 1; p <= count; p++) {
            a[i][j] = p;
            if (dir == right) {
                if (j + 1 < n && a[i][j + 1] == 0) {
                    j++;
                } else {
                    i++;
                    dir = down;
                    continue;
                }
            }
            if (dir == down) {
                if (i + 1 < n && a[i + 1][j] == 0) {
                    i++;
                } else {
                    j--;
                    dir = left;
                    continue;
                }
            }
            if (dir == left) {
                if (j - 1 >= 0 && a[i][j - 1] == 0) {
                    j--;
                } else {
                    i--;
                    dir = up;
                    continue;
                }
            }
            if (dir == up) {
                if (i - 1 >= 0 && a[i - 1][j] == 0) {
                    i--;
                } else {
                    j++;
                    dir = right;
                    continue;
                }
            }
        }
        for(int k=0;k<m;k++){
            for(int z=0;z<n;z++){
                System.out.print(a[k][z]+" ");
            }
            System.out.println();
        }
        System.out.println("请输入你想要的位置");
        int b=input.nextInt();
        int c=input.nextInt();
        for(int k=0;k<=m;k++) {
            for (int z = 0; z <=n; z++) {
                System.out.print(a[b][c] + " ");
                break;
            }
        }
    }
}

/*

    public static void main7(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入范围：");
        int n = input.nextInt();
        System.out.println("请输入三个数：");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((i % a != 0) && (i % b != 0) && (i % c != 0)) {
                count++;
            }
        }
        System.out.println("这样的数有" + count + "个");
    }


    public static void main6(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int n = input.nextInt();
        int b = 0;
        for (int i = 0; i <= n; i++) {
            int a = i;
            while (a != 0) {
                if (a % 10 != 2) {
                    b++;
                }else if(a%10==2){
                    break;
                }
                a = a / 10;
            }
        }
        System.out.println("有"+b+"纯净数");
    }
}

*/
