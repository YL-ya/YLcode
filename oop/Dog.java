package oop;

public class Dog extends Animal {
    private String sex;
    static {
        System.out.println("Dog::static{}");
    }
    {
        System.out.println("Dog::instance{}");
    }

    public Dog(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
        System.out.println("Dog(String name, int age) ");
    }
    public void bark(){
        System.out.println(this.getName()+"wangwang");
        //这里访问name是只能猜用get和set方法进行访问，因为在父类中成员变量是私有的（private）
        //因为很不方便，所以会产生protected类型的成员变量
    }
}
