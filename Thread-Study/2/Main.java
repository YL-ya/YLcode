package lesson2;
//创建线程
public class Main{
    public static void main(String[] args) {
        //创建线程方式1：
        MyThread myThread=new MyThread();
        //myThread.start();//Thread-0线程
        myThread.run();//main线程

        /*注意：run方法是直接调用，不会启动线程的，也就是说在main线程中不会开启新的线程，只会在当前main线程中调用run方法
        *       start方法是开启一个线程，然后才会在开启的线程中入调用run方法*/


        /*
        创建线程方式2：
        new MyThread().start();//方法1的调用
        new Thread(new MyRunnable()).start();//方法2的调用
        //线程启动是通过start方法进行启动的*/


        //
    }
}

//方法1：创建线程
 class MyThread extends Thread {
    @Override
    public void run() {//run是线程运行的时候执行的代码块
        //代码：
        System.out.println(Thread.currentThread().getName());
    }
}

//方法2：创建线程
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}