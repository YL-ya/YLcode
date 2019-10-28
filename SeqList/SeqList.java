import java.util.Arrays;
/*顺序表就是基于数组实现的
不管是物理内存还是逻辑内存都是连续的*/
public class SeqList {
    public int[] elem;
    public int usedSize;
    public final int CAPACITY = 10;

    public SeqList() {
        this.usedSize = 0;//对数组及其变量进行初始化
        this.elem = new int[CAPACITY];
        System.out.println("无参的构造方法");

    }

    @Override
    public boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return false;
        } else {
            return true;
        }
    }

    //在pos位新增元素
    public void add(int pos, int data) {
// 1：判断顺序表是否为满，若满了就进行扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);//数组进行扩容
        }
// 2：判断插入的为值是否合法pos
        if (pos < 0 || pos > usedSize) {
            //System.out.println("pos位置不合法");
            //return;
            throw new IndexOutOfBoundsException("pos位置不合法");
        }
// 3：合法且没满执行插入数据
        for (int i = this.usedSize - 1; i >= pos; i--)//从后面开始挪动数据,因为pos的位置也要挪动
        {
            this.elem[i + 1] = this.elem[i];
        }
//插入数据：
        this.elem[pos] = data;
        this.usedSize++;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
//思想：就是遍历整个顺序表进行匹配
        for (int i = 0; i < usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
//遍历完整个顺序表都没有找到
        return false;
    }

    //查找某个元素对应的位置
//思想：1：判断是个空的顺序表，若是空的直接返回-1
//      2：进行元素的匹配返回下标即可

    @Override
    public boolean isEmpty() {
        if(this.usedSize==0){
            return false;//证明顺序表是空
        }else{
            return true;
        }
    }

    public int search(int toFind){
        if(isEmpty()) {
            return -1;//顺序表为空，也就是没找到
        }
        for (int j = 0; j < usedSize; j++) {
            if(this.elem[j]==toFind){
                return j;
            }
        }
        return -1;//顺序表都遍历完了都没有，也就是没找到
    }

    //获取 pos 位置的元素
    public int getPos(int pos){
//若pos的位置不合法，即没法返回元素；即返回-1
        if(pos<0||pos>this.usedSize){
            return -1;
        }else{
            return this.elem[pos];//直接返回数组里面的值
        }
    }
}

