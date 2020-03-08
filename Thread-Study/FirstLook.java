package lesson1;

public class FirstLook {
   /* public static void main(String[] args) throws InterruptedException {
        Thread.sleep(999999999999L);//当前线程进入休眠状态
    }*/

    public static void main(String[] args) {

        /*说明：
        * 1：new Thread(new Runnable()){.....}：创建Thread-0线程
        * 2：.start()：Thread-0线程由创建态转变成就绪态，等待系统进行调度，调度到称为运行态(执行run()方法中的代码)*/

        /*线程该执行的代码：注意：java中的main线程是可以退出的，但是系统C语言中的main线程是不能退出的
        * java main线程执行的代码：
        * 1：new 创建线程
        * 2：.start()启动线程
        * 3：退出main线程 ：也就说明上面的那个是有main线程，该代码main线程调度完了之后就退出了
        * Thread-0线程执行的代码：
        * 1：run方法中的代码*/
        new Thread(new Runnable() {//这里就是匿名内部类，在这里新创建了一个线程，但是还没有启动
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();//线程启动
    }
}
