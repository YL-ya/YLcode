package image;
//抽象类产生的意义就是被用来继承的
//多一重编译器的校验：第一时间知道代码出现的问题
//要想使用，只能创建抽象类的子类，让子类进行使用(重写方法)
abstract class Shape{
   /* 1:包含抽象方法的类叫做抽象类
   * 2:抽象类是不能被实例化的
   * 3：抽象类当中可以有抽象方法，也可以有非抽象方法，和成员变量
   * 4：抽象类的产生就是为了继承
    */
    //abstract:抽象方法
    /*public void draw(){
    }什么都没有(具体)实现就可以将它定义成抽象类*/
    public abstract void draw();//不想在这个类里面实现
    public int a=10;
    public void func(){
        System.out.println("func()");
    }
}
//5：抽象类被继承一定要重写父类中的方法
/*class A extends Shape{

}*/
class A extends Shape{
    @Override
    public void draw() {
        System.out.println(":必须重写");
    }
}
//6：抽象类可以继承抽象类：抽象类B可以选择重写也可以选择不重写
abstract class B extends  Shape{
    @Override
    public void draw() {
        System.out.println("抽象类中已经重写，那么继承的当中就可以不用重写");
    }
}
//7:抽象类中已经重写，那么继承的当中就可以不用重写
class C extends B{

}
/*class c extends B{//必须重写

    @Override
    public void draw() {
        System.out.println("必须重写");
    }
}*/
//子类的权限一定要比父类的大
class Rect extends Shape {
    @Override
    public void draw() {
        //super.draw();
        System.out.println("♦");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        //super.draw();
        System.out.println("0");
    }
}
public class Image {
    public  static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape1=new Rect();
        drawMap(shape1);
        Shape shape2=new Cycle();
        drawMap(shape2);
    }
}
