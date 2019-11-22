package poly;
//1·接口的关键字：interface
public interface IShape {
/*2·报错的原因就是在接口中，所有的方法都不能实现，只能在继承时候重写public void func();
    也就是所接口比抽象类还要抽象;因为在抽象类中还可以进行实现方法，但是接口中的方法是不能进行实现的*/
  /*  public void func(){
    }*/

//3·(接口中的方法都是抽象方法)都是默认为public abstract：接口当中的方法尽量简洁
    public abstract void draw();

//4·接口当中的成员变量默认(静态常量)public static final；必须初始化
    /*public static final int a=10;*/
//IShape:接口是不能被实例化的：也就是new IShape();表达式错误的；接口的产生是为了继承重写
    /*IShape ishape=new IShape();*/
}
/*
* 5·类和接口的关系叫做实现：implements
*    只要是普通类实现这个接口就必须重写接口中的方法
* 但是当你的类是抽象类中的方法可以实现也可以不实现，也就是可以重写也可以不重写
*
* 6·接口和类的关系就是实现：implementsA,B,C,D可以实现多个接口*/
/*abstract class Rect implements IShape{*/
 interface Ia{
     void func();
}
/*
* 7·接口和接口的关系不能是实现，但是可以是继承；因为只要一实现就得重写方法并且实现方法*/
class D implements C{//这样就得重写两个接口中的方法
    @Override
    public void funA() {
    }
    @Override
    public void funB() {
    }
    @Override
    public void funC() {
    }
}
interface A{
     void funA();
}
interface B/* implements A*/{
    void funB();
  /*  void funA(){
    }*/
}
interface C extends A,B{
    void funC();
}
/*8·总结抽象类和接口的区别*/


