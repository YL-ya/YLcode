package lesson3;
//线程安全问题：对同一个代码会出现不同的结果
/*原因：
* 1：原子性：语句都要成功，要么都失败
    * 特殊的语句：n++，n--，--n，++n看着是一句话，但是在底层分解执行
    * 1：从内存中读取变量到CPU
    * 2：CPU中修改变量
    * 3：写回内存中
* 2：可见性：主内存→工作内存→主内存：存在一个写回操作：*/
public class UnsafeThread {
    //同时启动20个线程，每个线程对同一个变量执行操作；循环10000次
    private static final int COUNT=10000;
    private static final int NUM=20;//定义成全局变量
    private static int SUM;//int类型的值在-128~127存放在方法区，超过该范围的就存在堆中

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //线程可以并发和并行
                    for (int j = 0; j <COUNT; j++) {
                         SUM++;
                    }
                    for (int j = 0; j <COUNT ; j++) {
                        SUM--;
                    }
                }
            }).start();
        }

        while(Thread.activeCount()>1){
            Thread.yield();
        }

        /*1：结果不是预期的20000
        * 2：每次运行的结果都不一样*/
        System.out.println(SUM);
    }
}
