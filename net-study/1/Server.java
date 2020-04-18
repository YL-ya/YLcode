package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//服务器端的IO流操作
public class Server {
    private static  final  int PORT=9000;

    //创建一个线程池：
    private static final ExecutorService POOL=Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9000);
        while (true){
            //阻塞等待，没有新的客户端进来才会开启线程
            Socket client=server.accept();

            //当新的客户端的数据流来了，进行处理：采用设计模式，设计一个类
            POOL.execute(new Task(client));
        }
    }
    private static class Task implements Runnable{
        private Socket client;

        public Task(Socket client){
            this.client=client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out=new PrintWriter(client.getOutputStream(),true);
                String str;
                int i=1;
                //阻塞等待，接受数据
                while ((str=in.readLine())!=null&&!str.equals("exit")){//io流在结束时，返回的才是null
                    System.out.println(str);
                    out.println(i+"确实牛逼");
                    i++;
                }
                out.println("exit");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
