package test;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c=new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("call");
                return 123;
            }
        };

        //方法1：Thread使用Callable
        FutureTask<Integer> task=new FutureTask<Integer>(c);
        new Thread(task).start();
        System.out.println("main");
        Integer r=task.get();//阻塞等待
        System.out.println(r);

        //方法2：线程池使用Callable
        ExecutorService pool= Executors.newFixedThreadPool(4);
        Future<Integer> fu=pool.submit(c);
        System.out.println("main");
        Integer r2=fu.get();//阻塞等待
        System.out.println(r2);
    }
}
