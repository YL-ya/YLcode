package lesson2;
//yield：让步，将当前线程的运行态转变成就绪态
public class ThreadYield {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        }).start();
        while (Thread.activeCount()>1){//获得当前线程的活跃线程数
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName());

    }
}
