package Views;

import java.util.Scanner;

public class GetOptionMenu {
    public static String getOptionMainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("== Main Menu ==");
        System.out.println("| 1) Get University Information");
        System.out.println("| 2) Dashboard Students");
        System.out.println("| 3) Dashboard Teachers");
        System.out.println("| 4) Dashboard Courses");
        System.out.println("| 5) Show Information System");
        System.out.println("| 6) Exit...");
        System.out.println("--------------------------");
        System.out.print(" Select Option -> ");
        return input.next();
    }

    public static String getOptionStudentsMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println(" = Dashboard Students =");
        System.out.println("| 1) Show All Students");
        System.out.println("| 2) Create New Student");
        System.out.println("| 3) Remove Student");
        System.out.println("| 4) Show Student Courses");
        System.out.println("| 5) Exit");
        System.out.println("--------------------------");
        System.out.print(" Select Option -> ");
        return input.next();
    }

    public static String getOptionTeacherMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("| = Dashboard Teachers =");
        System.out.println("| 1) Show All Teachers");
        System.out.println("| 2) Create New Teacher");
        System.out.println("| 3) Remove Teacher");
        System.out.println("| 4) Show Teachers By Faculty");
        System.out.println("| 5) Exit");
        System.out.println("--------------------------");
        System.out.print(" Select Option -> ");
        return input.next();
    }

    public static String getOptionCourseMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("| = Dashboard Courses =");
        System.out.println("| 1) Show All Courses");
        System.out.println("| 2) Create New Course");
        System.out.println("| 3) Remove Course");
        System.out.println("| 4) Select Course To Admin");
        System.out.println("| 5) Show Courses By Faculty");
        System.out.println("| 6) Exit");
        System.out.println("--------------------------");
        System.out.print(" Select Option -> ");
        return input.next();
    }

    public static String getOptionAdminCourseMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("| = Course Admin =");
        System.out.println("| 1) Show Course Information");
        System.out.println("| 2) Add Student");
        System.out.println("| 3) Remove Student");
        System.out.println("| 4) Change Teacher");
        System.out.println("| 5) Exit");
        System.out.println("--------------------------");
        System.out.print(" Select Option -> ");
        return input.next();
    }

}
