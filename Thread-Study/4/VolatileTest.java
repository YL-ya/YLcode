package lesson4;

//volatile：共享变量，也就是相当于一个常量；满足线程的可见性和顺序性，但是不能满足原子性

/*可见性：就是运行时都在主存中读取的，而不是每一个自己的工作内存
* 1：volatile因为不能满足原子性，所以n++,n--等等这样的线程是不安全的
* 2：volatile对变量进行赋值操作的时候，不能依赖变量(常量的话可以保证安全)，变量的话是共享变量，线程还是不安全的
* 适应场景：
* volatile可以结合线程的一些加锁手法，提高线程的效率
* 常量赋值/读取变量的值是不用进行加锁；赋值的时候需要进行加锁*/

public class VolatileTest {
    //同时启动20个线程，每个线程对同一个变量执行操作；循环10000次
    private static final int COUNT = 10000;
    private static final int NUM = 20;//定义成全局变量
    private volatile static int SUM;//int类型的值在-128~127存放在方法区，超过该范围的就存在堆中

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //线程可以并发和并行
                    for (int j = 0; j < COUNT; j++) {
                        SUM++;
                        /*SUM++分成了三条指令，在这些指令运行的期间是可以插入其他的线程的
                        * 1：读取主存中的SUM变量
                        * 2：SUM=SUM+1
                        * 3：写回主存*/
                    }
                    /*for (int j = 0; j <COUNT ; j++) {
                        SUM--;
                    }*/
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        /*1：结果不是预期的20000
         * 2：每次运行的结果都不一样*/
        System.out.println(SUM);
    }
}
