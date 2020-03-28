package lesson6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//线程池：
public class Test {
    //1：快递公司可以接很多的快递任务(可以>4，Runnable任务类)，
    //2：如果员工(线程池创建的线程)没有空闲(正在干活，忙碌),
    //3：快递包裹就到快递公司的仓库中(线程池内的一个属性，阻塞队列)
    //4：员工不停的从仓库中去包裹，送快递，如果仓库中没哟包裹，员工就等待，一直等到包裹在派送(执行Runnable对象中的run方法)
    public static void main(String[] args) throws InterruptedException {
        //创建线程池：也就是在main线程创建了一个快递公司，有4个公司职员，但是没有接到活干，在公司休养生息
        //也就是有一个线程池，里面有四个线程已经创建好了
        ExecutorService pool=Executors.newFixedThreadPool(4);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //当员工接到活就可以干活了
                //也就是线程可以直接运行代码了
                System.out.println("送凯迪到北京，A同学");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到新疆，B同学");
            }
        });
        System.out.println("我正在做事情");

        /*synchronized (Test.class) {
            Test.class.wait();//这里是对Test对象进行释放锁，为什么会报错，是因为，都没有对Test对象进行加锁
        }*/
    }
}
