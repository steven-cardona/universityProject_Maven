package Views;

import Models.Course;
import Models.Faculties.Faculty;
import Models.Student;
import Models.Teacher;
import Models.typeOfTeachers.TeacherFullTime;
import Models.typeOfTeachers.TeacherPartTime;

import java.util.Scanner;

public class RequestData {

    public static String getCourseSelected() {
        Scanner input = new Scanner(System.in);
        System.out.print("Select Course By ID  -> ");
        return input.next();
    }

    public static String getIdOfPerson(String person) {
        Scanner input = new Scanner(System.in);
        System.out.print("Write ID of the " + person + " -> ");
        return input.next();
    }

    public static String getOptionForAddStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want add other student? Yes(y) - Not(n - other letter) -> ");
        return input.next();
    }

    public static Faculty getFaculty() {
        Scanner input = new Scanner(System.in);

        System.out.println("Printing the list of faculties in the university...");
        for (Faculty faculty: Faculty.values()) {
            System.out.println(faculty.name());
        }

        System.out.print("Write name of the faculty -> ");
        return Faculty.valueOf(input.next().toUpperCase());
    }

    public static Student getDataForStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Write Name: ");
        String name = input.next();

        System.out.print("Write Age: ");
        int age = input.nextInt();

        System.out.print("Write DNI: ");
        String dni = input.next();

        return new Student(name, age, dni);
    }

    public static Teacher getDataForTeacher() {
        Scanner input = new Scanner(System.in);
        System.out.print("Write Name: ");
        String name = input.next();

        System.out.print("Write Age: ");
        int age = input.nextInt();

        System.out.print("Write DNI: ");
        String dni = input.next();

        System.out.print("Write base salary: $");
        double baseSalary = input.nextDouble();

        Faculty faculty = getFaculty();

        System.out.print("Type of teacher: (1) Full Time or (2 - any number) Part Time \n -> ");
        String typeTeacher = input.next();

        if (typeTeacher.equals("1")) {
            System.out.print("Write the experience in years: ");
            int experienceYears = input.nextInt();

            return new TeacherFullTime(name, age, dni, baseSalary, faculty, experienceYears);
        }

        System.out.print("How many hours do you work: ");
        int hoursPeerWeek = input.nextInt();

        return new TeacherPartTime(name, age, dni, baseSalary,faculty, hoursPeerWeek);
    }

    public static Course getDataForCourse() {
        Scanner input = new Scanner(System.in);

        System.out.print("Write Name: ");
        String name = input.next();

        Faculty faculty = getFaculty();

        return new Course(name, faculty);
    }


}
