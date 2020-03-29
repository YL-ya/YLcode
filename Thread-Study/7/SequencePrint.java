package lesson7;
/*多线程编程：启动3个线程，第一个线程打印a，第二个线程打印b，第三个线程打印c，循环打印10次。
 *要求是，同时启动3个线程，但是打印结果是这样的 ABC ABC ABC
 */
public class SequencePrint {
    private static volatile int INDEX;//设置一个条件

    //因代码很多重复，所以可以写一个打印的方法
    public static void print(String[] arr,int count){
        Print.INDEX=0;
        int index=0;
        for (int i = 0; i < arr.length; i++) {//数组中有几个数，就创建几个线程
            final int k=i;
            new Thread(new Print(arr,count,k)).start();
        }
    }
    public static class Print implements Runnable {
        private static volatile int INDEX;//进行共享
        private String[]arr;
        private int count;
        private int k;

        public Print(String[] arr,int count, int k) {
            this.arr=arr;
            this.count=count;
            this.k=k;
        }

        @Override
        public void run() {
            try {
                for (int j = 0; j < count; j++) {
                    synchronized (SequencePrint.class) {
                        while (INDEX % arr.length != k) {//这里写i会报错，是因为不再同一个类里面，无法用到，改成final修饰的常量就行了
                            SequencePrint.class.wait();
                        }
                        //也就是当INDEX%3==0的时候，会进行打印A
                        INDEX++;
                        System.out.print(arr[k]);
                        if (k == arr.length - 1) {
                            System.out.println("循环次数：" + j);//在打印到数组的最后一个元素的时候，进行换行
                        }
                        SequencePrint.class.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
           /* new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for(int j=0; j<count; j++){
                            synchronized (SequencePrint.class){
                                while (INDEX % arr.length != k){//这里写i会报错，是因为不再同一个类里面，无法用到，改成final修饰的常量就行了
                                    SequencePrint.class.wait();
                                }
                                //也就是当INDEX%3==0的时候，会进行打印A
                                INDEX++;
                                System.out.print(arr[k]);
                                if(k==arr.length-1){
                                    System.out.println("循环次数："+j);//在打印到数组的最后一个元素的时候，进行换行
                                }
                                SequencePrint.class.notifyAll();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();*/

    public static void main(String[] args) {
        print(new String []{"a","b","c"},10);
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        print(new String[]{"d","e","f","g"},10);
        //这样写的话两个print线程用的是同一个INDEX指标，应该将INDEX队里一下，每个方法用的自己独立的下标
        //所以可以将方法写成一个类，实现Runnable()接口
    }
}

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10; i++){
                        synchronized (SequencePrint.class){
                            while (INDEX % 3 != 0){
                                SequencePrint.class.wait();
                            }
                            //也就是当INDEX%3==0的时候，会进行打印A
                            INDEX++;
                            System.out.print("A");
                            SequencePrint.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10; i++){
                        synchronized (SequencePrint.class){
                            while (INDEX % 3 != 1){
                                SequencePrint.class.wait();
                            }
                            //也就是当INDEX%3==1的时候，会进行打印B
                            INDEX++;
                            System.out.print("B");
                            SequencePrint.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10; i++){
                        synchronized (SequencePrint.class){
                            while (INDEX % 3 != 2){
                                SequencePrint.class.wait();
                            }
                            //也就是当INDEX%3==2的时候，会进行打印C
                            INDEX++;
                            System.out.println("C");
                            SequencePrint.class.notifyAll();//玩车个当前的线程之后，进行
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
