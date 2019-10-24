public class swap {
    public static void main(String[] args) {
    int []a={47,38};
    swap(a);
        for (int z :a) {
           System.out.println("交换后的数字是：" + z);
       }
    }
    public static void swap(int []b) {//数组的引用(低配版的指针)
        for (int x : b) {
            System.out.println("交换前的数是：" + x);
        }
        for (int i = 0; i < b.length-1; i++) {
            int temp = b[i];
            b[i] = b[i + 1];
            b[i + 1] = temp;
        }
    }
}