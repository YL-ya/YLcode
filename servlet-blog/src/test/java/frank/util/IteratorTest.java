package frank.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IteratorTest {
    public static void main(String[] args) {
        //非线程安全的数据结构，内部的迭代器都是一种fail-fast快速失败的的迭代器
        //在迭代操作非线程安全的数据结构的时候，修改数据结构的操作，会导致下一次的迭代异常
        //多线程对同一个非线程安全的数据结构操作，一个线程遍历，如果另一个线程修改，下次迭代时也会抛异常
        List<Integer> list=new ArrayList<>();
        int len=10000;
        for (int i = 0; i <len ; i++) {
            list.add(i);
        }
        for(Integer i:list){//实现了Iterable接口的数据结构，都可以使用for循环遍历，本质上是基于迭代器来遍历的
            if(i==3){
                list.remove(3);
            }
            System.out.println(i);
        }

        //Map遍历是通过内部的Entry遍历，也是用于上边所说的快速失败迭代器
        Map<String ,Integer> map=new HashMap<>();
        for(Map.Entry<String ,Integer> entry:map.entrySet()){
            //这个entrySet也是实现了Iterable接口了的，也是快速失败迭代器
        }
    }
}
    /*private static Map<String,Integer>MAP=new HashMap<>();
    static {
        for (int i = 0; i <10000 ; i++) {
            MAP.put("X"+i,i);
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i <10000 ; i++) {
                MAP.put("X"+i,i);
            }
            *//*int i=0;
            while (true){
                MAP.get(i);
                i=new Random().nextInt(10000);
            }*//*
            *//*try {
                Thread.sleep(3000);
                MAP.put("A",1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
        }).start();

        new Thread(()->{

            *//*try {
                Thread.sleep(3000);
                MAP.put("B",1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
        }).start();
    }
}
*/