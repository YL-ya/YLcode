package List;
//顺序表：
//优点：随机查找(pos)得到一个数的复杂度是O(1);随机插入一个数的复杂度是O(n);随机删除也是O(n)
//缺点：扩容：需要把原来素组拷贝过来，放不下要进行2倍扩容；内存浪费，资源浪费
public class TestSeqList {
    public static void main(String[] args) {
        SeqList list=new SeqList();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        list.add(0,4);
        list.add(0,5);
        list.add(0,6);
        list.disPlay();
        System.out.println();
      /*  System.out.println(list.search(4));
        System.out.println(list.contains(8));
        System.out.println(list.getPos(4));
        System.out.println(list.size());
        list.remove(2);
        list.disPlay();*/
        System.out.println("===============");
        list.clear();
        list.disPlay();

    }
}
