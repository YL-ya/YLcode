package lesson7;
/*自定义定时器：
* 1：在约定好的时间点上，执行某个任务
* 2：间隔时间内，不同的执行任务*/
/*思想：
 * 1：将任务存放在优先级队列中
 * 2：利用循环不断从优先级队列中去除任务
 * 3：设置当前时间，延迟时间，间隔时间*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class MyTimer {
    private BlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue();

    //private BlockingQueue<Runnable> queue = new PriorityBlockingQueue();
    //这里因为Runnable对象没有，里面是没有时间参数，优先级队列无法进行排序，所以传入一个自己实现的对象(带时间参数的)

    public MyTimer(int count){
        for (int i = 0; i <count ; i++) {//循环创建线程
            new Thread(new MyWorker(queue)).start();
            }
        }

        //new Thread(new Runnable){}将匿名内部类自己编写成一个类
                /*@Override
                public void run() {
                    try {
                        while (true) {
                            //该行没有进行加锁，是因为BlockingQueue本身就是线程安全的，所以不用放在调用的同步代码块中
                            MyTimerTask task = queue.take();//该定时任务，不停的从优先级队列中去取，并执行

                            //将任务从阻塞队列中取出来之后进行加锁
                            synchronized (queue) {
                                long current = System.currentTimeMillis();
                                if (task.next > current) {//如果写成小于的话，就时间就过了
                                    //没有达到我们想要的时间，我们就不应该让他再执行，让他进行等待，并将该任务放回队列中
                                    queue.wait( task.next-current);
                                    queue.put(task);
                                } else {
                                    task.task.run();//达到我们的执行时间，就执行
                                    if (task.period > 0) {
                                        task.next = task.next + task.period;//下次执行的时间
                                        queue.put(task);
                                    }
                                }
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();*/

    //因为在构造方法中最好不要放太多代码，所以将那个匿名内部类改成静态内部类
    private static class MyWorker implements Runnable {
        private BlockingQueue<MyTimerTask> queue;

        public MyWorker(BlockingQueue<MyTimerTask> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    //blockingQueue本身就是线程安全的，所以这里的方法调用不用放在同步代码块
                    MyTimerTask task = queue.take();
                    synchronized (queue) {
                        long current = System.currentTimeMillis();
                        if (task.next > current) {
                            queue.wait(task.next-current);
                            queue.put(task);
                        } else {
                            task.task.run();
                            if (task.period > 0) {
                                task.next = task.next + task.period;
                                queue.put(task);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 定时任务
     * @param task 需要执行的任务
     * @param delay 从当前时间延迟多少毫秒，执行任务
     * @param period 间隔时间：<=0就忽略掉，>0需要每间隔给定时间，就执行任务
     */
    public void schedule(Runnable task,long delay,long period){
        try {
            queue.put(new MyTimerTask(task,System.currentTimeMillis()+delay,period));
            synchronized (queue){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //包装task任务，因为Runnable对象没有可以进行比较的东西
/*
    private static class MyTimerTask implements Runnable,Comparable<MyTimerTask>{
*/
    private static class MyTimerTask implements Comparable<MyTimerTask>{

        //1：定时任务：
        private Runnable task;//可以形成多态

        //2：下次执行的时间
        private long next;//下次执行的时间

        //3：间隔时间：
        private long period;

        public MyTimerTask(Runnable task,long next,long period){
            this.task=task;
            this.next=next;
            this.period=period;
        }

       /* //因为优先级队列是有比较的，所以还要实现比较的接口
        @Override
        public void run() {

        }*/

        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next,o.next);
        }
    }


        /*//这样就可以将while循环，消耗时间的时候，我们就可以解决while循环的时候进行空跑
        try {
            Thread.sleep(delay);
            new Thread(task).start();
            while (period>0){
                Thread.sleep(period);
                new Thread(task).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long current=System.currentTimeMillis();//最开始的时候的所在时间
        while (true){//循环在这里是空跑，直到到达延迟时间的时候，才会执行相关任务，
                      // 这样浪费资源，可以用线程的等待机制
            long next =System.currentTimeMillis();//执行的时候就相当于加了多少时间
            //当前时间next超过约定好的执行时间(current+delay)，执行任务
            if(current+delay<=next){
                new Thread(task).start();
                if(period<=0){//当间隔时间大于0的时候
                    break;
                }else {

                }
            }
        }*/


    //jdk的时间操作
    public static void main(String[] args) {
        /*//Date:日期类
        Date date1=new Date();//无参构造方法，返回的是系统的当前时间
        Date date2=new Date(999999);//表示的是以格林威治时间 1970-01-01开始，经过给定时间数量的毫秒

        //DateFormat：时间的格式化：H大写表示24小时，h小写表示12小时
        DateFormat df=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date1));
        System.out.println(df.format(date2));*/

        //System.时间获取
        long current=System.currentTimeMillis();//表示的是从1970-01-01到现在所经过的时间

       /* //java原生的定时器
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了");

            }
        };
        new Timer().schedule(task,3000,1000);*/
       new MyTimer(4).schedule(new Runnable() {
           @Override
           public void run() {
               System.out.println("起床了");
           }
       },3000,1000);

       // ExecutorService pool=Executors.newSingleThreadExecutor();//单个线程池中只有一个线程员工
        // ExecutorService pool=Executors.newFixedThreadPool(4);//固定大小的线程池：正式员工为4，没有临时工
          ScheduledExecutorService pool=Executors.newScheduledThreadPool(4);//定时任务的线程池：正式员工
        //ExecutorService pool=Executors.newCachedThreadPool();//正式员工为0，临时员工数量不限制

       /* pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床了 ");
            }
        },1,TimeUnit.SECONDS);//延迟时间，执行任务：只会执行一次*/
      /* pool.scheduleAtFixedRate(new Runnable() {
           @Override
           public void run() {
               System.out.println("起床了");
           }
       },1,1,TimeUnit.SECONDS);
       //循环执行：延迟时间+间隔时间：也就是在当前时间延迟1秒，运行，然后间隔运行1秒*/
    }
}
