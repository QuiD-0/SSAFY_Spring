package DI.Config;

public class Starbucks implements CoffeeShop {
    Americano ame;
    CaffeLatte lat;

    public Starbucks(Americano ame, CaffeLatte lat) {
        this.ame = ame;
        this.lat = lat;
    }

    @Override
    public void info() {
        System.out.println("Starbucks");
        ame.info();
        lat.info();
    }
}
