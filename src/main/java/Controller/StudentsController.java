package Controller;

import Models.Course;
import Models.Student;
import Models.University;
import Views.GetOptionMenu;
import Views.RequestData;
import Views.ShowData;

import java.util.Set;

public class StudentsController {

    public static void coordinator(University university){
        boolean iWantExit = false;

        while (!iWantExit) {

            String option = GetOptionMenu.getOptionStudentsMenu();

            switch (option) {
                case "1":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Printing All Students...");
                    ShowData.showStudents(university.getAllStudents());
                    ShowData.showMessage("=================================");
                    break;

                case "2":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Creating New Student...");
                    ShowData.showMessage("------------------------");
                    Student student = StudentsController.addStudentIntoUniversity(university);

                    if (!student.getName().equals("")) {
                        ShowData.showMessage("Add the new student in one of the ours courses...");
                        boolean statusAddStudent = StudentsController.addStudentIntoCourse(university, student);
                        ShowData.showStatusAddToCourse(statusAddStudent);
                    }
                    ShowData.showMessage("=================================");
                    break;

                case "3":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Remove Student Of The University");
                    ShowData.showMessage("------------------------");

                    ShowData.showMessage("Printing The List Of Students...");
                    ShowData.showAllStudentsMinified(university.getAllStudents());
                    String idStudentToRemoved = RequestData.getIdOfPerson("Student");
                    boolean statusDeleted = university.removeStudent(idStudentToRemoved);
                    ShowData.showStatusDeleted(statusDeleted, "Student");

                    Set<Course> courses = university.findCoursesByStudent(idStudentToRemoved);
                    for (Course course: courses) {
                        course.removeStudent(idStudentToRemoved);
                    }
                    ShowData.showMessage("=================================");
                    break;

                case "4":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Show Student Courses");
                    ShowData.showMessage("------------------------");

                    ShowData.showMessage("Printing The List Of Students...");
                    ShowData.showAllStudentsMinified(university.getAllStudents());
                    String idStudent = RequestData.getIdOfPerson("Student");

                    ShowData.showMessage("=================================");
                    ShowData.showMessage("The courses are: ");
                    ShowData.showAllCoursesMinified(university.findCoursesByStudent(idStudent));
                    ShowData.showMessage("=================================");
                    break;

                case "5":
                    iWantExit = true;
                    ShowData.showMessage("leaving the dashboard...");
                    break;

                default:
                    ShowData.showMessage("=================================");
                    ShowData.showMessage(" Select a menu option, try again ");
                    ShowData.showMessage("=================================");
            }
        }
    }

    public static Student addStudentIntoUniversity(University myUniversity) {
        Student student = RequestData.getDataForStudent();
        boolean statusCreateStudent = myUniversity.addNewStudent(student);
        ShowData.showStatusCreate(statusCreateStudent, "Student");
        return student;
    }

    public static boolean addStudentIntoCourse(University myUniversity, Course course) {
        ShowData.showAllStudentsMinified(myUniversity.getAllStudents());
        Student resultStudent = StudentsController.findStudent(myUniversity);
        return  course.addStudent(resultStudent);
    }

    public static boolean addStudentIntoCourse(University myUniversity, Student student) {
        ShowData.showAllCoursesMinified(myUniversity.getAllCourses());
        String idCourse = RequestData.getCourseSelected();
        Course courseSelected = myUniversity.findCourse(idCourse);
        return courseSelected.addStudent(student);
    }

    public static Student findStudent(University myUniversity) {
        String id = RequestData.getIdOfPerson("Student");
        return myUniversity.findStudent(id);
    }
}
