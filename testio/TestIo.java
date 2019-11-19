package testio;
import java.util.Arrays;
/*2·克隆：
* 1·克隆自定义类型：实现Cloneable接口
* 2·克隆数组直接写array.clone();*/
class Money implements Cloneable{
    double m=12.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    Money money;
    public Person(){
    }
    public Person(String name) {
        this.name = name;
        this.money=new Money();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {//只是克隆了Person,也就是说是一个浅拷贝
        Person p=(Person) super.clone();
        p.money=(Money) this.money.clone();//再将Money也克隆一次，达到深拷贝。
        //return super.clone();//返回的是object是一个对象
        return p;
    }
}


/*1·比较：
* 自定义类型比较需要实现接口：用Comparable接口，然后重写compareTo()方法*/
//自定义对象如何进行排序：用Comparable接口 implements Comparable<Student>;并且重写compareTo()方法
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;//传进来的age和你当前对象的age 进行比较即可
        //return (int)(this.score-o.score);
        //return this.name.compareTo(o.name);//比较字符串的大小A.equal(B)是用来比较字符串是否相等
    }
}
public class TestIo {
    /*克隆：
    * */
    public static void main(String[] args)throws CloneNotSupportedException {
        Person person=new Person("CAOCAO");
        Person person1=(Person)person.clone();
        person1.money.m=99.9;
        System.out.println(person.money.m);//12.9
        System.out.println(person1.money.m);//99.9
    }
    public static void main2(String[] args)throws CloneNotSupportedException {
        Person person=new Person();
        person.name="曹操";
        System.out.println(person.name);
        Person person1=(Person) person.clone();
        person1.name="刘备";
        System.out.println(person.name);
        System.out.println(person1.name);

    }
    /*比较：
    * 传的数据类型肯定是实现Comparable接口的*/
   public static void sort(Comparable[] comparables){//自定义对象排序：必须要实现Comparable接口的对象
        /*
        * 1·模拟实现(sort)排序：
        * 2·冒泡来写：*/
        for(int i=0;i<comparables.length;i++){
            for(int j=0;j<comparables.length-1-i;j++){
                if(comparables[j].compareTo(comparables[j+1])>0){
                    Comparable temp=comparables[j+1];
                    comparables[j+1]=comparables[j];
                    comparables[j]=temp;
                }
            }
        }
    }
    public static void main1(String[] args) {
        Student[]student=new Student[3];
        student[0]=new Student("cacocao",78,98.3);
        student[1]=new Student("liubei",98,67.8);
        student[2]=new Student("zhangfei",66,74.5);
        System.out.println(Arrays.toString(student));
        //Arrays.sort(student);//进行age从小到大进行排序
        sort(student);
        System.out.println(Arrays.toString(student));
    }
}
