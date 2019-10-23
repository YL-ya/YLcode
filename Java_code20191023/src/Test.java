public class Test {
    public static void main2(String[] args) {
        Student stu1=new Student("张三");
        Student stu2=new Student(18);
        Student stu3=new Student("李四",20,"男");
    }
}
class Student {
    public String name;
    public int age;
    public String sex;

    public Student(String name) {
        this.name=name;
        System.out.println("他叫："+name);
    }

    public Student(int age ) {
        this.age = age;
        System.out.println("他的年龄是：" + age);
    }
    public Student(String name,int age,String sex) {
        this.name=name;
        this.age=age;
        this.sex=sex;
        System.out.println("他叫" + name + "\n"+"年龄:" + age +"\n"+ "性别:" + sex);
    }

}

//    public static void main1(String[] args) {
//        Calculator input=new Calculator();
//        System.out.println("两数之和："+input.addNumber(2,4));
//        System.out.println("两数之差："+input.subNumber(2,4));
//        System.out.println("两数之积："+input.mulNumber(2,4));
//        System.out.println("两数之商："+input.divNumber(2,4));
//    }
//}
//class Calculator{
//        public int num1;
//        public int num2;
//        public int addNumber(int num1,int num2) {
//            return(num1+num2);
//        }
//        public int subNumber (int num1,int num2){
//           return(num1-num2);
//        }
//        public int mulNumber (int num1,int num2){
//          return(num1*num2);
//        }
//        public double divNumber(double num1,double num2){
//           return(num1 / num2);
//    }
//}


