package com.dataStrcture;
import java.util.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.List;

import java.util.Comparator;
/*PriorityQueue所包含接口：
* 1：构造方法
* 2：offer()
* 3：peek()
* 4：poll()
* 5：clear()
* TOP-K问题：
* 1：排序sort，取前k个元素
* 2：优先级队列：peek(),poll()
* 3：构造平衡二叉树，打印前k个
* 4：二叉搜索树：按照中速遍历回收k个数据
* priorityQueue：底层是堆*/
class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card o){

        // 牌面值
        return rank - o.rank;
    }
/*自定义类型的比较：
* 1：自己重写object类中equal方法，因为所有的类都是记成object类：只能进行等于的比较
* 2：基于java语言的比较器进行比较，实现Comparable接口即可，重写compareTo方法即可：可以进行比大小   */
    //自己实现重写object类的equal方法即可
    @Override
    public boolean equals(Object o) {
        if(this == o){//自己和自己比较
            return true;
        }

        if(null == o || !(o instanceof Card)){//判断是否为null，或者是否是同一个类型的
            return false;
        }

        //注意：基本类型可以直接进行比较但是引用类型最好是调用equal方法
        Card card = (Card)o;
        return rank == card.rank &&
                suit.equals(card.suit);
    }
}
// 基于比较器的比较：比大小》实现Comparable接口即可，重写compareTo方法即可
class CardComp implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        if(o1 == o2){
            return 0;
        }

        if(null == o1){
            return  -1;
        }

        if(null == o2){
            return 1;
        }


        return o2.rank - o1.rank;
    }
}


public class TestPriorityQueue {
    public static void TestPriorityQueue1(){
        //创建优先级队列的三种方式：
        //1：构建一个空的优先级 队列--注意：空的优先级队列，在底层已经有了11个默认空间
        PriorityQueue<Integer>p1=new PriorityQueue<>();

        //2：按照指定容量来进行构造：如果知道优先级队列中大概需要放多少个元素，最好使用该方法进行构造
        //不要用空的构造方法构造，因为在插入元素的时候需要扩容而影响程序的效率
        //Capacity：不能小于1，若果小于1就抛出异常：非法参数
        PriorityQueue<Integer>p2=new PriorityQueue<>(20);

        //3：可以用一个集合来构造优先级队列，将来就会将集中的元素放在优先级队列中

        //使用List构造优先级队列的时候，优先级队列并不是直接将List中的元素拷贝进去
        //而是将List中的元素按照一定的规则进行排列
        List<Integer> l=new ArrayList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        PriorityQueue<Integer>p3=new PriorityQueue<>(l);
        System.out.println(p3.size());
    }

    public static void TestPriorityQueue2(){
        PriorityQueue<Integer>p=new PriorityQueue<>();

        /*注意：
        1：插入时的元素一定要能进行比大小，而且不能插入null对象
        2：插入时会自动机进行扩容
        3：插入的时间复杂度是log2(N)
        4：插入失败的时候，返回false或者抛出异常
        5：插入期间，优先级队列中的元素会进行调整，首元素一定是最小的*/

        p.offer(4);
        p.offer(1);
        p.offer(2);
        p.offer(0);
        p.offer(5);

        /*1：peek()：取优先级最小(第一个元素)的元素
        * 2：poll()：删除优先级最低(第一个元素)的元素
        * 3：poll()：删除元素后的优先级队列，会自动进行调整→将神域元素中的最小的元素调整到首元素的位置
        * 4：poll()：删除的时间复杂度log2(N)*/
        //打印优先级高的元素：
        System.out.println(p.peek());

        p.poll();//删除元素，删除的是优先级最小的元素
        System.out.println(p.peek());
        p.poll();
        System.out.println(p.peek());
        p.poll();
        System.out.println(p.peek());

        p.clear();
        if(p.isEmpty()){
            System.out.println("优先级队列为空");
        }else{
            System.out.println("优先级队列中不为空");
        }

    }

    public static void TestPriorityQueue3()
    {
        PriorityQueue<Card> q = new PriorityQueue<Card>();
        q.offer(new Card(5, "♠"));
        q.offer(new Card(6, "♠"));
        q.offer(new Card(4, "♠"));
    }

    public static void TestCompare2()
    {
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = c1;
        Card c4 = new Card(1, "♠");

        if(c1.equals(c4)){
            System.out.println("c1 == c4");
        }
        else{
            System.out.println("c1 != c4");
        }

        System.out.println(c1 == c2);
        System.out.println(c1 != c2);
        //System.out.println(c1 == c4);
        System.out.println(c1.compareTo(c2));
    }

    public static void TestCompare3() {
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = c1;
        Card c4 = new Card(1, "♠");

        // 如果要比较，先要给一个比较器的对象
        CardComp comp = new CardComp();
        if(comp.compare(c1, c2) > 0){
            System.out.println("c1 > c2");
        }
        else if(comp.compare(c1, c2) == 0){
            System.out.println("c1 == c2");
        }
        else{
            System.out.println("c1 < c2");
        }
    }


    public static void TestCompare1() {
        int a = 10;
        int b = 20;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);

        char c1 = 'A';
        char c2 = 'B';
        System.out.println(c1 > c2);
        System.out.println(c1 < c2);
        System.out.println(c1 == c2);

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 == b2);
        System.out.println(b1 != b2);

    }

    static public void TestPriporityQueue4(){
        Card c1 = new Card(5, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = new Card(1, "♠");
        Card c4 = new Card(3, "♠");

        PriorityQueue<Card> p1 = new PriorityQueue<>(4);
        p1.offer(c1);
        p1.offer(c2);
        p1.offer(c3);
        p1.offer(c4);

        // 大堆
        PriorityQueue<Card> p2 = new PriorityQueue<>(4, new CardComp());
        p2.offer(c1);
        p2.offer(c2);
        p2.offer(c3);
        p2.offer(c4);
    }

    public static void main(String[] args) {
       /* TestPriorityQueue1();
        TestPriorityQueue2();*/
        // TestPriorityQueue3();
        //TestCompare1();

        // TestCompare2();

        // TestCompare3();
        TestPriporityQueue4();
    }
}
