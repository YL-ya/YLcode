package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//客户端的网络IO流的操作
public class Client {
    private static final String HOST="127.0.0.1";
    private static  final int PORT=9000;

    public static void main(String[] args) throws IOException {
        Socket client=new Socket(HOST,PORT);
        BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out=new PrintWriter(client.getOutputStream(),true);
        Scanner sc=new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    out.println(line);
                }
            }
        }).start();
        //out.println("我算法牛逼");这样写的方法太死板了，可以从控制台进行输入，并连接
        String str;
        //先进行数据的发送
        while ((str=in.readLine())!=null&&!str.equals("exit")){
            System.out.println(str);
        }

    }
}
