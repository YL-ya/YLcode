package com.dataStrcture;
import java.util.Scanner;
//用数组模拟栈
/*思想：
* 1·先创建栈，用数组
* 2·定义一个变量top表示栈顶，初始化为-1
* 3·入栈：top++,stack[top]=val，要进行栈满的操作
* 4·出栈：数据取出：int value=stack[top];top--即可，要进行判断栈为空的操作，因为有返回值，所以一般我们进行异常抛出*/
class ArrayStack{
    public int maxSize;//栈的大小
    public int[]stack;
    public int top=-1;//栈顶，初始化为-1;

    //构造器：
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];//初始化栈的大小
    }

    //栈满
    public boolean isFull(){
        return top==maxSize-1;//当栈满的时候top=maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //入栈：push
    public void push(int val){
        //要先判断栈是否满了
        if(isFull()){
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top]=val;
    }

    //出栈：pop:将栈顶的数据进行返回，并且top--
    public int pop(){
        if(isEmpty()){
            //有返回值的话，可以进行抛出异常，不然返回的就是有数据的
            throw new RuntimeException("栈是空的，无元祖进行返回");
        }
        int value=stack[top];
        top--;
        return value;
    }

    //显示栈中的所有值，进行栈遍历
    public void showStack(){
        //遍历时，需要从栈顶遍历数据
        if(isEmpty()){
            System.out.println("栈为空，没有数据可以显示");
            return;
        }
        for(int i=top;i>=0;i--){//要从栈顶开始遍历栈
            System.out.println("stack["+i+"]="+stack[i]);
        }
    }
}

public class Stack {
    public static void main(String[] args) {
        //测试ArrayStack
        ArrayStack stack=new ArrayStack(4);
        String key="";
        boolean loop=true;//控制是否输出菜单
        Scanner input = new Scanner(System.in);

        while(loop){
            System.out.println("show：显示栈");
            System.out.println("exit：退出");
            System.out.println("push：表示将数据入栈");
            System.out.println("pop：表示将数据出栈");
            System.out.println("请输入你的选择：");
            key=input.next();
            switch (key){
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入你要入栈的元素：");
                    int value=input.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res=stack.pop();
                        System.out.println("出栈的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());//如果发生异常，打印在pop中处理的异常结果即可
                    }
                    break;
                case "exit":
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
