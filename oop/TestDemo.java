package oop;

class Address{
    public String num;
    public int floor;

    public Address(String num, int floor) {
        this.num = num;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Address{" +
                "num='" + num + '\'' +
                ", floor=" + floor +
                '}';
    }
}
class Student{
    public String name;
    public int age;
    public Address address;//组合的形式

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address:num" + address.num +
                ", address:floor" + address.floor+
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Address address=new Address("三号楼",5);
        Student student=new Student("张三",18,address);
        System.out.println(student);
    }
}
