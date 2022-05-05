package Views;

import Models.Course;
import Models.Student;
import Models.Teacher;

import java.util.Set;

public class ShowData {

    public static void showMessage (String message) {
        System.out.println(message);
    }

    public static void showTeachers(Set<Teacher> list) {
        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else {
            System.out.println("The list is empty...");
        }
    }

    public static void showCourses(Set<Course> list) {
        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else {
            System.out.println("The list is empty...");
        }
    }

    public static void showStudents(Set<Student> list) {
        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else {
            System.out.println("The list is empty...");
        }
    }

    public static void showAllCoursesMinified(Set<Course> list) {
        if (list.size() > 0) {
            for (Course course: list) {
                System.out.println("CourseCode: " + course.getCourseCode() + " | Name: " + course.getName() + " | Faculty: " + course.getFaculty().name());
            }
        } else {
            System.out.println("The list is empty...");
        }

    }

    public static void showAllTeachersMinified(Set<Teacher> list) {
        if (list.size() > 0) {
            for (Teacher teacher: list) {
                System.out.println("ID Teacher: " + teacher.getId() + " | Name: " + teacher.getName() + " | Faculty: " + teacher.getFaculty().name());
            }
        } else {
            System.out.println("The list is empty...");
        }
    }

    public static void showAllStudentsMinified(Set<Student> list) {
        if (list.size() > 0){
            for (Student student: list) {
                System.out.println("ID Student: " + student.getId() + " | Name: " + student.getName());
            }
        } else {
            System.out.println("The list is empty...");
        }
    }

    public static void showStatusAddToCourse(boolean status) {
        String msg = (status) ? "Student added to course successfully..." : "Student was not added... Try Again";
        System.out.println(msg);
    }

    public static void showStatusCreate(boolean status, String person) {
        String msg = (status) ? person +" created successfully..." : person +" was not created... Try Again";
        System.out.println(msg);
    }

    public static void showStatusDeleted(boolean status, String person) {
        String msg = (status) ? person +" Deleted successfully..." : person +" was not Deleted... Try Again";
        System.out.println(msg);
    }

    public static void showStatusAssignTeacher(boolean status) {
        String msg = (status) ? "Teacher Assign to course successfully..." : "Teacher was not assigned to course... Try Again";
        System.out.println(msg);
    }
}
