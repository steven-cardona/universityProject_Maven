package Data;

import Models.Course;
import Models.Faculties.Faculty;
import Models.Student;
import Models.University;
import Models.typeOfTeachers.TeacherFullTime;
import Models.typeOfTeachers.TeacherPartTime;

public class InitializeData {

    public static void load(University university) {
        TeacherFullTime camila = new TeacherFullTime("Carcelo Sepulveda", 23, "1026407", 2850000, Faculty.ADMINISTRATION, 5);
        TeacherFullTime marcelo = new TeacherFullTime("Marcelo Arrambide", 28, "1026404", 4200000, Faculty.ARCHITECTURE,4);
        TeacherPartTime martin = new TeacherPartTime("Martin Cuartas", 37, "14784571", 2250000,Faculty.ENGINEER,20);
        TeacherPartTime pablo = new TeacherPartTime("Juan pablo", 46, "10210102", 1800000, Faculty.SCIENCE, 30);

        university.addNewTeacher(camila);
        university.addNewTeacher(marcelo);
        university.addNewTeacher(martin);
        university.addNewTeacher(pablo);

        Student std1 = new Student("Camilo Beltran", 19, "748596123");
        Student std2 = new Student("Marcela Miranda", 21, "123654789");
        Student std3 = new Student("Juan Pablo Beltran", 18, "753214896");
        Student std4 = new Student("Maicol Cardona", 22, "213465879");
        Student std5 = new Student("Victor Tirado", 25, "963852147");
        Student std6 = new Student("Alejandro Quintero", 24, "582739146");

        university.addNewStudent(std1);
        university.addNewStudent(std2);
        university.addNewStudent(std3);
        university.addNewStudent(std4);
        university.addNewStudent(std5);
        university.addNewStudent(std6);

        // Initialize minimum 4 different classes including its teacher, students and other relevant data
        Course accounting = new Course("Administration", Faculty.ADMINISTRATION);
        accounting.assignTeacher(camila);
        accounting.addStudent(std1);
        accounting.addStudent(std2);
        accounting.addStudent(std3);

        Course programming = new Course("Programming", Faculty.ENGINEER);
        programming.assignTeacher(martin);
        programming.addStudent(std6);
        programming.addStudent(std5);
        programming.addStudent(std4);

        Course townPlanning = new Course("Town Planning", Faculty.ARCHITECTURE);
        townPlanning.assignTeacher(marcelo);
        townPlanning.addStudent(std1);
        townPlanning.addStudent(std6);
        townPlanning.addStudent(std2);
        townPlanning.addStudent(std5);

        Course chemistry = new Course("Chemistry", Faculty.SCIENCE);
        chemistry.assignTeacher(pablo);
        chemistry.addStudent(std3);
        chemistry.addStudent(std2);
        chemistry.addStudent(std4);
        chemistry.addStudent(std5);
        chemistry.addStudent(std6);
        chemistry.addStudent(std1);

        university.addNewCourse(accounting);
        university.addNewCourse(programming);
        university.addNewCourse(townPlanning);
        university.addNewCourse(chemistry);
    }

}
