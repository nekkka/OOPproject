package uiclasses;

import java.io.IOException;
import java.util.Vector;
import java.util.stream.Collectors;

import courses.Courses;
import main.Database;
import unisystem2023.Message;
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

  public void viewMessage(Message message) throws IOException{
    print(message.getMessage());
  }

  public void sendMessage() throws IOException{
    System.out.println("Insert Manager's login to send message to: ");
    User receiver;
    String name = reader.readLine();
    while(true){
      try{
        receiver = Database.getInstance().getAllUsers().stream()
        .filter(u-> u instanceof Manager)
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

  public void researchersMenu() {
      Vector<Researcher> researchers = Database.getInstance().getResearchers();
      if (researchers.isEmpty()) {
          Manager manager = (Manager) user; // Assuming 'user' is an Employee type
          researchers.add(new Researcher(manager)); // Create a new Researcher instance using the employee
          Database.getInstance().setResearchers(researchers); // Set the updated list of researchers in the database
      }
      new ResearcherUI().main(); // Instantiate the ResearcherView and call its main method
  }


  public void main(){
    while(true){
      try{
        print("0. Exit");
        print("1. View news");
        print("2. Change password");
        print("3. View messages");
        print("4. Send message");
        print("5. Researchers menu");
        print("6. Delete course");
        print("7. Add course");
        print("8. View course");
        print("9. View teacher's couses");
        String ans = reader.readLine();
        switch(ans){
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
          case "6":
            manager.deleteCourse(Courses course,Teacher teacher);
          case "7":
            manager.addCourses();
          case "8":
            manager.viewCourses();
          case "9":
            manager.viewTeachersCourse();
          default:
            print("No such option");
        }
      }
      catch (IOException ioe){
        System.out.println("Error");
      }
    }
  }
}
