package lesson5;

public class BreadOperation {

    //库存面包量，上限100，下限0
    public static volatile int SUM;

    public static void main(String[] args){
        //启动生产者线程，生产面包
        for (int i = 0; i <5; i++) {
            new Thread(new Producer(),"生产者"+i).start();
        }
        //启动消费者线程，消费面包
        for (int i = 0; i <5 ; i++) {
            new Thread(new Consumer(),"消费者"+i).start();
        }
    }

    //默认一个生产者：面包师傅，一次生产3个面包：内部类,生产20次
    private static class Producer implements Runnable{
        @Override
        public void run() {
            try {
                for (int i = 0; i <20 ; i++) {
                    synchronized (BreadOperation.class) {
                        //1：判断的是生产之后的值，库存满了，不能继续生产，所以库存在97以上就不能生产了
                        while (SUM+3 >= 100){
                            //释放对象锁，需要让其他进程进入同步代码块，当前线程需要变成阻塞态，不让其进行+3操作
                            BreadOperation.class.wait();//释放掉了对象锁，并且还变成阻塞态
                        }
                        SUM+=3;//生产面包
                        Thread.sleep(10);
                        BreadOperation.class.notify();
                        System.out.println(Thread.currentThread().getName()+"生产了，库存为"+SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //默认消费者，消费面包，一次一个
    private static class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                while (true){
                    synchronized (BreadOperation.class) {
                        //1：判断库存量，若为0就不能消费，也就是吧当前线程进行阻塞，不能继续消费
                        while (SUM == 0) {//将它变成循环，如果从这里阻塞变成运行，那么就循环判断一下就好了
                            BreadOperation.class.wait();//当前的消费线程进行阻塞
                        }
                        SUM--;
                        Thread.sleep(10);
                        //在synchronized代码结束后，才会唤醒。释放对象锁之后
                        //在synchronized奇数之后，wait()和synchronized代码行阻塞的线程
                        BreadOperation.class.notify();//通知随机唤醒一个；notifyAll:唤醒所有
                        System.out.println(Thread.currentThread().getName()+"消费了，库存为："+SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
