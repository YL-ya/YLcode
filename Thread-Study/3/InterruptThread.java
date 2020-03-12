package lesson3;
//线程的中断
/*特点：
* 1：线程启动后会有一个中断标志位=false
* 2：在线程运行态的时候，处理中断，是要判断中断标志位的，来处理中断:通过以下两种方法进行判断：
*    thread.isInterrupted()或者Thread.interrupted
* 3：当线程处于阻塞态的时候调用wait()/sleep()/join()，将线程中断，会造成：
     * 1：在阻塞方法所在的代码行直接抛出异常
     * 2：抛出异常之后，重置标志位：true */
public class InterruptThread {
    //中断一个线程，但是线程没有处理中断，也就是中断的选择权在线程的手中
    public static void test1() {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                }
            }
        });
        t.start();
        t.interrupt();//想要中断t线程，但是中断没有给予采纳；也就是说不理睬，while循环继续工作(t线程)
    }

    public static void test2(){
        // 表达的意思：当线程成运行态的时候，(需判断中断标志位)对中断做出的回应
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                /*for (int i = 0; i <50 ; i++) {
                    System.out.println(i+"="+Thread.currentThread().isInterrupted());
                }*/
                //线程中处理中断
                //while(!Thread.currentThread().isInterrupted()){//在这判断线程有无中断
                while(!Thread.interrupted()){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        t.start();//初始化的时候中断标志位是false
        t.interrupt();//说明线程先运行的是interrupt方法，才运行的run方法；并且在这里将中断标志位改成true
    }

    public static void test3(){
        //表达的意思：当线程成阻塞态的时候，对中断处理做出的响应(直接抛出异常)，通过捕获和处理异常来对中断做出响应
        //抛出异常：当线程在阻塞态的时候，代码执行中断命令的时候直接抛出异常，也就是说中断(不执行)要休眠的状态
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                //先进行休眠：
                try {
                    System.out.println(Thread.interrupted());//true
                    Thread.sleep(3000);//线程调用wait()/join()/sleep()阻塞的时候，
                                             // 如果把当前线程中断会直接抛出一个异常
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.interrupted());//false：阻塞状态的线程在捕获异常的时候，
                                                             // 中断标志位会被重置
                }
            }
        });
        t.start();//在main线程中开启新的线程，中断标志位是false
        t.interrupt();//在main线程执行t线程的中断，中断标志位是true；然后才会去执行run方法中的实例代码
    }

    public static void test4(){
        //测试静态方法：Thread.interrupted()和实例方法：Thread.currentThread().isInterrupted()的区别
        /*区别：静态：static void interrupted()；实例：void isInterrupted()
        * 静态方法：Thread.interrupted()：返回当前线程的中断标志位，并重置中断标志位(1个true，9个false)
        * 实例方法：Thread.currentThread().isInterrupted()：只是返回中断的标志位，不会进行重置标志位(10个true)*/
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    /*System.out.println(Thread.interrupted());*/
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t.start();
        t.interrupt();

    }

    //自定义一个中断标志位：缺陷：只能满足线程处于运行态的中断操作，满足不了线程处于阻塞状态的中断操作
    //所以一般使用系统提供的API不要用自定义的
    public static volatile boolean ISINTERRUPTED;//设置成两个线程共享的
    public static void test5(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                /*while (!ISINTERRUPTED){
                    System.out.println(Thread.currentThread().getName());
                }*/
                try {
                    Thread.sleep(50000L);
                } catch (Exception e) {
                    e.printStackTrace();//运行这段大妈的时候，线程处于休眠状态，没有抛出异常，直接不理
                }
            }
        });
        t.start();
        ISINTERRUPTED=true;
    }

    public static void main(String[] args) {
       /* test1();
        test2();*/

        //test3();
        //test4();

        test5();
    }
}
