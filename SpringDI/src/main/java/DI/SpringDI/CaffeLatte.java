package DI.SpringDI;

import org.springframework.stereotype.Component;

@Component
public class CaffeLatte implements Coffee {
    @Override
    public void info() {
        System.out.println("CaffeLatte:에스프레소 샷과 따뜻한 우유와 거품으로 마무리된 음료");
    }
}
