package uiclasses;

import java.util.Scanner;

import unisystem2023.Database;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;
import users.User;
import uiclasses.*;
public class Test {
    
    public static UserView view;
    public static Scanner scanner = new Scanner(System.in);

    public static void setView(User user){
        if(user instanceof Admin){
            view = new AdminView(((Admin)user));
        }
        if(user instanceof Teacher){
            view = new TeacherView(((Teacher)user));
        }
        if(user instanceof Student){
            view = new StudentView(((Student)user));
        }
        if(user instanceof Manager){
            view = new ManagerView((Manager)user);
        }
 
    }

    public static void login(){
        User user;
        while(true){
            System.out.println("Insert your login");
            String login = scanner.next();
            System.out.println("Insert your password: ");
            String password = scanner.next();
            try{
                user = Database.getInstance().getUser(login, password); //юда нужно добавить езе имя, фам, номер тел, но это же по сути ступид
                if(user == null){
                	System.out.println("Wrong username of password");
                	continue;
                }
                System.out.println("Login was successfull");
                setView(user);
                return;
            }
            catch (Exception e){
                System.out.println("Wrong username or password");
            }
        }
    }

    public static void main(String args[]){
        System.out.println(Database.getInstance().getUser());
        login();
        view.main();
        Database.saveDatabase();
    }
}
