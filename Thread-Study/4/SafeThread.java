package lesson4;
//synchronized：再调用这个的时候，在底层会判断是否是同一个对象，并对实现代码的类进行加锁
/*加锁重点
* 1：对一个对象进行加锁，一个对象只有一把锁
* 2：只有对同一个对象进行加/还锁，才会产生互斥的作用(也就是说这样多线程的三个特性都能满足，保证了线程的安全性)
* 3：也就是说在synchronized(){代码}，中的代码来说，同一时间点，只有一个线程运行*/


public class SafeThread {
    //同时启动20个线程，每个线程对同一个变量执行操作；循环10000次
    private static final int COUNT = 10000;
    private static final int NUM = 20;//定义成全局变量
    private static volatile int  SUM;//int类型的值在-128~127存放在方法区，超过该范围的就存在堆中

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //线程可以并发和并行
                    for (int j = 0; j < COUNT; j++) {
                        //increment();
                        //synchronized (SafeThread.class){
                        synchronized (getClass()){//获得当前对象的类，也就是this.getClass()
                        //synchronized (this){
                            SUM++;
                            /*if(SUM<=100000) {
                            SUM++;
                            }*/
                        }
                    }

                    /*for (int j = 0; j < COUNT; j++) {
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

    //方法1相当于方法2的操作
    public static synchronized void  increment1() {//加锁都是对当前类上面进行加锁
        SUM++;
    }
    public void increment2(){
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //线程可以并发和并行
                    for (int j = 0; j < COUNT; j++) {
                        synchronized (SafeThread.class) {
                            SUM++;
                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }

    //方法3和方法4是一样的
    public synchronized void increment3(){
        SUM++;
    }
    public void increment(){
        synchronized (this) {
            SUM++;
        }
    }
}
