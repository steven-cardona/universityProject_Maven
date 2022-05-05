package Models;

import Models.Faculties.Faculty;

public class Teacher extends Person  {
    protected double baseSalary;
    protected String id;
    protected static int auxID;
    protected Faculty faculty;

    public Teacher(String name, int age, String DNI, double baseSalary, Faculty faculty) {
        super(name, age, DNI);
        auxID ++;
        this.baseSalary = baseSalary;
        this.id = "Tea" + auxID;
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Teacher) {
            Teacher other = (Teacher) obj;
            return this.DNI.equals(other.DNI);
        }
        return false;
    }
}
