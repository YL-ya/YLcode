package lesson6;
/*
* 实现阻塞式队列
* 1：满足线程安全的生产和消费功能
* 2：生产，消费达到上/下限的时候，需要阻塞等待*/
public class MyBlockingQueue<E> {
    private Object[] items;

    private int takeIndex;//弹出元素的索引
    private int putIndex;//添加元素的索引
    private int size;//有效容量

    public MyBlockingQueue(int capacity) {
        items = new Object[capacity];
    }

    public synchronized void put(E e) throws InterruptedException {
        while (size == items.length) {//达到上限的线程，需要进行等待
            //不能添加与秦愫，即上锁，对当前的this对象进行加锁
            wait();//等待操作
        }
        putIndex = (putIndex + 1) % items.length;
        items[putIndex] = e;
        size++;//存放元素索引++，需要满足循环队列索引，数组长度的情况
        notifyAll();//wait()方法中等待的线程进行竞争
    }

    //线程间通信，推荐做法：
    //1：while来纪念性判断，不要用if(因为在判断代码中进行释放锁后，其他线程会对变量进行修改，再次wait通知被恢复的时候，条件已经不满足了)进行判断
    //2：使用notifyAll()方法，全部唤醒

    public synchronized E take() throws InterruptedException {//1：这里是对当前对象进行加锁的操作
        while (size == 0) {
            wait();//2：这里是对当前的对象进行释放锁的操作
        }
        takeIndex = (takeIndex + 1) % items.length;
        size--;
        notifyAll();
        return (E) items[takeIndex];
    }


    private static int SUM;

    //定义一个静态内部类：模拟生产者和消费者
    private static class Producer implements Runnable {
        @Override
        public void run() {
            SUM += 3;
            System.out.println("生产，库存为" + SUM);
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            SUM--;
            System.out.println("消费，库存为" + SUM);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue=new MyBlockingQueue<>(100);
        for (int i = 0; i <5 ; i++) {
            final int k=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j <100 ; j++) {
                            queue.put(k*100+j);//进行100次循环，每次往队列中添加的数值都不一样
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
        while (true){//这里可以改为多个线程，现在这里只是在main线程进行操作的
            int num=queue.take();//可以进行观察下取出来的值是否是0~499，如果有重复元素则有可能出现问题了
            System.out.println(num);
        }
    }
}
       /* MyBlockingQueue<Runnable> queue=new MyBlockingQueue(100);
        for (int i = 0; i <5 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            queue.put(new Producer());//保存生产任务
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            queue.put(new Consumer());//保护消费任务
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        //main线程取出生产，消费者的任务
        while (true){
            Runnable r=queue.take();
            r.run();

        }
    }*/

