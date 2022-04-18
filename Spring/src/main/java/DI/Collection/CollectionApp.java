package DI.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collection.xml");
        MyCollection myCollection = applicationContext.getBean("collection",MyCollection.class);

        myCollection.arrayInfo();
        myCollection.listInfo();
        myCollection.setInfo();
        myCollection.mapInfo();
    }
}
