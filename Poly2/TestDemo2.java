package poly;
//1·extends表是扩展指的是：当前已经有一定的功能了，进一步进行扩充功能
//2·implements实现指的是：当前啥都没有，要从头构造出来
//3·在java中都是单继承，为了实现多继承就引入接口的概念
class Rect1 implements IShape,Ia{//实现两个接口中的功能
    @Override
    public void draw() {
        System.out.println("画矩形");
    }

    @Override
    public void func() {

    }
}
class Cycle2 implements IShape{
    @Override
    public void draw() {//子类的权限要大于父类的权限
        System.out.println("画圆圈");
    }
}
public class TestDemo2 {
    public  static void drawMap(IShape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //1·接口中也可以向上转型：IShape就是相当于基类，也就是父类
        IShape ishape=new Rect1();
        IShape ishape1=new Cycle2();
        drawMap(ishape);
        drawMap(ishape1);
    }
}
