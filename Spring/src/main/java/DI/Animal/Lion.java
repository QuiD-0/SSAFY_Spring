package DI.Animal;

public class Lion implements Animal {
    int age;
    String name;

    public Lion() {
    }

    public Lion(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void info() {
        System.out.println("Lion");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);

    }
}
