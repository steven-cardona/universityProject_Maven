package Models;

public class Student extends Person {
    private String id;
    private static int auxID;

    public Student(String name, int age, String DNI) {
        super(name, age, DNI);
        auxID++;
        this.id = "Stu" + auxID;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return this.DNI.equals(other.DNI);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                " Id: " + id + " | " +
                " Name: " + name + " | " +
                " Age: " + age + " | " +
                " DNI: " + DNI +
                '}';
    }
}
