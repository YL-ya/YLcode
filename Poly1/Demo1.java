package poly;
class Shape{
    public  void draw(){

    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        //super.draw();
        System.out.println("♦");
    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        //super.draw();
        System.out.println("0");
    }
}
//多态就是为了让类的调用者不必知道类是怎么实现的
/*多态的好处：
* 1：能让类的调用者连类型都不知道是什么，只用知道调用那个方法即可
* 2：也就是封装的跟进一步
* 3：能够降低if-else的使用，也就是圈复杂度
* 4：扩展性很强
*/
//invokestatic静态绑定，也就是静态方法
public class Demo1 {
    public  static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Rect rect=new Rect();
        Cycle cycle=new Cycle();
        drawMap(rect);
        drawMap(cycle);
    }
}
