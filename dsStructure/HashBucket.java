package com.dataStrcture;

//哈希桶-->数组+链表实现的：作用：帮助用户快速的定位要将元素插入到那个链表，来组织链表
//数组中存储的元素是首元素节点地址也就是引用
public class HashBucket {
    //1：定义链表的节点
    public static class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
        }
    }

    //2：定义哈希桶中的成员
    Node[]table;
    int capacity;//表格的容量或者是桶的个数
    int size;//表示有效元素的个数
    double loadFact=0.75;//负载因子：用来判断是否进行扩容的
    /*扩容：设置一个更大的哈希桶，将原来的搬移过去即可*/

    //哈希桶的构造方法
    public HashBucket(int initcap){
        //保证哈希桶的初始容量至少为10个
        capacity=initcap;
        if(initcap<10){
            capacity=10;
            table=new Node[capacity];
            size=0;
        }
    }

    public int put(int key,int value){
        resize();
        //1：先通过哈希函数，计算出key的桶号
        int bucketNo=hashFuc(key);

        //2：在bucketNo桶中查找key是否存在该元素
        //检测方式：遍历链表：一般哈希表中的元素是不会全部挂在一个位置的
        Node cur=table[bucketNo];
        while (cur!=null){
            if(cur.key==key){
                int oldValue=cur.value;
                cur.value=value;
                return oldValue;
            }
            cur=cur.next;
        }

        //3：key不存在，将key-value插入到哈希桶中去
        cur=new Node(key,value);
        cur.next=table[bucketNo];
        table[bucketNo]=cur;
        size++;
        return value;
    }

    //删除节点：
    public boolean remove(int key){
        //1:通过哈希函数计算key所对应的节点
        int bucketNo=hashFuc(key);
        
        //2：找到key所对应的节点：
        Node cur=table[bucketNo];
        Node prev=null;
        while (cur!=null){
            if(cur.key==key){
                //找到了与key所对应的节点，将该节点删除
                if(prev==null){
                    //如果删除的是第一个节点，直接将next进行赋值即可
                    table[bucketNo]=cur.next;
                }else {
                    //删除的是其他节点：
                    prev.next=cur.next;
                }
                --size;
                return true;
            }else {
                prev=cur;//在cur往后走之前，用prev进行标记一下
                cur=cur.next;
            }
        }
        return false;
    }

    //时间复杂度O(1)
    public boolean containsKey(int key){
        //1:计算key所在的桶号：
        int bucketNo=hashFuc(key);

        //2：在bucketNo桶中找key
        Node cur=table[bucketNo];
        while (cur!=null){
            if(cur.key==key){
                return true;
            }
            else {
                cur=cur.next;
            }
        }
        //循环完了都没有找到，说明不包含：
        return false;
    }

    //时间复杂度：O(n^2)
    public boolean containsValue(int value){
        //咱们的哈希桶是根据key来计算哈希桶的地址的：
        //因此找value的话，不能计算出value是放在哪个桶中的
        //所以在找value的时候必须遍历所有的桶
        for (int bucketNo=0;bucketNo<capacity;bucketNo++){//取得是下一个桶
            Node cur=table[bucketNo];
            while (cur!=null){
                if(cur.value==value){
                    return true;
                }
                cur=cur.next;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return 0==size;
    }

    //扩容：
    private void resize(){
        if(size*10/capacity>loadFact*10){//负载因子超过0.75就要记性扩容，按照两倍的方式进行扩容
            int newCapacity=capacity*2;
            Node [] newTable=new Node[newCapacity];

            //将table里面的节点搬移到newTable去
            for (int i = 0; i <capacity ; i++) {
                Node cur=table[i];
                while (cur!=null){
                    table[i]=cur.next;

                    //将cur的节点插入到newTable中去：
                    //1：计算cur在newTable中的桶号
                   // int bucketNo=hashFuc(cur.key);//这个方法是不行的，因为hashFac使用的旧表格的容量
                    int bucketNo=cur.key%newCapacity;

                    //2：将cur插入到newTable中去
                    cur.next=newTable[bucketNo];
                    newTable[bucketNo]=cur;

                    //3：取table中的i号桶的下一个节点
                    cur=table[i];
                }
            }
            table=newTable;
            capacity=newCapacity;
            //不会改变元素的个数，只将桶的个数进行扩容而已
        }
    }
    //哈希函数咱们给一个私密的，不让别人知道怎么进行插入的
    private int hashFuc(int key){//用哪个除留余数法
         return key%capacity;
    }

    public void printHashBucket(){
        for(int bucketNo=0;bucketNo<capacity;bucketNo++){
            System.out.printf("table[%d]-->",bucketNo);
            Node cur=table[bucketNo];
            while (cur!=null){
                System.out.print("["+cur.key+","+cur.value+"]");
                cur=cur.next;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        HashBucket ht=new HashBucket(5);
        ht.put(1,1);
        ht.put(11,11);
        ht.put(2,2);
        ht.put(33,33);
        ht.put(6,6);
        ht.put(5,5);
        ht.put(51,51);
        ht.put(8,8);
        System.out.println("size="+ht.size());
        ht.printHashBucket();

        //验证扩容
        ht.put(3,3);
        ht.printHashBucket();

        System.out.println(ht.containsKey(5));
        System.out.println(ht.containsValue(15));

        ht.remove(5);
        System.out.println(ht.containsKey(5));
        ht.printHashBucket();
    }
}
