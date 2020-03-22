package lesson5;

public class SingtonMain {
    public static void main(String[] args) {
        //饿汉式：
        //Sington sington=Sington.getInstance();
        for (int i = 0; i <5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Sington sington = Sington.getInstance();//在这里不满足原子性
                }
            }).start();
        }
    }
}
