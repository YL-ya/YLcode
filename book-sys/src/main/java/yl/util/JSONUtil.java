package yl.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import yl.exception.SystemException;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

//json数据的解析：通过io流转换成对象,或者通过对象转换成json格式的数据发送到前端
public class JSONUtil {

    private static ObjectMapper MAPPER;

    static {
        MAPPER=new ObjectMapper();
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    //反序列化：输入流序列化对象
    //读取输入流的json数据，反序列化成对象，是一种泛型的操作，<T>方法上定义泛型类型，返回值和传入值都可以使用泛型
    public static <T> T read(InputStream is,Class<T> clazz){
        //对象和json之间(http请求的输入流)的转换
        try {
            return MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            throw new SystemException("000003","http请求，后台解析json数据出错",e);
        }
    }

    //序列化：对象序列化输出流（json格式的字符串）
    public static String write(Object o){
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new SystemException("000004","返回json序列胡对象出错"+o,e);
        }
    }
}
