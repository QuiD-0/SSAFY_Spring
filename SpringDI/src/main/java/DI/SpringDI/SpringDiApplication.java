package DI.SpringDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDiApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("coffee.xml");

        Coffee coffee1 = applicationContext.getBean("coffee1", Coffee.class);
        coffee1.info();

        Starbucks starbucks = applicationContext.getBean("starbucks", Starbucks.class);
        starbucks.info();
    }


}
