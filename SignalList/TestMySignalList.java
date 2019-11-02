package List;
public class TestMySignalList {
    public static void main(String[] args) {
        MySignalList mySignalList1 = new MySignalList();
        MySignalList mySignalList2 = new MySignalList();
        /*mySignalList.disPlay();*/
       /* mySignalList.addFirst(1);
        mySignalList.disPlay();
        System.out.println(mySignalList.chkPalindrome());*/
       /* mySignalList.addFirst(2);
        mySignalList.addFirst(2);
        mySignalList.addFirst(3);
        mySignalList.addFirst(4);
        mySignalList.addFirst(5);
        mySignalList.addFirst(6);
        mySignalList.addFirst(7);//头插法
        mySignalList.disPlay();*/
        mySignalList1.addLast(1);
        mySignalList1.addLast(2);
        mySignalList1.addLast(3);
        mySignalList1.addLast(4);
        mySignalList1.addLast(5);//尾插法
        mySignalList1.disPlay();
        mySignalList2.addLast(3);
        mySignalList2.addLast(4);
        mySignalList2.addLast(5);
        mySignalList2.addLast(6);
        mySignalList2.addLast(7);
        mySignalList2.addLast(8);
        mySignalList2.addLast(8);//尾插法
        mySignalList2.disPlay();
        ListNode NODE = mergeTwoLists(mySignalList1.head, mySignalList2.head);
        mySignalList1.disPlay1(NODE);
        System.out.println(mySignalList2.hasCycle());


    }
       /* ListNode node=getIntersectionNode(mySignalList1.head, mySignalList2.head);
        System.out.println(node.data);
        */

//        System.out.println(mySignalList.chkPalindrome());
     /*   ListNode node=mySignalList.middleNode();
        System.out.println(node.data);
        ListNode node1=mySignalList.findKthTOtail(3);
        System.out.println(node1.data);
        System.out.println(mySignalList.contains(6));
        int length =mySignalList.getLength();
        System.out.println("单链表的长度是："+length);
        mySignalList.addIndex(3,1);
        mySignalList.disPlay();
        mySignalList.remove(4);
        mySignalList.disPlay();
        mySignalList.removeAllKey(5);
        mySignalList.disPlay();
        mySignalList.removeAllKey(12);//单链表中是没有12的所以结果是跟前面的结果是一样的
        mySignalList.disPlay();
        ListNode head=mySignalList.reverseList();//返回了一个节点类型，用节点类型的head接收这个值
        mySignalList.disPlay1(head);*/
     /*   ListNode H=mySignalList.partition(3);
        mySignalList.disPlay1(H);*/
       /* ListNode H1=mySignalList.deleteDuplication();
        mySignalList.disPlay1(H1);*/
     /*   mySignalList.creatLoop();
        System.out.println(mySignalList.hasCycle());
        ListNode huan = mySignalList.detectCycle();
        System.out.println(huan.data);
    }*/

    //19：将两个有序的单链表合并成一个有序的单链表
//思想：创建一个虚拟节点，保存排序好的单链表，同时进行遍历两个单链表，排序完了之后
//还要考虑一定会有一个单链表提前走完
// 自己：
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while (headA != null && headB != null) {//两个单链表同时进行遍历判断
            if (headA.data < headB.data) {
                temp.next = headA;
                headA = headA.next;
                temp = temp.next;
            } else {
                temp.next = headB;
                headB = headB.next;
                temp = temp.next;
            }
        }
        //退出循环是因为其中一个单链表走完了，所以将剩余的单链表表串在后面即可
        if (headA == null) {
            temp.next = headB;
        }
        if (headB == null) {
            temp.next = headA;
        }
        return node.next;
    }
}
//博锅：
  /*  public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        *//*ListNode curA=headA;
        ListNode curB=headB;*//*
        ListNode node = new ListNode(-1);
        ListNode tmp = node;

        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return node.next;
    }
}*/


   /* //18：返回两个单链表的交点
    //创建交点
    public static void createCut(ListNode headA,ListNode headB) {
        headA.next.next = headB.next.next.next;
    }
    //18：返回两个单链表的交点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        ListNode pL = headA;
        //永远指向最短的单链表
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        //分别求长度
        while(pL!=null){
            lenA++;
            pL=pL.next;
        }
        while(pS!=null){
            lenB++;
            pS=pS.next;
        }
        //上面循环走完之后pL和pS都是null
         pL = headA;
         pS = headB;//将头部拉回来不然就在单链表的尾部了
        //求长度的差值
        int len = lenA - lenB;
        //如果是负数-》pL = headB;  pS = headA
        if (len < 0) {
            len=-len;//将长度之差变成正数
            pL = headB;
            pS = headA;
        }
        //只需要让pL走len步就好了
        while (len> 0) {
            pL = pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走
        //考虑一个节点的时候
        while(pL!=pS&&pL!=null){
            pL = pL.next;
            pS = pS.next;
        }
        if(pL==pS&&pS!=null){
            return pL;
        }
        //一直走 走到next值相同时 就是交点
        *//*while (pL.next!=pS.next) {
            pL = pL.next;
            pS = pS.next;
        }
        //没有相交，并且两个单链表是一样长的
        //防止最后一个节点
        if(pL.next==pS.next&&pL.next!=null) {
            return pL.next;//相交的那个点
        }*//*
        return null;
    }*/
