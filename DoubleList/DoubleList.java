package List;
//不带头的双向链表的节点是由三个域组成：data(数据域);prev(前驱);next(后继)
class DoubleListNode{
    public int data;
    public DoubleListNode prev;//前驱
    public DoubleListNode next;//后继
    public DoubleListNode(int data){//一个参数的构造方法
        this.data=data;
       /* this.prev=null;
        this.next=null;*///也可以不用进行初始化，因为prev和next都是引用类型的，默认为null
    }
}
public class DoubleList {
    public DoubleListNode head;//头
    //不初始化也是可以的
    /*public DoubleList(){
        this.head=null;
    }*/
    public DoubleListNode last;//尾

    //头插法:
    public void addFirst(int data) {
        DoubleListNode node = new DoubleListNode(data);
        //1:第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;//新的前驱改变
        }
    }

    //尾插法:
    public void addLast(int data) {
        DoubleListNode node = new DoubleListNode(data);
        //1：是否第一次插入：
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;//新的尾结点改变
        }
    }

    //求链表的长度
    public int getLength() {
        DoubleListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印链表:
    public void disPlay() {
        if (this.head == null) {
            return;
        }
        DoubleListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //博锅：
    private DoubleListNode searchIndex(int index) {
        DoubleListNode cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("下标越界，插入位置不合法");
            //return false;//即插入位置不合法
        } else {
            DoubleListNode cur = searchIndex(index);
            if (cur == this.head) {//在头插入,采用头插法
                addFirst(data);
            } else if (cur == this.last) {//在尾巴进行插入
                addLast(data);
            } else {
                DoubleListNode node = new DoubleListNode(data);
                cur.prev.next = node;
                cur.prev = node;
                node.next = cur;
            }
        }
        return true;
    }

    //自己：
 /*   public void disPlay1(DoubleListNode Head){
        if(Head==null){
            return;
        }
        DoubleListNode cur=Head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //任意位置插入
    public DoubleListNode searchIndex(int index){
        DoubleListNode node=new DoubleListNode(-1);
        DoubleListNode cur=this.head;
        if(index<0||index>getLength()){
            return null;//无法插入
        }
        if(this.head==null){
            return null;
        }//无法插入
        while (index>0){
            cur=cur.next;
            index--;
        }
        cur.prev.next=node;
        cur.prev=node;
        node.next=cur;
        return this.head;
    }*/
    //删除：1：头
    //2：尾
    //3：中间
    //删除第一次出现key的节点
    public int remove(int key) {
        int oldData = -1;//存储要删除的节点
        DoubleListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                oldData = cur.data;
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return oldData;
                } else {
                    cur.prev.next = cur.next;//头已确定
                    //cur.next.prev = cur.prev;害怕是尾巴节点
                    if (cur.next != null) {//不是尾巴
                        cur.next.prev = cur.prev;
                    } else {
                        //删除的是尾巴的时候：
                        this.last = cur.prev;
                    }
                    return oldData;
                }
            }
            cur = cur.next;
        }
        return -1;
    }

    //删除所有data域为key的
    //思想：让他一直删除（链表遍历完）即可；不用进行返回
    public void removeAll(int key) {
        int oldData = -1;//存储要删除的节点
        DoubleListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                oldData = cur.data;
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;//头已确定
                    //cur.next.prev = cur.prev;害怕是尾巴节点
                    if (cur.next != null) {//不是尾巴
                        cur.next.prev = cur.prev;
                    } else {
                        //删除的是尾巴的时候：
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //防止 内存泄漏
    public void clear() {
        while (this.head != null) {
            DoubleListNode cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        this.last = null;//最后还有一个last引用着了
    }
}
