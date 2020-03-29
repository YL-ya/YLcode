package lesson7;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService pool=new ThreadPoolExecutor(//构造方法中有7个参数
                //1：核心线程数(正式员工)
                3,

                //临时工雇佣：正式员工忙不过来，就会创建临时员工
                //临时工解雇：空闲时间超出我们自己设置的时间范围，就解雇掉，表示的临时工的生存时间
                //2：最大线程数(最多数量的员工：正式员工+临时工)
                5,

                //3：时间数量
                30,
                //4：时间单位(时间数量+时间单位表示一定范围的时间)：
                TimeUnit.SECONDS,

                //5：阻塞队列：存放包裹的仓库(存放任务的数据结构)
                new ArrayBlockingQueue<>(100),

                //6：创建线程的工厂(匿名内部)类，因为线程池中的线程是要进行创建的
                new ThreadFactory() {
                    //(了解)该匿名内部类是线程池创建Thread线程的工厂类。没有提供的话，就是用线程池内部默认的的创建线程的方式
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;//在线程池中创建线程
                    }
                },

                //7：拒绝策略：也就是当仓库满的时候，不能进行操作
                /*7.1：CallerRunsPolicy()：谁(调用execute代码行所在的线程)让我(快递公司)送，不好意思自己去送new ThreadPoolExecutor.CallerRunsPolicy()
                *7.2：AbortPolicy()：直接抛出异常RejectedExecutionException：线程执行的额时候抛出异常 new ThreadPoolExecutor.AbortPolicy()
                *7.3：DiscardPolicy()：从阻塞队列中丢弃最新(队尾)的任务new ThreadPoolExecutor.DiscardPolicy()
                *7.4：DiscardOldestPolicy()：从阻塞队列中丢弃最老(队首)的任务new ThreadPoolExecutor.DiscardOldestPolicy()*/
                new ThreadPoolExecutor.DiscardOldestPolicy());
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //当员工接到活就可以干活了
                //也就是线程可以直接运行代码了
                System.out.println("送快递到北京，A同学");
            }
        });
        pool.execute(new Runnable() {//为什么要返回的是线程类，因为在这里是传进去的是Runnable()对象
            @Override
            public void run() {
                System.out.println("送快递到新疆，B同学");
            }
        });
        System.out.println("我正在做事情");
    }
}
