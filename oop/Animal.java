package oop;
//final public class Animal {被final修饰的方法是不能被继承的，叫做密封类
//final int a;→常量；看他是成员变量还是局部变量：堆或者栈
public class Animal {
    protected String name;
    private int age;
    private int a;
    //protected是private和public的折中体现；
    //protected除了在不同包中的非子类怒能进行访问，其余和public是一样的，都可以被进行访问
    static {
        System.out.println("Animal::static{}");
    }
    {
        System.out.println("Animal::instance{}");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal(String name, int age) ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){

        System.out.println(this.name+"吃饭");
    }/*
    public void sleep(){
        System.out.println("sleep");
    }*/
}
