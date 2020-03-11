package lesson2;
//线程的等待：将运行态转变成等待态
public class ThreadJoin {
    public static void without() throws InterruptedException {
        //无参：打印main，然后Thread-0
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();//等待t线程执行完毕
        System.out.println(Thread.currentThread().getName());
    }

    public static void withoutSleep() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join(2000);
        //t线程执行时间2秒钟谁先到，就以这个时间点作为main线程的等待时间点，到了时间点就往下执行
        //也就是说t线程执行完(t线程执行时间比2秒钟快)，就往下继续执行
        System.out.println(Thread.currentThread().getName());
    }

    public static void withSleep() throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        /*1：想要得到的结果是：先执行Thread-0线程
        2：当前线程：代码行执行的时候，所在的线程
        3：t线程：线程的引用对象
        4：当前线程进行阻塞(运行态变成阻塞态)，等待(需满足一定的掉件才能开始进行:比如有等待时间)，
           t线程(不做任何处理，让t先执行运行)
        5：一定的条件是：
           5.1：时间的限制
           5.2：线程引用对象执行完毕*/
        //t.join();

        t.join(2000);//也就是main线程进行等待态
        //当前main线程等待2秒钟就往下执行(因为t线程执行的时间比2秒钟快)
        System.out.println(Thread.currentThread().getName());

    }

    public static void main(String[] args) throws InterruptedException {
        //without();
        //withoutSleep();
        withSleep();
    }
}
