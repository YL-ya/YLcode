package lesson2;
//java序列化
import java.io.*;

public class SerializableTest {

    public static void main(String[] args) throws Exception {
//        new SerializableTest().new Person2();
//        SerializableTest test = new SerializableTest();
//        test.new Person2();

        Person person = new SerializableTest.Person();
        /*//1：写到我们的系统里面
        //1：先定义一个字节输出流
        ByteArrayOutputStream bao=new ByteArrayOutputStream();

        //2：定义对象输出流，构造方法将对象输出流，转成字节输出流
        ObjectOutputStream oos=new ObjectOutputStream(bao);

        //3：调用方法进行写操作：
        oos.writeObject(person);*/

        //写到文件里面去，让java虚拟机
        // 序列化：直接写到文件中去：也就是输出
        ObjectOutputStream oos= new ObjectOutputStream(
                new FileOutputStream("E:\\20191218dataStructure\\io-study\\res/person"));
        oos.writeObject(person);//进行取操作

        // 反序列化：输入
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("E:\\20191218dataStructure\\io-study\\res/person"));
        Person person1 = (Person) ois.readObject();
        System.out.println(person1);
    }

    private static class Person implements Serializable {//定义一个静态内部类，实现序列化接口

        private String name;
        private Integer age;
    }
//    private class Person2{}//实例内部类适合对象的实例化进行绑定的，
//                            也就是SerializableTest test = new SerializableTest();
//                            test.new Person2();

}
