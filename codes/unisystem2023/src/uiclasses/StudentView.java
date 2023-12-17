package uiclasses;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import courses.Courses;
import courses.Lesson;
import unisystem2023.Database;
import unisystem2023.Transcript;
import users.Researcher;
import users.Student;

public class StudentView extends UserView {

    public StudentView() {
        super();
    }

    public StudentView(Student student) {
        super(student);
    }

    public void viewAttendance() throws IOException {
        // Implementation of viewAttendance method using updated Student class methods
        // ...
    }

    public void researcherMenu() {
        Researcher r = Database.getInstance().getResearcher((Student) user);
        if (r == null) {
            r = new Researcher((Student) user);
        }
        new ResearcherView(r).main();
    }

    public void register() throws IOException {
        Set<Courses> studentCourses = ((Student) user).getCourses();
        while (true) {
            Set<Courses> registration = Database.getInstance()
                    .getCourses().stream()
                    .filter(c -> !studentCourses.contains(c))
                    .collect(Collectors.toSet());
            for (Courses c : registration) {
                System.out.println(c.toString());
            }
            System.out.println("Insert name of course you want to register or 0 to exit");
            final String courseString = reader.readLine();
            if (courseString.equals("0")) {
                return;
            }
            try {
                Courses course = registration.stream()
                        .filter(c -> c.getName().equals(courseString))
                        .collect(Collectors.toList()).get(0);
                if (((Student) user).register(course)) {
                    System.out.println("Registered successfully");
                } else {
                    System.out.println("Cannot register");
                }
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("No such course");
            }
        }
    }

    public void viewMarks() throws IOException {
        for (Courses c : ((Student) user).getCourses()) {
            System.out.println(c.toString() + ((Student) user).getCurrentMarks().get(c).toString());
        }
    }

    public void viewTranscript() throws IOException {
        Transcript t = ((Student) user).getTranscript();
        System.out.println(t.toString());
    }

    public void dropCourse() throws IOException {
        while (true) {
            System.out.println("Here is the list of your courses: ");
            Set<Courses> courses = ((Student) user).getCourses();
            for (Courses cur : courses) {
                System.out.println(cur.toString());
            }
            System.out.println("Insert name of course you want to drop or 0 to exit");
            final String ans = reader.readLine();
            if (ans.equals("0")) {
                return;
            }
            try {
                Courses course = courses.stream()
                        .filter(c -> c.getName().equals(ans))
                        .collect(Collectors.toList()).get(0);
                ((Student) user).dropCourse(course);
                System.out.println("Course dropped successfully");
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("No such option");
            }
        }
    }

    public void main() {
        while (true) {
            try {
                System.out.println("0. Exit");
                System.out.println("1. View news");
                System.out.println("2. View personal info");
                System.out.println("3. Change password");
                System.out.println("4. View attendance");
                System.out.println("5. Register to a course");
                System.out.println("6. Drop course");
                System.out.println("7. View marks");
                System.out.println("8. View transcript");
                System.out.println("9. Researcher menu");
                String ans = reader.readLine();
                switch (ans) {
                    case "0":
                        return;
                    case "1":
                        viewNews();
                        break;
                    case "2":
                        viewPersonalInfo();
                        break;
                    case "3":
                        changePassword();
                        break;
                    case "4":
                        viewAttendance();
                        break;
                    case "5":
                        register();
                        break;
                    case "6":
                        dropCourse();
                        break;
                    case "7":
                        viewMarks();
                        break;
                    case "8":
                        viewTranscript();
                        break;
                    case "9":
                        researcherMenu();
                        break;
                    default:
                        System.out.println("No such option");
                }
            } catch (IOException ioe) {
                System.out.println("Something is wrong");
            }
        }
    }
}
