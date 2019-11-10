package oop;
public class Test {
    public static void main(String[] args) {
        Cat cat=new Cat("咪咪",1,"man");
        cat.eat();
        System.out.println("===============");
        Dog dog=new Dog("豆豆",3,"women");
        dog.bark();
        dog.eat();
        /*Animal animal=new Animal("动物",3);
        animal.sex;
        //不能通过父类访问子类的成员变量，父类只能访问自己的成员或者方法
        //但是可以通过子类访问父类的成员变量或者方法*/
        Test1 test1=new Test1("caocao",18);
        System.out.println(test1.name);//只能通过子类的引用访问父类的成员变量
    }
}
