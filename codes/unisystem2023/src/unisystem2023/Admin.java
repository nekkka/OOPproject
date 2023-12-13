package unisystem2023;
import java.util.Vector;

public class Admin extends User{
 private Vector<String> allNames;
 private Vector<String> allID;
 private Vector<String> allSurnames;
 private Vector<User> userList; //я не знаю как это сделать ;-;
   //cкажем, что пока так?
     public Admin(String name) {
      super(name);
         userList = new Vector<>();
     }
     public User addNewUser(String name) {
         User newUser = new User(name);
         userList.add(newUser);
         return newUser;
     }
     public void deleteUser(User user) {
         userList.remove(user);
     }
     
     
     }