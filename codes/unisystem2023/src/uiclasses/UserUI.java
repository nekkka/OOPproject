package uiclasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Vector;

import main.Database;
import unisystem2023.News;
import users.User;

public abstract class UserUI{

	protected User user;
	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	protected BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public UserUI(){}

	public UserUI(User user){
		this.user = user;
	}

	public void print(String message) throws IOException{
		writer.write(message);
		writer.newLine();
		writer.flush();
	}

	public void viewNews() throws IOException {
        while (true) {
            Vector<News> news = Database.getInstance().getNews();
            Collections.reverse(news);

            print("0. Exit");
            int count = 1;

            for (News cur : news) {
                print(count + "." + cur);
                count++;
            }

            String ans = reader.readLine();
            if (ans.equals("0")) {
                return;
            }

        }
    }

	public void changePassword() throws IOException{
		while(true){
			print("Insert new password: ");
			String password1 = reader.readLine();
			print("Confirm password: ");
			String password2 = reader.readLine();
			if(password1 == password2){
				user.setPassword(password2);
				print("Password changed successfully");
				break;
			}
			print("Passwords don't match");
		}
	}


	public abstract void main();

}

