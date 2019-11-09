package List;
public class TestDoubleList {
    public static void main(String[] args) {
        DoubleList list=new DoubleList();
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(4);
        list.disPlay();
/*        list.addIndex(2,3);
        list.disPlay();*/
        System.out.println("=========");
       /* list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.disPlay();*/
       /* DoubleListNode newHead=list.searchIndex(2);
        list.disPlay1(newHead);*/
        /*int a=list.remove(3);
        System.out.println(a);
        list.disPlay();*/
      /*  list.removeAll(4);
        list.disPlay();*/
    }
}
