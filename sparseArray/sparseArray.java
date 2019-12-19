package com.dataStrcture;
//五子棋程序
/*稀疏数组解决五子棋：达到压缩的效果
 * 稀疏数组的定义：当一个数组大部分的值为0或者为一个固定的值得时候我们可以采用稀疏数组进行保存
 * 稀疏数组处理方式：row
 * 1·记录数组有几行几列，有多少个不同的值
 * 2·把具有不同元素的行列及值记录在一个小规模的数组中(也是稀疏数组)，从而缩小程序的规模
 * */
public class sparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        /*0：表示没有棋子，1：表示黑子 2：表示蓝子
         * */
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5]=2;
        //输出原始数组
        System.out.println("打印原始数组:");
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                System.out.print(chessArr1[i][j] + " ");
            }
            System.out.println();
        }
       /* for (int[] row:chessAry1){//遍历二维数组每一行
            for (int data:row){//遍历每一行中的元素值
                System.out.print(" "+data+" ");
            }
            System.out.println();
        }*/
/*
       将二维数组 转 稀疏数组
*/
        //1：先遍历二维数组，找到非0数据的个数*/
        int sum=0;
        for (int i = 0; i <chessArr1.length; i++) {
            for (int j = 0; j <chessArr1.length ; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("二维数组中非0的个数：\n"+sum);//这样我们就得到了稀疏数组的行长度

        //2:创建稀疏数组：
        int sparseArr[][]=new int[sum+1][3];

        //稀疏数组的第一行存的是原始数据的行列数和非0的个数
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组，将非0的值存放在sparseArr数组中去
        int count=0;
        for (int i = 0; i <chessArr1.length; i++) {
            for (int j = 0; j <chessArr1.length ; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println("打印稀疏数组：");
        for (int i = 0; i <sparseArr.length ; i++) {
            System.out.println(sparseArr[i][0]+" "+sparseArr[i][1]+" "+sparseArr[i][2]);

        }

        //将稀疏数组恢复成 原始的二维数组
        /*
        * 1·先要读取到稀疏数组的第一行，将初始时候的数组的行列大小读出来，因为你有可能该稀疏数组在另外一个class中
        * 2·遍历这个稀疏数组将其全部转化为稀疏数组*/
        int[][] chessArr2=new int[sparseArr[0][0]][sparseArr[0][1]];//将原来数组的行列大小都读出来并开辟一个新的二维数组
        //所以第一行存的是稀疏数组的大小，那么稀疏数组里面的值就是从第二行开始才是原来二维数组中的非0值
        for(int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("打印原始的二维数组：");
        for (int i = 0; i <chessArr2.length ; i++) {
            for (int j = 0; j <chessArr2.length; j++) {
                System.out.print(chessArr2[i][j]+" ");
            }
            System.out.println();
        }

    }
}
