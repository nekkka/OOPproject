package unisystem2023;

import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        DataManager dm = new DataManager();


        Teacher teacher1 = new Teacher(1L, "tlogin1", "tpassword1", "John", "Doe", "1234567890", "john@example.com", 5000.0,
                Faculty.SITE, AcademicDegree.MASTER, new HashMap<>());

        Teacher teacher2 = new Teacher(2L, "tlogin2", "tpassword2", "Jane", "Smith", "9876543210", "jane@example.com", 6000.0,
                Faculty.BS, AcademicDegree.MASTER, new HashMap<>());


        Student student1 = new Student(1L, "slogin1", "spassword1", "Alice", "Johnson", "1112223334", "alice@example.com",
                Faculty.SITE, 2, 4.0, OrganizationName.BCL, new ArrayList<>());

        Student student2 = new Student(2L, "slogin2", "spassword2", "Bob", "Williams", "5556667778", "bob@example.com",
                Faculty.BS, 3, 3.5, OrganizationName.Faces, new ArrayList<>());


        Courses mathCourse = new Courses("Math", "M101", 3);
        Courses physicsCourse = new Courses("Physics", "P201", 4);


        mathCourse.addLessonToCourse("Math", "lesson1");s
        mathCourse.addLessonToCourse("Math", "lesson2");
        physicsCourse.addLessonToCourse("Physics", "lesson1");

        mathCourse.createCourse("Chemistry");

        // Установка преподавателя для курса
        mathCourse.setLector(teacher1);
        physicsCourse.setLector(teacher2);


        // Вывод информации о курсах
        
        System.out.println("Lessons for Math course: " + mathCourse.getLessonsForCourse("Math"));
        System.out.println("Lessons for Physics course: " + physicsCourse.getLessonsForCourse("Physics"));
        System.out.println("Lessons for Chemistry course: " + mathCourse.getLessonsForCourse("Chemistry"));
        System.out.println(mathCourse);
        System.out.println(physicsCourse);
        System.out.println(student2);

    }
}
