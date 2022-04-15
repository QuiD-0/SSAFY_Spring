package DI.Component;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("coffee2.xml");

        Starbucks coffeeShop = applicationContext.getBean("star", Starbucks.class);
        coffeeShop.info();

        CoffeeShop coffeeShop2 = applicationContext.getBean("coffeeBean", CoffeeShop.class);
        coffeeShop2.info();

    }


}
