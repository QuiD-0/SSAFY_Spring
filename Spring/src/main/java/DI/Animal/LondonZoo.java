package DI.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LondonZoo implements Zoo {

    @Autowired
    @Qualifier("lion2")
    Animal lion;
    @Autowired
    @Qualifier("tiger2")
    Animal tiger;

    public LondonZoo() {
    }

    public LondonZoo(Animal lion, Animal tiger) {
        this.lion = lion;
        this.tiger = tiger;
    }

    @Override
    public void info() {
        System.out.println("런던 동물원");
        tiger.info();
        lion.info();
    }
}
