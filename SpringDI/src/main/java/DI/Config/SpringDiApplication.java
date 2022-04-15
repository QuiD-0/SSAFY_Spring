package DI.Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CoffeeConfig.class);

        CoffeeShop coffeeShop = applicationContext.getBean("getStar", CoffeeShop.class);
        coffeeShop.info();
    }
}
