package lesson2;
//按流向进行分类：输入，输出流
//按数据类型分：字节流，字符流
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class PrintWriterTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                 try {
                    if(sc.nextInt()==0)
                        throw new RuntimeException("i===0");
                    System.out.println();
                } catch (RuntimeException e) {
                     //e.printStackTrace();将异常打印到控制台
                    System.out.println(e.getMessage());//获得的就是i==0并打印出来

                     //用IO将异常信息转到字符串里
                    StringWriter sw = new StringWriter();

                    //PrintWriter继承了Writer，不适用自己的方法，直接在方法中调用，(装饰)适配器模式(设计模式)
                    PrintWriter pw = new PrintWriter(sw);//进行了包裹
                     //一个IO流里面通过构造方法传入另外一个IO流，相当于互相包含(包裹)


                    e.printStackTrace(pw);
                    String stackTrace = sw.toString();//转成字符串
                     //System.out.println(stackTrace);//打到控制台；像是多余的打印，只是场景没有给号，
                                                    // 一般异常要存放在数据库中，不能打印到控制台的
                    System.err.println(stackTrace);//异常以红色字体出现
                }
            }
        }).start();
    }
}
