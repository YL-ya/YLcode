package lesson1;
//线程的创建
public class FirstLook {
   /* public static void main(String[] args) throws InterruptedException {
        Thread.sleep(999999999999L);//当前线程进入休眠状态
    }*/

    public static void main(String[] args) {
        new Thread(new Runnable() {//这里就是匿名内部类，在这里新创建了一个线程，但是还没有启动
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();//线程启动
    }
}
