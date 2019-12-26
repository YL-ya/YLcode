import java.util.ArrayList;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
public class Test20191221 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        System.out.println(c.isEmpty());
        c.add("C 语言");
        c.add("Java SE");
        //c.add(0, "公开课");
        c.add("数据结构");
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        System.out.println(c);
        c.remove("数据结构");
        System.out.println(c);
        List<String> L1 = new ArrayList<>();
        ArrayList<String> L2 = new ArrayList<>();
    }
}
*/

/*
import java.sql.SQLOutput;
import java.util.Map;
import java.util.HashMap;

//
public class Test20191221 {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("apple", "苹果");
        m.put("orange", "橘子");
        m.put("banana", "香蕉");
        System.out.println(m.size());
        System.out.println(m.get("orange"));

        String str1 = m.getOrDefault("apple", "苹果果");
        String str2 = m.getOrDefault("pear", "梨");

        System.out.println(m.containsKey("pear"));
        System.out.println(m.containsKey("orange"));

        System.out.println(m.containsValue("梨"));
        System.out.println(m.containsValue("橘子"));

        for(Map.Entry<String, String> e : m.entrySet())
        {
            System.out.println(e.getKey() + "--->" + e.getValue());
        }

        m.clear();
        System.out.println(m.size());
    }
}
*/

/*
// Object类 是所有类的父类
// Object o = new String();

    // JDK 1.5
class Book{}
class Person{
    public void Print(){
        System.out.println("我是一个好人");
    }
}
d
class MyArrayList
{
    public MyArrayList(int capacity){
        array = new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    void add(Object e)
    {
        // 检测容量
        array[size++] = e;
    }

    int size()
    {
        return  size;
    }

    Object get(int index)
    {
        // 检测index不能越界
        return  array[index];
    }

    boolean isEmpty()
    {
        return 0 == size;
    }

    Object[] array;
    int capacity;  // 空间的总大小
    int size;      // 空间中存储有效元素的个数
}

public class Test20191221 {
    public static void main(String[] args) {
        MyArrayList L1 = new MyArrayList(10);
        L1.add(new Person());
        L1.add(new Person());
        L1.add(new Person());

        // 向下转型：不安全
        Person p = (Person)L1.get(0);
        p.Print();

        MyArrayList L2 = new MyArrayList(10);
        L2.add(new Book());
        L2.add(new Book());
        L2.add(new Book());

        //L2.get(0); // 返回类型Object ---> Book
        Book b = (Book)L2.get(0);

        // 向下转型：不安全
        Person pp = (Person)L2.get(0);
        pp.Print();
    }
}
*/

/*
import java.util.ArrayList;
class Book{}
class Person{
    public void Print(){
        System.out.println("我是一个好人");
    }
}

// 泛型类
class MyArrayList<E>
{
    public MyArrayList(int capacity){
        array = (E[])new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public void add(E e)
    {
        // 检测容量
        array[size++] = e;
    }

    public int size()
    {
        return  size;
    }

    E get(int index)
    {
        // 检测index不能越界
        return  array[index];
    }

    boolean isEmpty()
    {
        return 0 == size;
    }

    E[] array;
    int capacity;  // 空间的总大小
    int size;      // 空间中存储有效元素的个数
}

public class Test20191221 {
    public static void main(String[] args) {
        // L1中只能存储Person类型的对象
        MyArrayList<Person> L1 = new MyArrayList<>(10);
        L1.add(new Person());
        L1.add(new Person());
        // L1.add(new Book());  在编译阶段，发现类型不匹配，编译器报错
        Person p = L1.get(0);
        // Book b = (Book)L1.get(0); // 在编译阶段，发现类型不匹配，强转也不行

        // L2中只能存储Book类型的对象
        MyArrayList<Book> L2 = new MyArrayList<>(10);
        L2.add(new Book());
        //L2.add(new Person());

        System.out.println(L1.getClass());
        System.out.println(L2.getClass());

        MyArrayList<int> L3 = new MyArrayList<int>(10);
    }
}
*/

/*
import java.util.ArrayList;

public class Test20191221 {
    public static void main(String[] args) {
        int i = 10;
        Integer i2 = Integer.valueOf(i);  // 装箱：将基础类型定义的变量转化为对应的包装类型
        int i3 = i2.intValue();   // 拆箱：将包装类对象中的数据拿出

        Integer i1 = i;   // 自动装箱：编译器在编译阶段会使用i构造一个包装类型的对象，然后使用i1引用 Integer.valueOf(i)
        int i4 = i1;      // 自动拆箱：将包装类型的对象直接赋值给对应的基础类型的变量
                          //           i1.intValue();
    }
}
*/

/*
public class Test20191221 {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        Integer i5 = Integer.valueOf(100);
        Integer i6 = Integer.valueOf(200);

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}

*/

/*
import java.util.List;
import java.util.ArrayList;

public class Test20191221 {
    public static void main(String[] args) {
        List<Integer> L1 = new ArrayList<>();  // 一维的动态数组
        List<Integer> L2 = new ArrayList<>();
        List<Integer> L3 = new ArrayList<>();

        List<List<Integer>> L = new ArrayList<>();
        L.add(L1);
        L.add(L2);
        L.add(L3);
    }
}
*/


import java.util.List;
import java.util.ArrayList;

public class Test20191221 {
    public static void main(String[] args) {
        List<Integer> L1 = new ArrayList<>();  // 一维的动态数组
        L1.add(10);
        L1.add(20);
        L1.set(0, 0);
        L1.set(1, 1);
        L1.set(2, 2);  // 代码崩溃，2号位置没有元素  越界
        L1.set(3, 3);
        L1.set(4, 4);
    }
}
