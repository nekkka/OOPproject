package uiclasses ;

import java.io.IOException;
import java.util.stream.Collectors;
import unisystem2023.Database;
import enums.UserRole;
import users.Admin;
import users.User;
import users.UserFactory;

public class AdminView extends UserView{

	protected AdminView(){}

	public AdminView(Admin admin){
		super(admin);
	}

	public void createUser() throws IOException{
		UserRole type;
		String password;
		String login = "Default";
		print("Choose kind of user you want to create:");
		for(UserRole ut: UserRole.values()){
			print(ut.toString());
		}
		while(true){
			try {
				type = UserRole.valueOf(reader.readLine());
				break;
			}
			catch (IllegalArgumentException iae){
				print("No such option ");
			}
		}
		while(true){
			print("Insert login:");
			login = reader.readLine();
			final String costyl = login;
			if(Database.getInstance().getUsers().stream()
				   .filter(u -> costyl.equals(u.getLogin()))
				   .collect(Collectors.toList()).isEmpty()){
				break;
			}
			print("Username already used, try again");
		}
		print("Insert password:");
		password = reader.readLine();
		UserFactory.getUser(login, password, type);
	}

	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. Change password");
				print("3. Create user");
				print("4. View users");
				print("5. Delete user");
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
						createUser();
						break;
					case "4":
						viewUsers();
						break;
					case "5":
						deleteUser();
						break;
					default:
						print("No such option");
				}
			}
			catch (IOException ioe){
				System.out.println("Error");
			}
		}
	}

	public void viewUsers() throws IOException{
		for(User user: Database.getInstance().getUsers()){
			print(user.toString());
		}
	}

	public void deleteUser() throws IOException{
		viewUsers();
		while(true){
			print("Insert login of user you want to delete or 0 to exit");
			final String login = reader.readLine();
			if(login.equals("0")){
				return;
			}
			try{
				User user = Database.getInstance().getUsers().stream()
							.filter(s -> s.getLogin().equals(login))
							.collect(Collectors.toList()).get(0);
				Database.getInstance().deleteUser(user);
				return;
			}
			catch (Exception e){
				print("No such option");
			}
		}	
	}

}