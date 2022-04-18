package DI.SpringDI;

import org.springframework.stereotype.Service;

@Service
public class Starbucks implements CoffeeShop {
    Americano ame;
    CaffeLatte lat;

    public Starbucks(Americano ame) {
        this.ame = ame;
    }

    public void setLat(CaffeLatte lat) {
        this.lat = lat;
    }

    @Override
    public void info() {
        System.out.println("Starbucks");
        ame.info();
        lat.info();
    }
}
