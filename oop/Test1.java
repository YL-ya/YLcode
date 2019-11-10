package oop;
public class Test1 extends Animal{
    public Test1(String name, int age) {
        super(name, age);
    }
    public void fun(){
        System.out.println(this.name);
        //该this代表的是Test1的引用
    }
}
