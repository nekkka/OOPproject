package uiclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.stream.Collectors;

import courses.Courses;
import enums.Faculty;
import main.Database;
import unisystem2023.Message;
import unisystem2023.News;
import users.Employee;
import users.Manager;
import users.Researcher;
import users.Teacher;
import users.User;

public class ManagerUI extends EmployeeUI{
  private Manager manager;

  public ManagerUI(){}

  public ManagerUI(Manager manager){
    super(manager);
    this.manager = manager;
  }

  public void viewMessages() throws IOException{
    Vector <Message> messages = ((Manager)user).getMessages();
    while(true){
      print("0. Exit");
      int count = 1;
      for(Message cur: messages){
        print(count + "." + cur);
        count++;
      }
      String ans = reader.readLine();
      if(ans.equals("0")){
        return;
      }
      try{
        viewMessage(messages.get(Integer.parseInt(ans) - 1));
      }
      catch (IndexOutOfBoundsException iofe){
        print("Wrong answer");
      }
      catch (NumberFormatException nfe){
        print("Not a number");
      }
    }
  }


  public void sendMessage() throws IOException{
    System.out.println("Write User's login to send message: ");
    User receiver;
    String name = reader.readLine();
    while(true){
      try{
        receiver = Database.getInstance().getAllUsers().stream()
       // .filter(u-> u instanceof User) ?????? нада обдумать нормски
        .filter(e -> e.getLogin().equals(name))
        .collect(Collectors.toList()).get(0);
        break;
      }
      catch (IndexOutOfBoundsException ioofe){
        print("No such user");
      }
    }
    print("Insert message theme: ");
    String theme = reader.readLine();
    print("Insert message text: ");
    String text = reader.readLine();
    ((Manager)user).sendMessage((Manager)receiver, theme, text);
  }
  
  public void addCourse() throws IOException {
	    while (true) {
	        print("Insert course idCode or 0 to exit: ");
	        String idCode = reader.readLine();
	        if (idCode.equals("0")) {
	            return;
	        }

	        print("Insert number of credits for the course:");
	        int credits = Integer.parseInt(reader.readLine());

	        print("Insert course name:");
	        String name = reader.readLine();

	        print("Insert faculty:\nSITE\nBS\nISE\nSAM");
	        String facultyInput = reader.readLine();
	        Faculty faculty = Faculty.valueOf(facultyInput);

	        try {
	            Courses course = new Courses(name, idCode, credits, faculty);
	            Database.getInstance().addCourse(course);
	            print("Course created successfully");
	        } catch (Exception e) {
	            print("Something went wrong while creating the course.");
	            e.printStackTrace();
	        }
	    }
	}
  
  
  public void deleteCourse() throws IOException {
	    while (true) {
	        print("Select a course to delete or enter 0 to exit:");
	        Vector<Courses> courses = Database.getInstance().getCourses();
	        for (int i = 0; i < courses.size(); i++) {
	            print((i + 1) + ". " + courses.get(i));
	        }
	        int choice = Integer.parseInt(reader.readLine());

	        if (choice == 0) {
	            return;
	        } else if (choice > 0 && choice <= courses.size()) {
	            Courses courseToDelete = courses.get(choice - 1);
	            Database.getInstance().deleteCourse(courseToDelete);
	            print("Course deleted successfully");
	        } else {
	            print("Invalid choice. Please select a valid option.");
	        }
	    }
	}



  public void researchersMenu() {
      Vector<Researcher> researchers = Database.getInstance().getResearchers();
      if (researchers.isEmpty()) {
          Manager manager = (Manager) user; // Assuming 'user' is an Employee type
          researchers.add(new Researcher(manager)); // Create a new Researcher instance using the employee
          Database.getInstance().setResearchers(researchers); // Set the updated list of researchers in the database
      }
      new ResearcherUI().main(); // Instantiate the ResearcherView and call its main method
  }
  
  public void viewCourses() throws IOException {
	    Vector<Courses> courses = Database.getInstance().getCourses();
	    if (courses.isEmpty()) {
	        System.out.println("No courses");
	        return;
	    }

	    System.out.println("Courses:\n");
        for (int i = 0; i < courses.size(); i++) {
            print((i + 1) + ". " + courses.get(i));
        }
	}
  
  
  public void addNews() throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    System.out.println("Enter news title:");
	    String newsTitle = reader.readLine();
	    
	    System.out.println("Enter news content:");
	    String content = reader.readLine();
	    
	    News newsItem = new News(newsTitle, content);
	    Database.getInstance().addNews(newsItem);
	    
	    System.out.println("News added successfully");
	}
  
  
  
  
  
  
  public void assignTeacherToCourse() throws IOException {
	    Vector<Courses> courses = Database.getInstance().getCourses();
	    if (courses.isEmpty()) {
	        System.out.println("No courses available to assign teachers");
	        return;
	    }

	    System.out.println("Available Courses:");
	    for (int i = 0; i < courses.size(); i++) {
	        System.out.println((i + 1) + ". " + courses.get(i));
	    }

	    System.out.println("Enter the number of the course to assign teachers:");
	    int courseNumber = Integer.parseInt(reader.readLine());

	    if (courseNumber > 0 && courseNumber <= courses.size()) {
	        Courses selectedCourse = courses.get(courseNumber - 1);
	        Teacher lector = null;
	        Teacher practiceTeacher = null;

	    
	        System.out.println("Select lector for the course:");
	        System.out.println("Select practice teacher for the course:");
	        if (lector != null && practiceTeacher != null) {
	            selectedCourse.setLector(lector);
	            selectedCourse.setPracticeTeacher(practiceTeacher);
	            System.out.println("Teachers assigned to the course successfully.");
	        } else {
	            System.out.println("Unable to assign teachers. Please make sure teachers are selected.");
	        }
	    } else {
	        System.out.println("Invalid course number. Please enter a valid course number.");
	    }
	}



  public void main() {
	    while (true) {
	        try {
	            print("0. Exit");
	            print("1. View news");
	            print("2. Change password");
	            print("3. View messages");
	            print("4. Send message");
	            print("5. Researchers menu");
	            print("6. Delete course");
	            print("7. Add course");
	            print("8. View courses");
	            print("9. View teacher's courses");
	            print("10. Add news");
	            print("11. Assign Teachers to course");
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
	                    viewMessages();
	                    break;
	                case "4":
	                    sendMessage();
	                    break;
	                case "5":
	                    researchersMenu();
	                    break;
	                case "6":
	                    deleteCourse();
	                    break;
	                case "7":
	                    addCourse();
	                    break;
	                case "8":
	                    viewCourses(); 
	                    break;
	                case "9":
	                    manager.viewTeachersCourse(); 
	                    break;	                    
	                case "10":
	                    addNews(); 
	                    break;
	                case "11":
	                	assignTeacherToCourse();
	                    break;    
	                    
	                default:
	                    print("No such option");
	                    break;
	            }
	        } catch (IOException ioe) {
	            System.out.println("Error");
	        }
	    }
	}

}
