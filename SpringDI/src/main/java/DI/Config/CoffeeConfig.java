package DI.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeConfig {

    @Bean
    public Americano getAme() {
        Americano ame = new Americano(4000, "Ethiopia");
        return ame;
    }

    @Bean
    public CaffeLatte getLatte() {
        CaffeLatte latte = new CaffeLatte(5000, "India");
        return latte;
    }

    @Bean
    public Starbucks getStar() {
        return new Starbucks(getAme(), getLatte());
    }

    @Bean
    public CoffeeBean getBean() {
        CoffeeBean coffeeBean = new CoffeeBean();
        coffeeBean.setAme(getAme());
        coffeeBean.setLat(getLatte());
        return coffeeBean;
    }
}
