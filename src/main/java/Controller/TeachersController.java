package Controller;

import Models.Faculties.Faculty;
import Models.Teacher;
import Models.University;
import Views.GetOptionMenu;
import Views.RequestData;
import Views.ShowData;

public class TeachersController {

    public static void coordinator(University university){
        boolean iWantExit = false;

        while (!iWantExit) {
            String option = GetOptionMenu.getOptionTeacherMenu();

            switch (option) {
                case "1":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Printing All Teachers...");
                    ShowData.showTeachers(university.getAllTeachers());
                    ShowData.showMessage("=================================");
                    break;

                case "2":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Creating New Teacher...");
                    Teacher teacher = RequestData.getDataForTeacher();
                    boolean status = university.addNewTeacher(teacher);
                    ShowData.showStatusCreate(status, "Teacher");
                    ShowData.showMessage("=================================");
                    break;

                case "3":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Remove Teacher Of The University");
                    ShowData.showMessage("------------------------");

                    ShowData.showMessage("Printing The List Of Teachers...");
                    ShowData.showAllTeachersMinified(university.getAllTeachers());
                    String idStudent = RequestData.getIdOfPerson("Teacher");
                    boolean statusDeleted = university.removeTeacher(idStudent);
                    ShowData.showStatusDeleted(statusDeleted, "Teacher");
                    ShowData.showMessage("=================================");
                    break;

                case "4":
                    ShowData.showMessage("=================================");
                    ShowData.showMessage("Show Teachers By Faculty");
                    Faculty faculty = RequestData.getFaculty();
                    ShowData.showTeachers(university.getTeachersByFaculty(faculty));
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

    public static Teacher findTeacher(University myUniversity) {
        String id = RequestData.getIdOfPerson("Teacher");
        return myUniversity.findTeacher(id);
    }
}
