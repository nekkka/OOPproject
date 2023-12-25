package main;

import java.util.Scanner;

import uiclasses.UserUI;
import users.Admin;
import users.Researcher;
import users.User;

public class Application {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String login = scanner.next();
		String password = scanner.next();
		User user = Database.getInstance().getUser(login, password);
		UserUI ui = UIFactory.getUi(user);
		ui.main();
		
		
		
	}

}
