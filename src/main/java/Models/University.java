package Models;

import Models.Faculties.Faculty;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class University {
    private Set<Course> listCourses;
    private Set<Teacher> listTeachers;
    private Set<Student> listStudents;
    private String name;

    public University(String name) {
        this.name = name;
        listTeachers = new HashSet<>();
        listCourses = new HashSet<>();
        listStudents = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Course> getAllCourses() {
        return listCourses;
    }

    public Set<Teacher> getAllTeachers() {
        return listTeachers;
    }

    public Set<Student> getAllStudents() {
        return listStudents;
    }

    public Set<Course> getCoursesByFaculty(Faculty faculty) {
        return listCourses.stream().filter(course -> course.getFaculty().equals(faculty)).collect(Collectors.toSet());
    }

    public Set<Teacher> getTeachersByFaculty(Faculty faculty) {
        return listTeachers.stream().filter(teacher -> teacher.getFaculty().equals(faculty)).collect(Collectors.toSet());
    }

    public boolean addNewStudent(Student newStudent) {
        if (existStudent(newStudent)) {
            return false;
        }
        return listStudents.add(newStudent);
    }

    private boolean existStudent(Student newStudent) {
        for (Student student: listStudents) {
            if (student.equals(newStudent)){
                return true;
            }
        }
        return false;
    }

    public boolean addNewTeacher(Teacher newTeacher) {
        if (existTeacher(newTeacher)) {
            return false;
        }
        return listTeachers.add(newTeacher);
    }

    private boolean existTeacher(Teacher newTeacher) {
        for (Teacher teacher: listTeachers) {
            if (teacher.equals(newTeacher)){
                return true;
            }
        }
        return false;
    }

    public boolean addNewCourse(Course newCourse){
        if (existCourse(newCourse)) {
            return false;
        }
        return listCourses.add(newCourse);
    }

    private boolean existCourse(Course newCourse) {
        for (Course course: listCourses) {
            if (course.equals(newCourse)){
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(String idStudent) {
        return listStudents.removeIf(student -> student.getId().equals(idStudent));
    }

    public boolean removeTeacher(String idTeacher) {
        return listTeachers.removeIf(teacher -> teacher.getId().equals(idTeacher));
    }

    public boolean removeCourse(String idCourse) {
        return listCourses.removeIf(course -> course.getCourseCode().equals(idCourse));
    }

    public Set<Course> findCoursesByStudent(String idStudent) {
        Set<Course> courses = new HashSet<>();

        for (Course course: listCourses) {
            Student student = course.findStudent(idStudent);
            if (student != null) {
                courses.add(course);
            }
        }
        return courses;
    }

    public Course findCourse(String idCourse) {
        for (Course course: listCourses) {
            if (course.getCourseCode().equals(idCourse)) {
                return course;
            }
        }
        return null;
    }

    public Teacher findTeacher(String idTeacher) {
        for (Teacher teacher: listTeachers) {
            if (teacher.getId().equals(idTeacher)) {
                return teacher;
            }
        }
        return null;
    }

    public Student findStudent(String idStudent) {
        for (Student student: listStudents) {
            if (student.getId().equals(idStudent)) {
                return student;
            }
        }
        return null;
    }

    public String getInformation() {
        return "University: " + this.name + "\n" +
                "Students: " + getAllStudents().size() + "\n" +
                "Teachers: " + getAllTeachers().size() + "\n" +
                "Courses: " + getAllCourses().size();
    }
}
