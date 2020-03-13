package com.dataStrcture.hashtab;

import java.util.Scanner;

//自己实现哈希表的创建：
public class HashTabDemo {
    public static void main(String[] args) {
        //测试一下自己写的hashtab
        //创建哈希表
        HashTab hashTab=new HashTab(7);

        //写一个菜单
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("exit：退出系统");

            key = scanner.next();

            switch (key){
                case "add":
                    System.out.println("请输入id：");
                    int id=scanner.nextInt();
                    System.out.println("输入名字：");
                    String name=scanner.next();
                    //创建雇员
                    Emp emp=new Emp(id,name);
                    hashTab.addEmp(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("系统退出");
                case "find":
                    System.out.println("请输入该员工的id：");
                    id=scanner.nextInt();
                    hashTab.find(id);
                default:
                    break;
            }
        }
    }
}

//创建哈希表;hashtable：用来管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListsArrsy;//该数组拉米娜放的的EmpLinkList类型的，也就是数组中的每一个元素是一个链表
    private int size;//表示共有多少条链表
    //构造器：
    public HashTab(int size) {
        this.size=size;
        //初始化
        empLinkedListsArrsy=new EmpLinkedList[size];

        //在这记得分别初始化每一个链表；不然会出现空指针异常
        for (int i = 0; i <size ; i++) {
                empLinkedListsArrsy[i]=new EmpLinkedList();
        }
    }

    //添加雇员：节点
    public void addEmp(Emp emp){
        //根据雇员的id，得到员工应该添加在那个链表中
        int emLinkedListNum=hasFun(emp.id);

        //将emp雇员添加到对应的链表中
        empLinkedListsArrsy[emLinkedListNum].add(emp);
    }

    //遍历所有的链表;遍历我们的哈希表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListsArrsy[i].list(i);
        }
    }
    //根据输入的id查找雇员
    public void find(int id){
        //使用散列函数确定在那条两边进行查找
        int emLinkListNum=hasFun(id);
            Emp emp=empLinkedListsArrsy[emLinkListNum].find(id);

            if(emp!=null){
                //找到
                System.out.println("在第"+emLinkListNum+"条链表找到"+emp.id);
            }else {
                System.out.println("没有找到该员工");
            }
    }

    //编写散列函数，使用一个简单的取模法
    public int hasFun(int id){
        return id%size;

    }
}

//表示一个雇员：相当于一个节点
class Emp{
    public int id;
    public String name;
    public Emp next;//默认为null


    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList：表示链表
class EmpLinkedList {
    //头指针，指向第一个雇员，因此我们的head是直接指向第一Emp(雇员)
    private Emp head;//默认null

    //添加员工到链表
    /*说明：
    * 1：假定，雇员你的id是自增长的，也就是id是从小到大的
    *    可直接将雇员添加到链表后*/
    public void add(Emp emp) {
        if (head == null) {
            head = emp;//如果是第一个雇员，直接插在头的后面
            return;
        }

        //如果不是第一个雇员，则使用一个辅助的指针  ，帮助定位到最后
        Emp cur = head;
        while (true) {
            if (cur.next == null) {//说明已经到链表的最后一位了
                break;
            }
            cur = cur.next;
        }

        //退出循环时，已经在最后一位了，直接将员工的节点加进
        cur.next=emp;
    }

    //遍历链表：输出雇员信息
    public void list(int i){
        if(head==null){
            System.out.println("第"+i+"条链表为空");
            return;
        }

        //如果链表不是为空的
        System.out.print("第"+i+"链表的信息为：");
        Emp cur=head;
        while (true){
            System.out.printf("id=%d name=%s\t",cur.id,cur.name);
            if(cur.next==null){
                break;
            }
            cur=cur.next;
        }
        System.out.println();
    }

    //根据id查找：
    //如果查找到，就返回emp，否则返回null
    public Emp find(int id){
        //判断链表是否为null
        if(head==null){
            //链表是null
            return null;
        }

        //辅助指针：
        Emp cur=head;
        while (true){
            if(cur.id==id){
                break;
            }
            if(cur.next==null){//当链表遍历完啥都没有找到直接将cur赋值null，退出大循环
                cur=cur;
                break;
            }
            cur=cur.next;
        }
        return cur;
    }
}