package unisystem2023;

import java.util.List;

public abstract class User implements Comparable <User> {
    /**
     * id Long chtobi hranil bolshiye chisla i potom v baze dannih mozno naznachit BIGSERIAL i AUTO-INCREMENT, obichno tak dlya primary key
     */
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    //private String role;

    
    public User() {
    }
    
    public User (Long id, String login, String password, String name, String surname, String phoneNumber, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
       // this.role = role;
    }
       
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //здесь с паролями надо подумать, паидеи они же хэшируются

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }*/

    public boolean logIn(String login, String password, List<User> userList) {
        for (User user : userList) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void logOut() {
    	//костыли, надо будет спросить легально ли это
        this.id = null;
        this.login = null;
        this.password = null;
        this.name = null;
        this.surname = null;
        this.phoneNumber = null;
        this.email = null;
        //this.role = null;
    }
    public String toString() {
		return name + "'s data: Login: " + login + ", id: " + id + ")";
	}
    
    public int compareTo(User u) {
		if(id > u.id) {return 1;}
		if(id < u.id) {return -1;}
		return 0;
	}

}
