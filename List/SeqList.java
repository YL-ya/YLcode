package List;
import java.util.Arrays;
//顺序表是基于数组实现的；不管是物理内存还是逻辑雷村都是连续的
public class SeqList {
    public int[]elem;
    public int usedSize;//存放顺序表的大小
    public final int CAPACITY=10;//定义顺数表的容量是10
public  SeqList() {
    this.usedSize = 0;//无参的构造方法对数组及其变量进行初始化
    this.elem = new int[CAPACITY];
    System.out.println("无参构造");
}
//1：进行插入：
    //首先得判断顺序表是否为满即usedSize==length();???
public boolean isFull(){
    if(usedSize==elem.length){
        return true;//顺序表满了
    }else {
        return false;
    }
}
//插入：在pos位增加新元素
    public void add(int pos,int data) {
        //首先就是判断顺序表是否为满,若满了就对顺序表进行扩容
        //容采用Arrays.copyOf();方法进行数组的拷贝扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);//对顺序表的数组进行扩容
        }
        //其次判断插入位置合不合法pos
        if (pos < 0 || pos > usedSize) {//等于usedSize时，还有一个可以插入的
            //System.out.println("插入位置不合法");
            //可以抛出异常
            throw new IndexOutOfBoundsException("pos位置不合法");
        }
        //合法且没有满执行插入数据
        for (int i = this.usedSize-1; i >= pos; i--) {//遍历数组,将pos位置的数据依次往后挪
            this.elem[i + 1] = this.elem[i];
        }
        //插入数据：
        this.elem[pos] = data;
        this.usedSize++;//插入后一定记得将表即顺序表大小的变量改变
    }
//2：判定是否包含某个元素
    //思想：遍历整个顺序表，进行匹配即可
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize - 1; i++) {
            if (toFind ==this.elem[i]) {
                return true;
            }
        }
        return false;//遍历完整个数组都没有找到，返回false即可
    }
//3：查找某个元素对应的位置
    //思想：1:首先得判断顺序表是否为空，为空直接返回的是找不到
            //为空就是usedSize==0的时候
        // 2：找到顺序表中的值相匹配返回下标即可
    public boolean isEmpty() {
        if (this.usedSize == 0) {
            return true;
        } else {
            return false;
        }//return this.usedSize=0;
    }
    public int search(int toFind) {
        if (isEmpty()) {
            return -1;
        }//顺序表为空的情况下
        for (int i = 0; i < this.usedSize - 1; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;//顺序表都走完了还么有访问到即就是没有找到
    }
//4：获取pos位置的元素：
    //思想：1：判断pos给的位置是否是合法的
          //2：遍历顺序表直接返回该位置下的顺序表的值
    public int getPos(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            return -1;//顺序表为空无法返回该pos下的值
        } else {
            return this.elem[pos];//顺序表不为空直接返回当下的顺序表中的值
        }
    }
//5：获取顺序顺序表的长度
    public int size() {
        return this.usedSize;//usedSize呢吗来就是记录顺序表的长度和大小的
    }
//6：清空顺序表：即将usedSize赋值为0
    public void clear() {
        this.usedSize = 0;
    }
//7：打印顺序表：循环遍历打印即可
    public void disPlay() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }
//8：删除第一次出现的元素key
    //思想：1：判断顺序表是否为空
    //2：查找要删除的下标
    //3：删除该元素
    public void remove(int toRemove) {
        if (isEmpty()) {
            return;//顺序表为空的时候
        }
        int index = search(toRemove);//找到值返回的下标
        if (index == -1) {
            System.out.println("没有找到你要的");
            return;//没有找到
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;//删除了之后一定将表示顺序表长度的变量改变
    }
}

