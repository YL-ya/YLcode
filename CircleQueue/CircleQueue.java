package com.dataStrcture;
/*循环队列的思想：可已将数组进行复用
* 1·采用一个预留空间
* 2·rear指向的是最后一个元素的后一个位置；
* 3·front指向的是队列的第一个元素，也就是说arr[front]就是队列的第一个元素，希望留出一个预留空间进行判断满的
* 4·rear的初始值=0;;;;;front的初始值=0；
* 5·队列满的条件是：(rear+1)%maxSize==front
* 6·队列空的条件是：rear==front;
* 7·循环队列中的有效数的个数：(rear+maxSize-front)%maxSize(也就是说当前循环队列的有效个数是数组大小-1的值)*/
import java.util.Scanner;
class CircleArray{
    private int maxSize;//模拟环形队列的最大值，也就是该队列未满的时候的输的个数
    private int front;//指向环形队列的头数据(当前)
    private int rear;//指向环形队列尾部的下一个元素
    private int[]arr;//该处是数组模拟环形队列的数组

    //数组模拟环形队列的构造方法
    public CircleArray(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        /*front=0;//可以不用写，因为默认为0
        rear=0;*/
    }

    //判断环形队列是为满：
    public boolean isFull(){
        return (rear+1)%maxSize==front;//预留一个空间
    }

    //判断环形队列是否为空：
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到环形队列
    public void addCircleQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能再向里面添加数据了");
            return;
        }
        //现在的rear指向的就是当前的队尾，直接添加即可
        arr[rear]=n;
        //然后将rear后移一位，因为现在是环形队列，所以要进行的是取模运算
        rear=(rear+1)%maxSize;
    }

    //从环形队列中取出数据
    public int getCircleQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        //在这里需要分析front是指向队列的第一个元素
        /*注意：为什么要采用第三变量，因为直接返回front的值的话，就无法将front进行后移一位
        * 1·要采用一个第三个变量将队列中的front的值保存下来
        * 2·front需要后移，为了不越界就得考虑取模运算
        * 3·将第三个变量的值返回即可*/
        //return arr[front];
        int value=arr[front];
        //front++;
        front=(front+1)%maxSize;
        return value;
    }

    //显示循环队队列中的有效元素：
    public void showCircleQueue(){
        if(isEmpty()){
            System.out.println("循环队列为空，没有数据可显示");
            return;
        }
        for(int i=front;i<front+size();i++)//因为是环形队列，所有便利的所有有效的数据
        {
            System.out.println(arr[i%maxSize]+" ");//因为下标是环形的队列
        }
    }
    //求出当前队列中的有效数据：
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示一个循环队列的头部数据，注意只是显示不能是取出
    public int headQueue(){
        //首先得判断循环队列是否为空，若为空则没有数据可显示
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据可以显示");
        }
        return arr[front];//注意：在这里一定是front+1，因为front指向的是队列头数据（当前头部的元素）
    }

}
public class CircleQueue {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例：");
        //创建一个数组队列
        CircleArray circleArray=new CircleArray(3);//创建一个数组队列大小为3,但是有效数据最大是2
        char key=' ';//接受用户的输入
        Scanner input=new Scanner(System.in);
        System.out.println("请输入的选择");
        boolean loop=true;
        while(loop){
            System.out.println("a:表示添加数据到队列中");
            System.out.println("g:表示从队列中去除数据");
            System.out.println("s:表示显示队列");
            System.out.println("h:表示显示队列的头元素");
            System.out.println("e:表示退出操作");
            key=input.next().charAt(0);//表示读入一行的字母
            switch (key){
                case 'a':
                    System.out.println("请输入一个数：");
                    int val=input.nextInt();
                    circleArray.addCircleQueue(val);
                    break;
                case 'g'://因为在去除数据的方法中抛出了异常，所以我们就得进行和异常捕获
                    try {
                        int result=circleArray.getCircleQueue();
                        System.out.println("取出的数据是："+result);//在这里如果发生异常将不会执行该条语句
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    circleArray.showCircleQueue();//显示队里面的内容
                    break;
                case 'h':
                    try {
                        int result=circleArray.headQueue();
                        System.out.println("该队列的头元素是："+result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    input.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
