package List;
public class TestComplexList {
    public static void main(String[] args) {
        ComplexList oldlist=new ComplexList();
        oldlist.addLast1(9);
        oldlist.addLast1(4);
        oldlist.addLast1(3);
        oldlist.addLast1(7);
        OldListNode newHead=oldlist.copyRandomList(oldlist.addLast1(5));
        oldlist.disPlay(newHead);
    }
}
