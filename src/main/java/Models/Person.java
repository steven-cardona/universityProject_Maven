package Models;

public class Person {
    protected String name;
    protected int age;
    protected final String DNI;

    public Person(String name, int age, String DNI) {
        this.name = name;
        this.age = age;
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public String getDNI() {
        return DNI;
    }
}
