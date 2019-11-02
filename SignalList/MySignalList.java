package List;
//节点类
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
//单链表类
class MySignalList {
    public ListNode head;//用来保护那的单链表的头

    //无参构造方法
    public MySignalList() {
        this.head = null;
    }

    //1：头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);//要插入的节点，进行初始化
        // 1.是否是第一次插入：因为head直接给插进去的第一个节点 不用再写node.next=head
        if (head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //2：尾插法:思想：要找到单链表的尾巴
    public void addLast(int data) {
        ListNode node = new ListNode(data);//初始化一个节点
        ListNode cur = this.head;
        if (head == null) {//单链表是空
            this.head = node;
        } else {
            while (cur.next != null) {//cur.next==null 说明是最后一个节点
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //3：打印单链表
    public void disPlay() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //4：查找是否包含关键字key
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            } else {
                cur = cur.next;//进行下一个节点的查找
            }
        }
        return false;//单链表都遍历完了都没有找到即跳出循环，返回false
    }

    //5：求单链表的长度
    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //6：找到index-1的位置,即cur的前驱
    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        //cur→index-1
        int count = 0;
        while (count < index - 1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    //7：任意位置插入，第一个数据节点为0 号下标
    public boolean addIndex(int index, int data) {
        //1:判断插入的位置是否是合法的
        if (index < 0 || index > getLength()) {
            System.out.println("插入位置不合法");
            return false;
        }
        //2:当单链表为空的时候
        if (index == 0) {
            addFirst(data);//单链表为空的时候进行头插和尾插都是一样的
            return true;
        }
        //3:任意位置进行插入：先要找到前驱，因为单链表是单向的，所以要找到插入的前一项即index-1
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    //8：查找key的前驱
    private ListNode searchPrev(int key) {
        ListNode prev = this.head;
        //最后一个节点，且头节点已经判断过了
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            } else {
                prev = prev.next;
            }
        }
        return null;
    }

    //9：删除第一次出现关键字为key的节点
    public void remove(int key) {
        //0:单链表为空的时候
        if (this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //1:删除的是头结点 直接就是head=head.next;
        if (this.head.data == key) {
            this.head = this.head.next;
            return;//只删一个
        }
        //2:找到关键字key的前驱
        ListNode prev = searchPrev(key);
        if (prev == null) {
            return;
        } else {
            ListNode del = prev.next;
            prev.next = del.next;
        }
    }

    //10：删除所有关键值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        ListNode prev = this.head;
        ListNode cur = prev.next;//这样就可以一直知道cur的前驱是什么
        //头会漏掉，所以在循环遍历单链表之后再判断一次头就可以了
        while (cur != null) {
            if (prev.next.data == key) {
                prev.next = cur.next;//删除这个节点
                cur = cur.next;//因为prev.next已经被删除了，所以prev不能再走了，只能是cur在走
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {//判断头部是要删除的节点
            this.head = this.head.next;
        }
    }

    //11：翻转单链表：1：记录一个点然后进行头插法：简单明了
    //2：定义四个引用cur curNext(保存头置null) prev(保存好前驱) newHead
    public ListNode reverseList() {
        ListNode cur = this.head;
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void disPlay1(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //12：返回链表的中间结点
    //1：定义cur走getlength/2的步数：遍历了单链表两次，虽然最后之遍历了单链表半截
    //2：定义快慢指针：速度2倍
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {//fast!=null是两个结点的时候，若无会出现空指针异常
            fast = fast.next.next;
            slow = slow.next;//fast走两步，slow走一步
        }
        return slow;//即slow是中间结点
    }

    //13：倒数第k个节点
    //1：定义一个引用走单链表长度-k步即(length-k)
    //2：定义快慢指针,快的先走k-1步，也就是fast和slow就是差了k-1步
    public ListNode findKthTOtail(int k) {
        //判断是否合法-1 和6等等类型
        //k>getLength()  6   fast==null,即可以走一步就判断一下fast是否为空即可
        //if(k<=0||k>getLength())
        if (this.head == null || k <= 0) {//判断空的单链表
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;//还没有退出循环fast就为空了，出现空指针异常
            } else {
                System.out.println("没有这个节点");
                return null;
            }
        }//fast先走了k-1步
        while (fast.next != null) {//fast.next==null就找到了slow//k=1时上面循环进不去！！！！！！！！！！
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
//课堂练习
  /*  public ListNode reverse1() {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
        if (head == null) {
            return null;
        }
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public ListNode findKthToTail2(int k) {//倒数第K个节点
        if (head == null || k < 0 || k > getLength()) {
            return null;
        } else {
            ListNode fast = this.head;
            ListNode slow = this.head;
            while (k - 1 > 0) {
                fast = fast.next;
                k--;//fast走了k-1步
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }*/

    //14：给定一个x将大于x 的放在单链表的前面
    public ListNode partition(int x) {
        ListNode cur = this.head;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (cur != null) {
            //cur.data < x
            if (cur.data < x) {
                //第一次插入
                if (beforeStart == null) {
                    beforeEnd = cur;
                    beforeStart = cur;
                } else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;

                }
            } else {//大于x的
                //第一次插入
                if (afterStart == null) {
                    afterEnd = cur;
                    afterStart = cur;
                } else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if (beforeStart == null) {//小于x的链表为空
            return afterStart;
        }
        if (afterStart != null) {
            afterEnd.next = null;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    /*   //15：删除重复的节点：自己
        public ListNode deleteDuplication() {
            ListNode node = new ListNode(-1);
            ListNode cur = this.head;
            ListNode tmp = node;
            while (cur != null) {
                if (cur.next != null &&
                        cur.data == cur.next.data) {
                    //1、循环
                    ListNode cur1 = cur;
                    //不能让它走到尾巴，不然就空指针异常
                    while (cur.next!=null&&cur.data == cur.next.data) {
                        cur = cur.next;
                    }
                    //2、退出循环 cur要多走一步//让他走到尾结点
                    cur = cur.next;
                    //进行删除
                    cur1.next = cur;
                } else {
                    //当前节点 不等于下一个节点的时候
                    tmp.next = cur;
                    cur = cur.next;
                    tmp = tmp.next;
                }
            }
            //temp.next=null;也是可以的
            return node.next;
        }*/

    //删除重复的节点：博锅
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if (cur.next != null &&
                    cur.data == cur.next.data) {
                //1、循环
                while (cur.next != null &&
                        cur.data == cur.next.data) {
                    cur = cur.next;
                }
                //2、退出循环 cur要多走一步
                cur = cur.next;
            } else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = null;
        return node.next;
    }

    //16：链表回文结构
    public boolean chkPalindrome() {
        //1：思想：将后面的进行翻转然后进行陪陪即可
        ListNode fast = this.head;
        ListNode slow = this.head;
        //找到中间位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //只有一个节点的时候,就是回文
        if (this.head == null) {
            return true;
        }
        //循环出来slow的位置就是中间的位置
        //将后半部分进行反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //反转
            p.next = slow;
            slow = p;
            p = pNext;
        }
        while (this.head != slow) {//没有相遇
            if (slow.data != head.data) {
                return false;
                //slow往前    head 往后  .data不一样 返回false
                //直到相遇
            } else {
                if (head.next == slow) {//考虑偶数的情况下
                    return true;
                }
                head = head.next;//头往后走
                slow = slow.next;//尾巴slow往前走
            }
        }
        return true;
    }

    //17：判断链表是否有环
    //思想，定义快慢指针，fast走两步，slow走一步；当fast=slow时，就证明有环
    //1：建成环
    public void creatLoop() {
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }//最后一个节点
        cur = cur.next;
    }

    //判断是否有环
    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        if (this.head == null || this.head.next == null) {
            return false;
        }
        while (fast != null && fast.next != null) {//判断slow是否和fast相等
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //17：找到环的入口
    //思想：定义快慢指针，相遇一次之后，将其中一个指针指向头节点，然后两个指针同时走，直到两个指针相遇
    //该节点就是环的入口
    public ListNode detectCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != slow) {//判断slow是否和fast相等
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        //跳出循环证明第一次相遇
        slow = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }//第二次相遇就是环的入口所在的地方
        return fast;
    }

}





