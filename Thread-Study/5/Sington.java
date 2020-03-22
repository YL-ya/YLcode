package lesson5;
//在单线程中是没有问题的,但是多线程中是有问题的，因为new的操作
//所以使用单例模式：也就是对其进行加锁，保证如果有同一个对象的时候，返回的是当前的对象
public class Sington {
    //1：饿汉式
    /*private static Sington SINGTON=new Sington();
    public static Sington getInstance(){
        return SINGTON;
    }*/

    //2：懒汉式：
    /*private static Sington SINGTON=new Sington();
    public static Sington getInstance(){
        if(SINGTON==null){
            SINGTON =new Sington();
        }
        return SINGTON;
    }*/

    //3：双重校验：
    private static volatile Sington SINGTON;
    public static Sington getInstance(){
        //提高效率，变量可以用 volatile：满足可见性和重排序
        if (SINGTON == null) {
            synchronized(Sington.class){
                //为了保证一个单例模式，也是就返回的是同一个对象：保证了原子性
                if(SINGTON==null){
                    SINGTON=new Sington();
                }
            }
        }
        return SINGTON;
    }
}
