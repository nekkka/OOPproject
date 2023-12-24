package main;

import uiclasses.AdminUI;
import uiclasses.UserUI;
import users.Admin;
import users.User;

public class UIFactory {
	
	public static UserUI getUi(User user) {
		if(user.getClass().equals(Admin.class)) {
			return new AdminUI((Admin) user);
		}
		return null;
	}
}
