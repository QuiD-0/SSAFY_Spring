package DI.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("star")
public class Starbucks implements CoffeeShop {
    @Autowired
    @Qualifier("coffee2")
    Americano ame;
    @Autowired
    @Qualifier("coffee1")
    CaffeLatte lat;

    @Override
    public void info() {
        System.out.println("Starbucks");
        ame.info();
        lat.info();
    }
}
