package Controller;

import Data.InitializeData;
import Models.University;
import Views.GetOptionMenu;
import Views.ShowData;

public class Main {
    public static void main(String[] args) {
        University myUniversity = new University("Universidad del Valle");
        InitializeData.load(myUniversity);

        boolean iWantExit = false;

        ShowData.showMessage("=== "+ myUniversity.getName() + " ===");
        ShowData.showMessage("== Welcome To The Administration System ==");

        while (!iWantExit) {
            try {
                String optionMenu = GetOptionMenu.getOptionMainMenu();

                switch (optionMenu) {
                    case "1" :
                        ShowData.showMessage("University Information");
                        ShowData.showMessage("--------------------------");
                        ShowData.showMessage(myUniversity.getInformation());
                        break;

                    case "2":
                        StudentsController.coordinator(myUniversity);
                        break;

                    case "3":
                        TeachersController.coordinator(myUniversity);
                        break;

                    case "4":
                        CoursesControler.coordinator(myUniversity);
                        break;

                    case "5":
                        ShowData.showMessage("=================================");
                        ShowData.showMessage("Information About System...");
                        showInformationSystem();
                        ShowData.showMessage("=================================");
                        break;

                    case "6":
                        iWantExit = true;
                        ShowData.showMessage("leaving the program...");
                        break;

                    default:
                        ShowData.showMessage("=================================");
                        ShowData.showMessage("Select a menu option, try again...");
                        ShowData.showMessage("=================================");
                }
            } catch (Exception e) {
                ShowData.showMessage("=================================");
                ShowData.showMessage("Invalid data or internal error, Please try again...");
                ShowData.showMessage("=================================");
            }
        }
    }

    private static void showInformationSystem() {
        ShowData.showMessage("This system manages a university,\n" +
                "allows you to add, delete and view students, teachers and courses. To be able to assign a professor to a course, they must be from the same faculty.");
    }
}
