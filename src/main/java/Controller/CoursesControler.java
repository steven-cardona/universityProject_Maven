package Controller;

import Models.Course;
import Models.Faculties.Faculty;
import Models.Student;
import Models.Teacher;
import Models.University;
import Views.GetOptionMenu;
import Views.RequestData;
import Views.ShowData;

public class CoursesControler {

    public static void coordinator(University university){
        boolean iWantExit = false;

        while (!iWantExit) {
            String option = GetOptionMenu.getOptionCourseMenu();

            switch (option) {
                case "1":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Printing All Courses...");
                    ShowData.showCourses(university.getAllCourses());
                    ShowData.showMessage("=================================");
                    break;

                case "2":
                    ShowData.showMessage("Creating New Course...");
                    createNewCourse(university);
                    break;

                case "3":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Remove Course Of The University");
                    ShowData.showMessage("--------------------------");

                    ShowData.showMessage("Printing The List Of Courses...");
                    ShowData.showAllCoursesMinified(university.getAllCourses());
                    String idCourseToDeleted = RequestData.getCourseSelected();
                    boolean statusDeleted = university.removeCourse(idCourseToDeleted);
                    ShowData.showStatusDeleted(statusDeleted, "Course");
                    ShowData.showMessage("=================================");
                    break;

                case "4":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Select Course To Manage");
                    ShowData.showMessage("--------------------------");

                    ShowData.showMessage("Printing The List Of Courses...");
                    ShowData.showAllCoursesMinified(university.getAllCourses());

                    String idCourse = RequestData.getCourseSelected();
                    Course resultCourse = university.findCourse(idCourse);

                    if (resultCourse != null) {
                        CoursesControler.adminCourse(resultCourse, university);
                    } else {
                        ShowData.showMessage("The course not exist, write a valid course ID...");
                    }
                    ShowData.showMessage("=================================");
                    break;

                case "5":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Show Course By Faculty");
                    Faculty faculty = RequestData.getFaculty();
                    ShowData.showCourses(university.getCoursesByFaculty(faculty));
                    ShowData.showMessage("=================================");
                    break;

                case "6":
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

    private static void createNewCourse(University myUniversity) {
        Course course = RequestData.getDataForCourse();

        ShowData.showMessage("Teachers Available For The Course");
        ShowData.showAllTeachersMinified(myUniversity.getAllTeachers());

        Teacher teacherResult = TeachersController.findTeacher(myUniversity);

        boolean statusAssignTeacher = course.assignTeacher(teacherResult);
        ShowData.showStatusAssignTeacher(statusAssignTeacher);

        boolean iWantAddOtherStudent = true;

        while (iWantAddOtherStudent) {
            ShowData.showMessage("Students Available For The Course");
            boolean statusAdd = StudentsController.addStudentIntoCourse(myUniversity, course);
            ShowData.showStatusAddToCourse(statusAdd);

            if (!RequestData.getOptionForAddStudent().equalsIgnoreCase("y") ) {
                iWantAddOtherStudent = false;
            }
        }

        boolean statusCourse = myUniversity.addNewCourse(course);
        ShowData.showStatusCreate(statusCourse, "Course");
    }

    private static void adminCourse(Course course, University university) {
        boolean iWantExit = false;

        while (!iWantExit) {

            String optionMenu = GetOptionMenu.getOptionAdminCourseMenu();

            switch (optionMenu) {
                case "1" :
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Printing Information Of Course...");
                    System.out.println(course);
                    ShowData.showMessage("=================================");
                    break;

                case "2" :
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Add Student Into Course");
                    ShowData.showMessage("--------------------------");
                    ShowData.showMessage("Printing the list of students...");
                    ShowData.showAllStudentsMinified(university.getAllStudents());
                    Student student = StudentsController.findStudent(university);
                    boolean statusAddStudent = course.addStudent(student);
                    ShowData.showStatusAddToCourse(statusAddStudent);
                    ShowData.showMessage("=================================");
                    break;

                case "3" :
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Remove Student");
                    ShowData.showMessage("------------------------");

                    ShowData.showMessage("Printing The List Of Students...");
                    ShowData.showAllStudentsMinified(course.getListStudents());
                    String idStudentToRemoved = RequestData.getIdOfPerson("Student");
                    boolean statusDeleted = course.removeStudent(idStudentToRemoved);
                    ShowData.showStatusDeleted(statusDeleted, "Student");
                    ShowData.showMessage("=================================");
                    break;

                case "4" :
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Change Teacher");
                    ShowData.showMessage("--------------------------");
                    ShowData.showMessage("Printing the list of teachers...");
                    ShowData.showAllTeachersMinified(university.getAllTeachers());
                    Teacher teacherResult = TeachersController.findTeacher(university);
                    boolean statusAssign = course.assignTeacher(teacherResult);
                    ShowData.showStatusAssignTeacher(statusAssign);
                    ShowData.showMessage("=================================");
                    break;

                case "5" :
                    iWantExit = true;
                    ShowData.showMessage("leaving the admin courses...");
                    break;

                default:
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Select a menu option, try again...");
                    ShowData.showMessage("=================================");
            }
        }
    }
}
