package com.dataStrcture;
//约瑟夫环问题：可以利用单向循环链表（生动）和数组取模运算
/*（一）：单向循环链表的解题思路：
* 1·创建单向循环链表
  * 1.1·先创建一个新的节点，first变量指向该节点，并自身形成环形
  * 1.2·后面每创建一个新的节点，将节点加入环形链表中即可
* 2·遍历单向循环链表
  * 2.1·先去一个辅助变量cur指向first，让其遍历单链表
  * 2.2·直到cur.next==first的时候，单向循环链表才算遍历完
* 3·小孩出圈的一个思路：
  * 3.1·first(在循环链表的第一个元素)和helper指针(在循环链表的最后一个元素)
  * 3.2·first=first.next;   helper.next=first;即可完成出圈*/

//创建节点类：Node
class Node{
    public int no;//编号
    public Node next;//一个节点的next域,默认为null

    public Node(int no) {
        this.no = no;
    }
}

//创建一个单向的环形链表：
class CircleSingleList{
    //创建一个first节点，当前没有编号
    public Node first=new Node(-1);
    public void addNode(int nums){//表示你自己要创建多少个节点
        //进行一个nums校验：
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }

        //否则适使用一个循环 将其单向循环链表做成12345......等等的链表：
        //因为要用到辅助指针，所以先将辅助指针进行定义
        Node curBoy=null;
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Node boy=new Node(i);
            //如果是第一个节点，将first指针指向该节点：
            //1·将第一个节点自身也构建成一个环状
            if(i==1){
                first=boy;
                first.next=first;//将第一个节点自身构成环装
                curBoy=first;//因为first是不能动的，所以用curBoy有关，用其构造单向循环链表
            }else {
                curBoy.next=boy;
                boy.next=first;
                curBoy=boy;
            }
        }
    }

    //遍历啊当前环形链表：也要使用一个辅助变量将其循环遍历即可
    public void showCircleSingleList(){
        //判断单链表是否为空
        if(first==null){
            System.out.println("单向循环链表为空");
            return;
        }

        //创建一个辅助变量遍历循环单链表,因为first是不能变的
        Node curBoy=first;
        while(true){
            System.out.println("显示当前小孩的编号："+curBoy.no);
            if(curBoy.next==first){//说明单向循环链表遍历完了
                break;
            }
            curBoy=curBoy.next;//将curBoy进行遍历往后移动

        }
    }

    //根据用户的输入，计算小孩出圈的顺序
    /*
    * startNum：表示第几个小孩开始数
    * countNum：表示数几下
    * nums：表示刚开始有多少小孩在圈里*/
    public void countNode(int startNum,int countNum,int nums){
        //先对用户输入的数据进行检验
        /*
        * first==null说明这个循环链表为空，没有意义
        * startNum<1：说明不可能从第0个孩子开始，因为么有第0个孩子
        * startNum>nums：说明不可以超过nums个小孩，本来就只有5个小孩，非要从第六个小孩开始*/
        if(first==null||startNum<1||startNum>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        //创建辅助指针，帮助出圈
        Node helper=first;
        //先让helper指向循环单链表的最后一个节点
        while(true){
            if(helper.next==first){
                break;
            }
            helper=helper.next;
        }//跳出循环的时候就是，helper在循环单链表最后一个位置

        //报数前，得先让first和helper走startNum-1步,走到用户让开始的地方
        for(int j=0;j<startNum-1;j++){
            first=first.next;
            helper=helper.next;
        }
        //出圈时，让first和helper先走k-1步也就是（countNum-1步）
        //这是一个循环的操作：
        while(true){
            if(helper==first) {//说明圈中只有一个人，直接出圈即可
                break;
            }

            //让first和helper同时走countNum-1步
            for (int i = 0; i <countNum-1 ; i++) {
                first=first.next;
                helper=helper.next;
            }//这时候first指向的就是要出圈的小孩
            System.out.println("小孩出圈的序号为："+first.no);

            //这时将first指向的小孩出圈
            first=first.next;
            helper.next=first;
        }
        System.out.println("最后留在圈中的小孩序号："+first.no);
    }
}
public class Josepfu {
    public static void main(String[] args) {
        //测试构建环形链表是否成功，遍历也是否成功
        CircleSingleList circleSingleList=new CircleSingleList();//默认是无参构造器
        circleSingleList.addNode(5);
        circleSingleList.showCircleSingleList();

        //测试小孩出圈的顺序：
        circleSingleList.countNode(1,2,5);


    }
}
