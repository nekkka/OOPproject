package users;

import java.io.Serializable;

import unisystem2023.Database;

public class Admin extends User implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private static Admin instance;
    
    protected Admin() {}
    
    public static Admin getInstance(String login, String password) throws Exception {
		if(instance == null) {
			instance = new Admin(login, password);
		}
		return instance;
	}
    
    public Admin(String login, String password) {
        super(login, password);
    }

    public void addUser(User user) {
        Database.getInstance().addUser(user);
    }

    public void deleteUser(User user) {
        Database.getInstance().deleteUser(user);
    }

    public String toString() {
        return super.toString().replace("User", "Admin");
    }
}
