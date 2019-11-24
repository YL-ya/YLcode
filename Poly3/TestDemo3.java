package poly;
/*1·继承表达isA的寓意
* 2·接口表达的意思就是具有某某特性
* 3·让程序员忘记类型，只关注某个类是否具有某种的能力*/
interface IFlying{
    void fly();
}
interface IRunning{
    void run();
}
interface ISwimming{
    void swim();
}
class Animal{
    public String name;

    public Animal(String name) {
        this.name = name;
    }
}
class Cat extends Animal implements IRunning{
    /*猫会跑
    * 1·继承就得先帮助子类构造父类
    * 2·接口中的方法进行重写
    * */
    public Cat(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+"跑");

    }
}
class Bird1 extends Animal implements IRunning,IFlying{
    /*鸟会飞和跑
    * 1·继承就得先帮助子类构造父类
    * 2·接口中的方法进行重写
    * */

    public Bird1(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+"会飞");
    }

    @Override
    public void run() {
        System.out.println(this.name+"会跑");
    }
}
class Robot implements IRunning{
    @Override
    public void run() {
        System.out.println("机器人在跑");
    }
}
public class TestDemo3 {
    public static void walk(IRunning Running){
        System.out.println("带着小伙伴去跑步");
        Running.run();
    }
   public static void swim(ISwimming iswimming){
        System.out.println("带着小伙伴去游泳");
        iswimming.swim();
    }
    public static void main(String[] args) {
        Cat cat=new Cat("小花");
        walk(cat);
      /*  swim(cat);//不能实现因为Cat并没有实现接口*/
        Robot robot=new Robot();
        walk(robot);
        //walk(new Robot())
    }
}
