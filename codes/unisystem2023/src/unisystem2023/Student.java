package unisystem2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student extends User implements CanBeResearcher {
    private Faculty faculty;
    private int yearOfStudy;
    private double GPA;
    private OrganizationName member;
    private ArrayList<Courses> courses;
    private HashMap<Courses, Mark> coursesAndMarks;

    public Student() {
        super();
    }

    public Student(Long id, String login, String password, String name, String surname,
                   String phoneNumber, String email, Faculty faculty, int yearOfStudy,
                   double GPA, OrganizationName member, ArrayList<Courses> courses) {
        super(id, login, password, name, surname, phoneNumber, email); 
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.GPA = GPA;
        this.member = member;
        this.courses = courses;
    }

    // Геттеры и сеттеры 

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public double getGPA() {
        return this.GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public OrganizationName getMember() {
        return this.member;
    }

    public void setMember(OrganizationName member) {
        this.member = member;
    }

    public ArrayList<Courses> getCourses() {
        return this.courses;
    }

    public void setCourses(ArrayList<Courses> courses) {
        this.courses = courses;
    }
    
    public HashMap<Courses, Mark> getCoursesAndMarks() {
        return coursesAndMarks;
    }
    


    public void viewAllMarks() {
        Map<Courses, Mark> coursesAndMarks = getCoursesAndMarks();

        if (coursesAndMarks.isEmpty()) {
            for (Map.Entry<Courses, Mark> entry : coursesAndMarks.entrySet()) {
                Courses course = entry.getKey();
                Mark mark = entry.getValue();
                System.out.println("Course: " + course.getCoursesName() + ", Mark: " + mark.getMark());
            }
        } else {
            System.out.println("No marks available");
        }
    }


    public void rateTeacher() {
        // приходите позже, я еще не андерстенд как реализовать
    }


    public void viewCourses() {
        for (Courses course : courses) {
            System.out.println(course);
        }
    }


    public void registerForCourses() {
    	// приходите позже, я еще не андерстенд как реализовать
    }

    public Transcript getTranscript() {
        // TODO: Implement the logic to get a transcript
        return null;
    }

    public void viewTeachers() {
        if (courses != null && !courses.isEmpty()) {
            for (Courses cource : courses) {
            	//там с объектом тичера надо крч разобраться
                System.out.println("Course: " + cource.getCoursesName() + ", Teacher: " + "teacher.getName()");
            }
        } else {
            System.out.println("No lessons available.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Implement proper equals method comparing Student objects
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        // Add comparison logic based on the fields of Student class
        return this.faculty.equals(student.faculty)
                && this.yearOfStudy == student.yearOfStudy
                && Double.compare(this.GPA, student.GPA) == 0
                && this.member.equals(student.member)
                && this.courses.equals(student.courses);
    }

    public void makeResearch() {
        System.out.println("Тут ченить будет потом, обещаю");
    }
}
