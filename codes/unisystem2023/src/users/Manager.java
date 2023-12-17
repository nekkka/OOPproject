package users;

import java.util.ArrayList;

import courses.Courses;
import enums.ManagerType;
import unisystem2023.News;

public class Manager extends Employee{
    
    //implements InfoTeacher, InfoStudents

    private ArrayList <Teacher> teachers;
    private ArrayList <Student> students;
    private ArrayList <Courses> courses;
    private ArrayList <News> news;
    private ManagerType type;
    
    public Manager(){
		super();
	}

	public Manager(String login, String password){
		super(login, password);
	}
	
    private ArrayList <Teacher> getTeachers() {
        return this.teachers;
    }
    
    private ArrayList <Teacher> setTeachers(ArrayList <Teacher> teachers) {
        this.teachers = teachers;
    }
    

    private ArrayList <Student> getStudents() {
        return this.students;
    }
    

    private ArrayList <Student> setStudents(ArrayList <Student> students) {
        this.students = students;
    }
    
    
    private ArrayList <Courses> getCourses() {
        return this.courses;
    }


    private ArrayList <Courses> setCourses(ArrayList <Courses> courses) {
        this.courses = courses;
    }
    

    private ArrayList <News> getNews() {
        return this.news;
    }
    

    private ArrayList <News> setNews(ArrayList <News> news) {
        this.news = news;
    }
    

    private ManagerType getType() {
        return this.type;
    }
    

    private ManagerType setType(ManagerType type) {
        this.type = type;
    }
    

    public ArrayList <Teacher> viewTeacher() {
        //TODO
        return null;
    }
    

    public void deleteCourses() {
        //TODO
        return null;
    }

    public void addCourses() {
        //TODO
        return null;
    }
    

    public void addCourses() {
        //TODO
        return null;
    }


    public ArrayList <Courses> viewCourses() {
        //TODO
        return null;
    }
    
    public void addNews() {
        //TODO
        return null;
    }

    public void deleteNews() {
        //TODO
        return null;
    }
    

    public void upgradeNews() {
        //TODO
        return null;
    }
    

    public ArrayList <Courses> viewTeachersCourse() {
        //TODO
        return null;
    }
    

    public ArrayList <Student> viewStudent() {
        //TODO
        return null;
    }
    

    public void openRegistration() {
        //TODO
        return null;
    }
    
    public void closeRegistration() {
        //TODO
        return null;
    }
    
    public void extendRegistration() {
        //TODO
        return null;
    }
    
    public void approveRegistration() {
        //TODO
        return null;
    }
    

    public String toString() {
        //TODO
        return "";
    }
    
    
}
