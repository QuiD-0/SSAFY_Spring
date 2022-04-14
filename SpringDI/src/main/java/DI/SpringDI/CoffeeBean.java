package DI.SpringDI;

public class CoffeeBean implements CoffeeShop {

    Americano ame;
    CaffeLatte lat;

    public CoffeeBean(Americano ame) {
        this.ame = ame;
    }

    public void setLat(CaffeLatte lat) {
        this.lat = lat;
    }

    @Override
    public void info() {
        System.out.println("CoffeeBean");
        ame.info();
        lat.info();
    }
}
