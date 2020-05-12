package frank.util;
//自己写的JSON.util工具类

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/*工具类的编写：
* O：对象
* return json字符串*/
public class JSONUtil {
    private static volatile ObjectMapper MAPPER;

    //自己写的一个mapper：
    public static ObjectMapper get(){
        if(MAPPER==null){
            //使用单列模式；双重校验锁：线程安全的单例模式
            synchronized (JSONUtil.class){
                if(MAPPER==null){
                    MAPPER=new ObjectMapper();
                }
            }
        }
        return MAPPER;
    }
    //当http请求的时候接受的是对象，当servlet响应的时候，是返回的json格式的字符串(键值对)
    //1：这里是序列化的过程：将对象转成json格式的字符串
    public static String serialize(Object o){
        try {
            //这里返回的是json格式(也就是键值对格式)的字符串
            return get().writeValueAsString(o);//编译时异常改成运行时异常：try-catch
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON序列化失败,对象为"+o,e);
        }
    }

    //2：这里是反序列化的过程：将json格式的字符串转成对象
    /*1：json：字符串
    * 2：clazz：java类型
    * 3：<T>：泛型
    * 4：return：反序列后的java对象
    * */
    public static <T> T deserialize(String json,Class<T> clazz){
        //这里加上原来对象的类型，是因为Object类太广泛了，直接返回的是应有对象即可
        try {
            return get().readValue(json,clazz);//转变成java的一个类
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败，JSON字符串为"+json,e);
        }
    }


    //3：将IO输入流(json格式)转成字符串
    public static <T> T deserialize(InputStream is, Class<T> clazz){
        try {
            return get().readValue(is,clazz);//转变成java的一个类
        } catch (IOException e) {
            throw new RuntimeException("IO流转JSON字符串失败，IO流为",e);
        }
    }
}
