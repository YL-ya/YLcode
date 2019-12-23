package com.dataStrcture;
//中缀表达计算器：
//首先要创建一个栈：需要进行扩展功能：优先级的判断；数字与符号的判断
/*用栈实现综合计算器
* 1·通过一个index指针进行遍历输入的表达式
* 2·如果发现是数字进行入(数字)栈操作
* 3·如果发现是运算符进行入(运算符)栈操作
    * 3.1·如果发现运算符栈是空的就直接入栈
    * 3.2·如果运算符栈不为空，则就与运算符栈栈顶的元素进行优先级的比对：
           * 3.2.1·若优先级低于栈顶运算符，则数栈出栈两位数，运算符栈出栈一位，然后进行计算，将计算的结果进行入栈到数栈中，
                * 然后将当前优先级低的运算符进行入栈(运算符)处理
           * 3.2.2·若优先级高于栈顶运算符就直接入运算符栈
* 4·当表达式扫描完毕后，依次从数栈和字符栈中pop出相应的数字和运算符进行运算
* 5·最后一个在数栈中的就是结果
* 6·总结：上面的思路只能解决一位数的加减乘除
* 7·优化：解决多位数的运算器
* 7.1·在扫描为一个数字时，不着急入栈，要向后进行扫描，
    * 看看后面是否还有数字，若还是有的话进行拼接，若为运算符的话，就直接入(数)栈
    * 注意：拼接的时候将用于拼接的那个变量进行清空即可，不然拼接后的数字有错
    * */

class ArrayStack1{
    public int maxSize;//栈的大小
    public int[]stack;
    public int top=-1;//栈顶，初始化为-1;

    //构造器：
    public ArrayStack1(int maxSize) {
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

    //返回一个栈栈顶的数值，但不是真正的出栈(pop)，只是知道里面存的是什么进行看一眼，比对一下即可
    public int peek(){
        return stack[top];
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

    //返还运算符的优先级，优先级由程序员来确定，优先级使用数字来进行表示：数字越大优先级越高
    public int priority(int oper){//在java中char和int是可以互用的，char的底层比较就是int数值的比较
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;//假定目前的运行符只有加减乘除
        }
    }

    //判断是是不是一个运算符
    public boolean isOper(char val){
        return val=='*'||val=='/'||val=='+'||val=='-';
    }//返回时真的话就是运算符

    //进行计算的方法
    public int cal(int num1,int num2,int oper){
        int result=0;
        switch (oper){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num2-num1;//注意顺序
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num2/num1;
                break;
            default:
                 break;
        }
        return result;
    }

}

public class StackCalculator {
    public static void main(String[] args) {
        //根据思路，完成表达式的运算：
        String exception="70+2*6-2";
        //创建两个栈，就是数栈和符号栈
        ArrayStack1 numStack=new ArrayStack1(10);
        ArrayStack1 operStack=new ArrayStack1(10);
        //创建一个变量用来扫描字符串
        int index=0;//用来扫描的
        int num1=0;
        int num2=0;
        int oper=0;
        int result=0;
        char ch=' ';//将每次扫描的char保存到ch中
        String keepNum="";//用于拼接多位数
        while(true) {
            //依次得到扫描字符串得到的字符：exception
            ch = exception.substring(index, index + 1).charAt(0);

            //开始进行判断：然后做出相应的处理
            if (operStack.isOper(ch)) {//如果扫描的是运算符
                //第一就是得判断，符号栈是否为空
                if (!operStack.isEmpty()) {//当前符号栈不为空,也就是说要进行优先级的比较
                    //进行处理：
                    // 比较后，从符号栈中pop出一个运算符，然后从数栈中pop出两个数进行运算即可
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {//进行与符号栈栈顶的符号进行优先级的比对
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();//也就是数栈弹出两个，符号栈弹出一个进行运算
                        result = numStack.cal(num1, num2, oper);

                        //然后将运算后的结果进行入栈
                        numStack.push(result);

                        //然后还要将当前优先级低的进行如符号栈
                        operStack.push(ch);

                    } else {//反之，当前的运算符的优先级高于运算符栈顶的运算符
                        operStack.push(ch);
                    }
                } else {
                    //表示当前符号栈不为空的时候，进行入栈处理
                    operStack.push(ch);
                }

            } else {/*当ch为数值的时候，直接入栈：
            注意：1·不能一发现是数的时候进行入栈处理
                  2·70：就得向后再看一位，若果是符号的话，将数字进行入栈，如果还是数字的话就得进行拼接，将拼接的结果入栈
                  3·因此我们要定义一个变量 字符串，用于拼接*/

                //处理多位数：
                keepNum += ch;

                //如果：ch是exception的最后一位，不用再进行扫描，直接入栈即可
                if (index == exception.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //拼接完成了之后，判断下一个字符是否还是数字，若是数字继续进行扫描即可，如果是运算符，直接将其数字入栈即可
                    //注意：只是向后看一位，所以index是不变的
                    if (operStack.isOper(exception.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，就直接入栈：keepNum="1";或者"123"
                        numStack.push(Integer.parseInt(keepNum));//字符串转int

                        //重要!!!!要讲keepNum清空,因为下个数字进行拼接的时候是一个新的
                        keepNum = "";
                    }
                    //numStack.push(ch - 48);//因为之后后读入的是字符，而不是整数，在ASC码表中
                }
            }
            //让index+1，(也就是index一直遍历)看看是否到了扫描的是字符串的最后一个的时候,也就是循环跳出的时候
            index++;
            if(index>=exception.length()){
                break;
            }
        }
        //当表达式扫描完毕的话，就顺序的从 数栈和符号栈进行pop处理，进行运算即可
        while (true){
            //如果符号栈为空，则就是计算到最后一次计算，也就是最后的结果，数栈中也只有一个数值(结果)
            if(operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            result=numStack.cal(num1,num2,oper);
            numStack.push(result);//入栈
        }
        //将数栈中的左后一个数pop出来就可以，就是表达式的结
        System.out.println("表达式："+exception.toString()+"="+numStack.pop());
    }
}
