package DI.SpringDI;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("coffee.xml");

        Coffee coffee = applicationContext.getBean("coffee1", Coffee.class);
        coffee.info();

        CoffeeShop shop = applicationContext.getBean("starbucks", Starbucks.class);
        shop.info();
    }


}
