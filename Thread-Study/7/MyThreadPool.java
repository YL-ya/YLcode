package lesson7;
//自己实现一个简单的线程池
import lesson6.MyBlockingQueue;

public class MyThreadPool {

    private MyBlockingQueue<Runnable> queue;//阻塞队列：直接存放Runnable对象即可

    public MyThreadPool(int size, int capacity){
        queue = new MyBlockingQueue<>(capacity);
        // 创建正式员工
        for(int i=0; i<size; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 正式员工一直运行
                        while (true){
                            // 从仓库取包裹：
                            // 1.成功取出包裹（任务），方法返回
                            // 2.仓库里取不出包裹（其他员工正在取阻塞在synchronized代码行，
                            //                    仓库没有包裹wait方法阻塞）
                            Runnable task = queue.take();//直接在仓库中取任务即可(在这里可能是不会成功阻塞在这里的)

                            // 正式员工来送快递（当前线程通过实例方法调用来执行任务）
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }


    //执行任务的方法：
    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5, 100);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
            }
        });
    }
}
