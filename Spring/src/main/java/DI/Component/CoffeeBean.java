package DI.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CoffeeBean implements CoffeeShop {

    @Autowired
    @Qualifier("coffee4")
    Americano ame;
    @Autowired
    @Qualifier("coffee3")
    CaffeLatte lat;

    @Override
    public void info() {
        System.out.println("CoffeeBean");
        ame.info();
        lat.info();
    }
}
