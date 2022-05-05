package Models.typeOfTeachers;

import Models.Faculties.Faculty;
import Models.Teacher;

public class TeacherFullTime extends Teacher implements ISalaryCalculator {
    private int experienceYears;
    private final double salaryRate = 1.1;

    public TeacherFullTime(String name, int age, String DNI, double baseSalary, Faculty faculty, int experienceYears) {
        super(name, age, DNI, baseSalary, faculty);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * (experienceYears * salaryRate);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                " Id: " + getId() + " | " +
                " Name: " + name + " | " +
                " Faculty: " + faculty + " | " +
                " Age: " + age + " | " +
                " DNI: " + DNI + " | " +
                " Type: Full Time" + " | " +
                " ExperienceYears: " + experienceYears + " | " +
                " Salary: $" + calculateSalary() +
                '}';
    }
}
