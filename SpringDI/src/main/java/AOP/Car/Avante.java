package AOP.Car;

public class Avante implements Car{

    String color;

    @Override
    public void setColor(String color) {
        System.out.println("setColor 실행");
        this.color=color;
        
    }

    @Override
    public String getColor() {
        System.out.println("getColor 실행");
        return color;
    }
}
