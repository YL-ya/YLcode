package oop;

public class Cat extends Animal{
    private String sex;
    static {
        System.out.println("Cat::static{}");
    }
    {
        System.out.println("Cat::instance{}");
    }
    public Cat(String name,int age,String sex){
        super(name,age);
        this.sex=sex;
        System.out.println("Cat(String name, int age) ");
    }
    /*public void eat(){
        System.out.println(this.getName()+"eat()");
    }//可以不用写，因为Animal类中是有eat()方法的*/
/*    public void fun(){
        super.sleep();//调用父类的方法
        int a=super.a;//调用父类的成员
    }*/
}
