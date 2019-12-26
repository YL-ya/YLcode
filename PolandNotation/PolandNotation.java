package com.dataStrcture;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*1·前缀表达式：(也就是将表达式进行二叉树进行前中后序进行遍历)前缀表达式又名叫波兰表达式
    *特点：运算符都位于操作数之前
* 2·中缀表达式：运算过程和人们记性运算过程是一样的思维，但是相对于计算机运算是比较难操作的，
    * 一般不用中缀表达式进行计算（人们思维常用的，一般在及其中转成后缀表达式比较好计算）因为要比较运算符的优先级
* 3·后缀表达式：也就是二叉树进行后序遍历(又称之为逆波兰表达式)
    * 特点：与前缀表达式相似，就是运算符在操作数的后面*/
//先给出一个表达式：(3+4)×5-6
/*前缀表达式：- × +  3 4 5 6
 * 1·先从右到左进行扫描，将6 5 4 3入栈
 * 2·当遇到操作符“+”时，将栈顶的两个元素进行出栈，将运算后的值（7）放入数栈
 * 3·接下来就是×运算符，因此从栈中弹出7和5进行乘法运算*/
/*后缀表达式：3 4 + 5 × 6 -
 * 1·先从左到右进行扫描，将3 4 进行入栈
 * 2·当遇到“+”时，将数进行弹出，进行计算后的值（7）压入堆栈
 * 3·然后将5进行入栈
 * 4·然后遇到“×”，将栈中的数进行弹出即可（7*5）=35；将35入栈，依次类推即可*/
//问题：完成一个逆波兰计算器（后缀表达式）；使用栈实现（用系统提供的栈）
public class PolandNotation {
    public static void main(String[] args) {
        //先定义一个后缀表达式：
        String expression="3 4 + 5 * 6 －";//中间用空格隔开(数字和运算符)
        /*思路：
        * 1·先将逆波兰表达式存放在ArrayList中
        * 2·然后将ArrayList当成实参进行传递给一个方法，配合栈完成计算（也就是将扫描字符串变成遍历ArrayList即可）*/
        List<String> returnList=getListString(expression);
        int result=calculate(returnList);
        System.out.println("运算结果为："+result);
    }
    //写一个方法：将一个逆波兰表达式中的运算符和数字放在ArrayList中去
    public static List<String> getListString(String expression){
        //将字符串进行分割
        String[]split=expression.split(" ");//将字符串以空格进行分割
        List<String> list =new ArrayList<String>();//List里面包括ArrayList(顺序表)；LinkedList(链表)
        for(String x:split){//对split数组进行循环取出并放在ArrayList里面
            list.add(x);
        }
        return list;//那么list里面就是放的是数字和运算符的一个顺序表
    }

    //完成对逆波兰表达式的运算
    /*后缀表达式：3 4 + 5 × 6 -
     * 1·先从左到右进行扫描，将3 4 进行入栈
     * 2·当遇到“+”时，将数进行弹出，进行计算后的值（7）压入堆栈
     * 3·然后将5进行入栈
     * 4·然后遇到“×”，将栈中的数进行弹出即可（7*5）=35；将35入栈，依次类推即可*/
    public static int calculate(List<String> lists) {
        //创建栈，只有一个数栈即可
        Stack<String> stack = new Stack<String>();
        //遍历list
        for(String item:lists){
            if(item.matches("\\d+")){//匹配的是数字，进行入栈即可
                //入栈
                stack.push(item);
            }else {//也就是当匹配的是运算符的时候，将数字进行弹出。然后进行运算，之后将运算结果入栈
                int num2=Integer.parseInt(stack.pop());//将字符串格式化成相应的类型
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("－")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if (item.equals("/")){
                    res=num1/num2;
                }else {//什么都不是的时候抛出异常就行
                    throw new RuntimeException("运算符有误");
                }
                //条件判断完了之后，得出结果，然后将结果入栈
                stack.push(res+"");//因为栈中存放的是String类型的，所以就要进行转换
            }
        }
        //最后留在栈中的就是运算结果
        return Integer.parseInt(stack.pop());//将栈中的最后一个元素进行弹出在转成int类型的
    }
}

