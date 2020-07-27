package model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//将json进行对象化
public class Util {
    public static String readBody(HttpServletRequest req){
        //body的长度：单位是字节（也就是说这个是字节流）
        int contentLength=req.getContentLength();
        //使用buffer来保存body中的内容
        byte[] buffer=new byte[contentLength];

        //用try包裹的时候，隐式的调用close方法
        try (InputStream inputStream=req.getInputStream()){
            inputStream.read(buffer,0,contentLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer);
    }
}
