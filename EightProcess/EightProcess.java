package com.dataStrcture.DiGui;
/*
* 八皇后问题：每个皇后不能在同一行，同一列，和同一斜线的位置上
* 采用递归回溯的算法进行：会用有15000次，小卤较低，优化算法是：贪心算法
* 思路:
* （1）：第一个皇后放在棋盘的第一行第一列
* （2）：第二个皇后放在第二行第一列，然后判断是否OK，如果不OK，继续放在第二行第二列，第三列，依次将所有列放完，直到找到一个合适的。
* （3）：继续第三个皇后，还是第一列，第二列直到八个皇后放在一个不冲突的位置上，算是找到了一个解
* （4）：当得到一个正确解之后，在栈回退到上一个栈的时候，就会开始回溯，即将第一个皇后，放在第一列的所有正确解，全部得到
* （5）：然后回头的时候第一个皇后放在第一行的第二列，后面继续1,2,3,4的步骤即可*/
//说明：理论上可以用二维数组进行表示棋盘，但是实际上可以通过算法，用一个一位数组即可解决问题
//arr[8]={0,4,7,5,2,6,1,3}即下标表示的是第几行，arr[i]==val,val表示的就是皇后的所在位置
public class EightProcess {
    //定义一个max表示一共有多少个皇后
    int max=8;
    //定义一个数组arr保存皇后防止位置的保存结果，比如arr[8]={0,4,7,5,2,6,1,3}
    int[]arr=new int[max];//因为棋盘是共享的所以写在外面

    public static void main(String[] args) {

    }

    //写一个方法，可以将皇后最后摆放的位置打印出来
    private void print(){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
}