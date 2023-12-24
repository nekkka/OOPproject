package uiclasses;

import java.io.IOException;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import main.Database;
import courses.Courses;
import users.Researcher;
import users.Student;

public class StudentUI extends UserUI {

    public StudentUI() {
        super();
    }

    public StudentUI(Student student) {
        super(student);
    }

    public void viewAttendance() throws IOException {
        // если успеем...
    }

    public void researcherMenu() {
        Vector<Researcher> researchers = Database.getInstance().getResearchers();
        int index = researchers.indexOf(user);
        Researcher r;
        if (index == -1) {
            r = new Researcher((Student) user);
        } else {
        	r = researchers.get(index);
        }
        new ResearcherUI(r).main();
    }

    public void register() throws IOException {
        Set<Courses> studentCourses = ((Student) user).getCourses().keySet();
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
                        .filter(c -> c.getCoursesName().equals(courseString))
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
        for (Courses c : ((Student) user).getCourses().keySet()) {
            System.out.println(c.toString() + ((Student) user).getCurrentMarks().get(c).toString());
        }
    }

    public void dropCourse() throws IOException {
        while (true) {
            System.out.println("Here is the list of your courses: ");
            Set<Courses> courses = ((Student) user).getCourses().keySet();
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
                        .filter(c -> c.getCoursesName().equals(ans))
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
                System.out.println("2. Change password");
                System.out.println("3. View attendance");
                System.out.println("4. Register to a course");
                System.out.println("5. Drop course");
                System.out.println("6. View marks");
                System.out.println("8. Researcher menu");
                String ans = reader.readLine();
                switch (ans) {
                    case "0":
                        return;
                    case "1":
                        viewNews();
                        break;
                    case "2":
                        changePassword();
                        break;
                    case "3":
                        viewAttendance();
                        break;
                    case "4":
                        register();
                        break;
                    case "5":
                        dropCourse();
                        break;
                    case "6":
                        viewMarks();
                        break;
                    case "8":
                        researcherMenu();
                        break;
                    default:
                        System.out.println("Not found");
                }
            } catch (IOException ioe) {
                System.out.println("Something is wrong");
            }
        }
    }
}
