package DI.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SeoulZoo implements Zoo {

    @Autowired
    @Qualifier("lion1")
    Animal lion;
    @Autowired
    @Qualifier("tiger1")
    Animal tiger;

    public SeoulZoo() {
    }

    public SeoulZoo(Animal lion, Animal tiger) {
        this.lion = lion;
        this.tiger = tiger;
    }

    @Override
    public void info() {
        System.out.println("서울 동물원");
        tiger.info();
        lion.info();
    }
}
