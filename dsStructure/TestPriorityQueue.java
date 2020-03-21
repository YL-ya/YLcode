package com.dataStrcture;
import java.util.*;
import java.util.Queue;
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
    public static void main(String[] args) {
        TestPriorityQueue1();
        TestPriorityQueue2();
    }
}
