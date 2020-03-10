package lesson2;
//守护线程;
/*java进程的退出：
* 1：至少有一个非守护线程没有被销毁，进程就不会退出
* 2：一般来说非守护线程我们称之为工作线程，守护线程我们称之为后台线程
* 总结：也就是当进程中没有非守护线程(没有工作的线程)，整个进程就退出了*/
public class DaemonThread {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置t线程为守护线程,而当是非守护线程的话，条件就不满足了，就会退出
        t.setDaemon(true);//进程不会继续休眠等待，而是直接的退出了

        t.start();
    }
}
