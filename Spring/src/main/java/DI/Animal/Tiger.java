package DI.Animal;

public class Tiger implements Animal {
    int age;
    String name;

    public Tiger() {
    }

    public Tiger(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void info() {
        System.out.println("Tigeer");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);

    }
}
