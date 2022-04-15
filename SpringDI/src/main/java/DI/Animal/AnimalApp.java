package DI.Animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("zoo.xml");
        Zoo zoo = applicationContext.getBean("londonZoo", Zoo.class);
        Zoo zoo2 = applicationContext.getBean("seoulZoo", Zoo.class);
        zoo.info();
        zoo2.info();
    }

}
