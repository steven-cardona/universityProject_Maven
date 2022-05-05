package Models.typeOfTeachers;

import Models.Faculties.Faculty;
import Models.Teacher;

public class TeacherPartTime extends Teacher implements ISalaryCalculator {
    private int hoursWorkedPerWeek;

    public TeacherPartTime(String name, int age, String DNI, double baseSalary, Faculty faculty, int hoursWorkedPerWeek) {
        super(name, age, DNI, baseSalary, faculty);
        this.hoursWorkedPerWeek = hoursWorkedPerWeek;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * hoursWorkedPerWeek;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                " Id: " + getId() + " | " +
                " Name: " + name + " | " +
                " Faculty: " + faculty + " | " +
                " Age: " + age + " | " +
                " DNI: " + DNI + " | " +
                " Type: Part Time" + " | " +
                " Hours Peer Week " + hoursWorkedPerWeek + " | " +
                " Salary: $" + calculateSalary() +
                '}';
    }
}
