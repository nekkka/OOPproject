package unisystem2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Teacher extends Employee {
    private Faculty faculty;
    private AcademicDegree academicDegree;
    private Map<Courses, Vector<Student>> coursesAndStudents;

    public Teacher() {
        super();
        coursesAndStudents = new HashMap<>();
    }

    public Teacher(Long id, String login, String password, String name, String surname, String phoneNumber, String email, double salary,
                   Faculty faculty, AcademicDegree academicDegree, Map<Courses, Vector<Student>> coursesMap) {
        super(id, login, password, name, surname, phoneNumber, email, salary);
        this.faculty = faculty;
        this.academicDegree = academicDegree;
        this.coursesAndStudents = coursesMap;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Map<Courses, Vector<Student>> getCoursesAndStudents() {
        return coursesAndStudents;
    }

    public void setCoursesAndStudents(Map<Courses, Vector<Student>> coursesAndStudents) {
        this.coursesAndStudents = coursesAndStudents;
    }

    public void viewCourses() {
        for (Courses course : coursesAndStudents.keySet()) {
            System.out.println("Course Name: " + course.getCoursesName());
        }
    }

    public void manageCourse(Courses course) {
        //в разработке
    }

    public void viewStudentInfo(Courses course) {
        if (coursesAndStudents.containsKey(course)) {
            Vector<Student> students = coursesAndStudents.get(course);
            for (Student student : students) {
                System.out.println("Student Name: " + student.getName() + ", Student ID: " + student.getId());
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    public void putMarks(Courses course, Student student, double mark) {
        // чекаем, существует ли курс такой у учителя
        if (coursesAndStudents.containsKey(course)) {
            Vector<Student> students = coursesAndStudents.get(course);
            
            // чекаем, записан ли студент на курс вообще
            if (students.contains(student)) {
                // Проверяем, существует ли карта оценок студента
                if (!student.getCoursesAndMarks().containsKey(course)) {
                    student.getCoursesAndMarks().put(course, new Mark());
                }
                
                // Устанавливаем оценку для студента на этом курсе
                Mark studentMark = student.getCoursesAndMarks().get(course);
                studentMark.setMark(mark);
                System.out.println("Mark " + mark + " added for student " + student.getName() + " on course " + course.getCoursesName());
            } else {
                System.out.println("Student not enrolled in the course.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }



    public void sendComplaint(Student student, String complaint) {
        // в разработке
    }
}
