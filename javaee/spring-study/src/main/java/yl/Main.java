package yl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yl.model.Duck;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
        Duck duck=(Duck) context.getBean("duck1");
        System.out.println(duck);

        Duck duck1=(Duck) context.getBean("duck2");
        System.out.println(duck1);
    }
}