package Models;

import Models.Faculties.Faculty;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private String name;
    private Set<Student> listStudents;
    private Teacher teacher;
    private String courseCode;
    private static int auxID;
    private Faculty faculty;

    public Course(String name, Faculty faculty) {
        this.name = name;
        listStudents = new HashSet<>();
        auxID++;
        this.courseCode = "Cou" + auxID;
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Set<Student> getListStudents() {
        return listStudents;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public boolean addStudent(Student student) {
        if (existStudent(student) || student == null){
            return false;
        }
        return listStudents.add(student);
    }

    public boolean removeStudent(String idStudent) {
        return listStudents.removeIf(student -> student.getId().equals(idStudent));
    }

    public boolean assignTeacher(Teacher teacher) {
        if (validateTeacher(teacher)){
            this.teacher = teacher;
            return true;
        }
        return false;
    }

    public Student findStudent(String id){
        for (Student student: listStudents) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean existStudent(Student newStudent) {
        for (Student student: listStudents) {
            if (student.equals(newStudent)){
                return true;
            }
        }
        return false;
    }

    private boolean validateTeacher(Teacher teacher) {
        if (teacher != null){
            return this.faculty.equals(teacher.getFaculty());
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course other = (Course) obj;
            return this.name.equals(other.getName()) || this.teacher.equals(other.teacher);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Course{" +
                " Name:" + name + " | " +
                " CourseCode: " + courseCode + " | " +
                " Faculty: " + faculty + " | " + "\n" +
                " Teacher: " + teacher + " | " + "\n" +
                " list of Students: " + listStudents +
                '}';
    }
}
