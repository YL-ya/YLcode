package com.dataStrcture;
/*将数组模拟成队列的思想：
* 1·因为是先进先出，所以我们可以采用尾巴添加值进入数组，头部从数组中将值取出，然后将下标进行++
* 2·front指向的是头元素的前一个位置，也就是说arr[front+1]才是表示队列的第一个元素
* 3·rear指向的当前队列的最后一个元素，也就是说rear+1的时候才能进行插值
* 4·front的初始值=-1;;;;;rear的初始值=-1
* 5·队列为空的条件：front==rear；
* 6·队列为满的条件：rear+1=maxSize;
* 7·当前队列的有效个数就是rear-front的值即可
* 8·存在的问题是：这样的数组模拟队列只能用一次，不能进行复用
* 9·进行优化的算法就是：将队列变成一个循环队列*/
import java.util.Scanner;
//队列：特点先进先出
/*
* 1·有两种存储方法：数组（顺序存储）和链表（链式存储）
* */
//（一）使用数组模拟队列：
class ArrayQueue{
    private int maxSize;//模拟对列的最大值，也就是该队列未满的时候的输的个数
    private int front;//指向队列的头部的前一个数据
    private int rear;//指向队列尾部的当前数据
    private int[]arr;//该处是数组模拟队列的数组

    //数组模拟队列的构造方法
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        front=-1;
        rear=-1;
        arr=new int[maxSize];
    }

    //判断队列是为满：
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //判断队列是否为空：
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列：也就是从尾部rear开始添加数据
    /*若队列已经满了则就不能添加数据了*/
    public void addQueue(int n){//进队列
        //判断队列是否为空的情况下，直接退出假如，并提示队列已满
        if(isFull()){
            System.out.println("队列已经满了不能再添加数据了");
            return;
        }
        //然后就是队列不为满的情况下：
        rear++;//尾巴向后加一位在进行添加，因为刚开始的时候rear=-1
        arr[rear]=n;//加入数据n到队列中
    }

    //从队列中取出数据：也就是从头部front开始去除数据：就是为了达到先进先出的成果
    /*若队列为空的情况下就不能从队列中去除数据了*/
    public int getQueue(){//出队列
        //判断队列是否为空的情况下，直接退出，并提示队列为空
        if(isEmpty()) {
            //return -1;注意：在这里返回-1 是不行的因为front的其实位置就是在-1 的位置，所以可以进行抛异常
            //通过抛出异常来处理
            throw new RuntimeException("队列为空，不能取数据");//注意：在这个抛出异常之后没必要在写return，
            // 因为在这里抛出的异常直接到下面的语句都是不可达的
        }
        //然后就是队列不为空的时候进行取出数据即可
        front++;//因为取出后将队列中的第一个元素变成下一个元素
        return arr[front];
    }

    //显示队列的所有数据：
    public void show(){
        //队列为空的时候，里面没有数据，无法进行打印
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //显示一个队列的头部数据，注意只是显示不能是取出
    public int headQueue(){
        //首先得判断队列是否为空，若为空则没有数据可显示
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据可以显示");
        }
        return arr[front+1];//注意：在这里一定是front+1，因为front指向的是队列头部元素的前一个数据
    }
}
public class Queue {
    public static void main(String[] args) {
        System.out.println("测试数组模拟队列的案例：");
        //创建一个数组队列
        ArrayQueue arrayQueue=new ArrayQueue(3);//创建一个数组队列大小为3
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
                    arrayQueue.addQueue(val);
                    break;
                case 'g'://因为在去除数据的方法中抛出了异常，所以我们就得进行和异常捕获
                    try {
                        int result=arrayQueue.getQueue();
                        System.out.println("取出的数据是："+result);//在这里如果发生异常将不会执行该条语句
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    arrayQueue.show();//显示队里面的内容
                    break;
                case 'h':
                    try {
                        int result=arrayQueue.headQueue();
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
/*
1·问题：目前的数组队列只能用一次就不能用了，没法达到复用的效果
2·优化：将数组加以算法，采用环形队列即可达到，利用取模运算即可
*/
