package AOP.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("car.xml");
        Car car = applicationContext.getBean("avante",Car.class);
        car.setColor("red");
        System.out.println();
        System.out.println(car.getColor());
    }
}
