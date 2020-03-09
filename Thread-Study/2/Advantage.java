package lesson2;
//验证串行和并行的优劣：
public class Advantage {
    private static final int NUM=7;

    private static void increment(){
        int count=1000000000;
        for (int i = 0; i <count ; i++) {
            count--;
        }
    }

    //串行的:代码行一次执行
    private static void  serial(){
        long start=System.nanoTime();//1970-01-01开始到当前的毫秒数
        for (int i = 0; i <NUM ; i++) {
            increment();
        }
        long end=System.nanoTime();
        System.out.println("串行执行的时间为"+(end-start)/1000/1000);
    }

    //并行的:(并发)(在java中并发可以表达真同时，也可以表达假同时)
    private static void parallel(){
        long start=System.nanoTime();//1970-01-01开始到当前的毫秒数
        for (int i = 0; i <NUM ; i++) {
            //在这里使用线程进行执行调度：
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();//系统同时调用线程，并发实现5次循环
                }
            }).start();//在这里线程不一定结束
        }
        while(Thread.activeCount()>1){//如果活跃线程大于1，就让当前的线程进行等待
            Thread.yield();//注意：在该线程代码进行运行采用debug的方式
        }
        long end=System.nanoTime();
        System.out.println("并行执行的时间为"+(end-start)/1000/1000);
    }

    public static void main(String[] args) {
        serial();
        parallel();
    }
}
