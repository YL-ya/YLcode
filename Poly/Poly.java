package poly;//多态
/*重点：重写和重载的区别
重点：this(当前对象的引用)和super(父类的引用)的区别
                super.data;(父类的属性)
                super.func();(父类的方法)
                super();(调用父类的构造方法);必须放在第一行*/
import oop.Animal;
import oop.Cat;
/*重写的注意事项：1：方法不能是private的
               2：子类的方法权限一定大于父类的方法权限
               3：重写的方法不能是一个静态的方法(static)*/
//被Final 修饰的类是不能被继承的
//继承：为了代码的复用
class Animal1{
    public String name;
    public  int age;
    static {
        System.out.println("static::Animal");
    }
    {
        System.out.println("instance::Animal");
    }
   /*
   //坑：
        public Animal1(){
            eat();//在构造方法内 是否可以发生运行时绑定：可以
              //方法表在编译期间就已经形成
    }*/
   public Animal1() {

   }

    public Animal1(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal()");
    }

    public void eat(){
        System.out.println("Animal::eat()");
    }
}
//父类 超类 基类  Cat:子类  派生类
//子类继承父类出构造方法外所有的东西
class Cat1 extends Animal1{
    public  String sex;
//子类的构造方法内，帮助构造父类
    static {
    System.out.println("static::Cat1");
}
    {
        System.out.println("instance::Cat1");
    }
    public Cat1(){

    }

    public Cat1(String name, int age,String sex) {
        super(name,age);//显示调用父类的构造方法
        this.sex = sex;
        System.out.println("Cat()");
    }

    public  void jump(){
        System.out.println(this.name+"跳");//this代表：当前的cat,cat可以访问到name是因为cat继承了Animal中的属性(name)和方法
    }
    public  void eat(){
        System.out.println("CAT::eat()");
    }
}
class Bird extends Animal1{
    public String yumao;//默认是无参的构造方法
    public void fly(){
        System.out.println("飞");
    }

}
public class Poly {
    //在构造方法内 是否可以发生运行时绑定：可以
    public static void main(String[] args) {
        Cat1 cat=new Cat1();//直接在new对象时，父类的构造方法中也有eat();直接出发运行时绑定
        cat.eat();
    }
    //向下转型
    public static void main4(String[] args) {
        Animal1 animal1=new Cat1();
        animal1.eat();//发生的是向上转型
        Animal1 animal2=new Bird();//默认是无参的构造方法
        //animal2.fly();//上面已经发生向上转型；父类不能调用子类的方法

       /* //非要调用用子类中的方法：可以通过向下转型：也就是强转
        Bird bird=(Bird)animal2;
        bird.fly();
        //向下转型一定要慎用，一般不用
        Cat1 cat1=(Cat1) animal2;
        cat1.jump();//java.lang.ClassCastException: poly.Bird cannot be cast to poly.Cat1:类型转换异常
        *//*所以当发生向下转型的前提：必须发生向上转型
        if(aniaml instanceof Cat)*/
    }
    //向上转型：不带有参数的对象
    //javap-c:反编译；invokespecial:(初始化)构造方法；invokevirtual:调用的非静态方法，也就是实例方法
    //编译的时候是调用的是Aniaml的eat()方法，但是在运行后打印的是Cat的eat()方法；也就是运行时绑定(也叫多态)
    //重写：方法名相同，参数列表相同，返回值相同
    /*发生多态(运行时多态)的条件：(多态：一种事物多种形态)
                1:继承的关系(父类引用子类的对象(向上转型))
                animal.jump();(如果发生向上转型，父类只能调用父类自己的方法)
                2：通过父类的引用调用父类和子类同名的覆盖方法
                 animal.eat(父类和子类都有eat());*/
   /*向上转型有三种方法：1：直接赋值：Animal animal=new Cat();
                        2:方法传参：public static void func(Animal animal){
                                                 animal.eat();}
                                 public static void main(String[] args) {
                                        Cat1 cat=new Cat1();
                                        func(cat);
                                    }
                 3:方法返回：
                        public static Animal func(Animal animal){
                                        Cat1 cat=new Cat1();
                                        return cat; }
                        */
    public static void main3(String[] args) {
        Animal1 animal=new Cat1();//不爱参数的属性没有赋任何的值(即name=null,也就是this.name=null)，所以打印的是nulleat();

        animal.eat();//当子类中也有eat()方法：和下面的父类只能调用自己的方法发生冲突，思想上本来应该打印Animal的eat()方法
        //但是打印的却是Cat的eat()方法；在这中间就是悄悄地发生了（运行时绑定(该过程就叫做多态)）

        //animal.jump();//如果发生向上转型，父类只能调用父类自己的方法


    }
    //向上转型：带有参数的对象
    public static void main2(String[] args) {
        //向上转型：也就是父类引用子类的对象
        Animal1 animal=new Animal1("动物",4);//animal不再指向new Aniaml();这个对象了，就被垃圾回收站给回收了
        Cat1 cat1=new Cat1("花花",3,"women");
        //cat1.eat();//调用的父类的eat()
        animal=cat1;//"向上转型"将子类对象的引用赋值给animal::UML

        //或者可以写成这样
        Cat1 cat2=new Cat1("花花",4,"women");
        Animal1 animal2=cat2;

        //所以可以用一句代替三句话:()也就是
        Animal1 animal3=new Cat1("花花",3,"women");

        animal.eat();//打印的是花花eat(),最后给父类传的name是花花
    }
    //继承：
    public static void main1(String[] args) {
        Cat1 cat=new Cat1("花花",2,"man");
        Cat1 cat1=new Cat1("明明",3,"women");
        cat.jump();
        cat.eat();//当子类中没有重写eat()方法时，调用的是父类的eat()方法
    }
}
