/*递归：
 * 1·解决的应用问题：汉诺塔，八皇后，迷宫问题，排序，归并等等
 * 2·执行一个方法的时候，会自动开辟一个栈的空间（栈溢出异常：StackOverFlewException）
 * 3·如果方法中传参传的是引用类型的时候，是共享一个数组*/
package com.dataStrcture.DiGui;
/*迷宫问题：
* 1·先创建一个数组进行模拟迷宫：地图
* 2·采用策略
* */

public class MiGong {
    public static void main(String[] args) {
        //1·先创建一个数组进行模拟迷宫的地图
        int[][]map=new int[8][7];
        //2·用1 表示墙，也就是不能过去的地方：也就是把二维数组的上下全部围起来
        for (int i = 0; i <7 ; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        //3·左右置为1，也就是将数组围起来
        for (int i = 0; i <8 ; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //4·设置迷宫的挡板
        map[3][1]=1;
        map[3][2]=1;
        /*//4.1：说明回溯的问题：将它堵死
        map[1][2]=1;
        map[2][2]=1;*/
        //5·输出地图：
        System.out.println("输出地图的样子：");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println(" ");
        }
       /* //6·使用递归进行找路
        setWay(map,1,1);
        //输出新的地图，小球走过的，并标识过的地图：
        System.out.println("小球走过的地图：");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }*/
        //7:改变策略的结果：
        setWay2(map,1,1);
        System.out.println("输出新的小球走过的地图：");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //使用递归给小球找路：找到了就返回一个真，找不到就返回一个假，
    /*1·map：表示地图
    * 2·i和j：表示从哪个位置开始找：刚开始就是在map[1][1]
    * 3·如果找到通路就返回true
    * 4·如果小球能到map[6][5],就说明通路能通
    * 5·如果碰到1就说明能走，2表示能通，3表示已经标记已经走过，但是走不通，没必要在去走一遍
    * 6·在走迷宫是要进行设计一个策略(方法)：下→右→上→左；如果该点走不通进行回溯*/
    public static boolean setWay(int[][]map,int i,int j){
        if(map[6][5]==2){//说明通路已经找到
            return true;
        }else{
            if(map[i][j]==0){//如果这个点没有被走过，先走在判断
                map[i][j]=2;//也就是加点这个点可以走通
                if(setWay(map,i+1,j)){//向下走，如果那你如果走通，就返回一个true
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j)){//向上走
                    return true;
                }else if(setWay(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点走不通，将该点置为3
                    map[i][j]=3;
                    return false;
                }
            }else {//如果map[i][j]!=0;map[i][j]可能是1或者2,3
                return false;
            }
        }
    }
    //修改走路的策略：上，右，下，左
    public static boolean setWay2(int[][]map,int i,int j){
        if(map[6][5]==2){//说明通路已经找到
            return true;
        }else{
            if(map[i][j]==0){//如果这个点没有被走过，先走在判断
                map[i][j]=2;//也就是加点这个点可以走通
                if(setWay2(map,i-1,j)){//向上走，如果那你如果走通，就返回一个true
                    return true;
                }else if(setWay2(map,i,j+1)){//向右走
                    return true;
                }else if(setWay2(map,i+1,j)){//向下走
                    return true;
                }else if(setWay2(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点走不通，将该点置为3
                    map[i][j]=3;
                    return false;
                }
            }else {//如果map[i][j]!=0;map[i][j]可能是1或者2,3
                return false;
            }
        }
    }

}
