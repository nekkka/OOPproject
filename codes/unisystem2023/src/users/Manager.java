package users;

import java.util.Vector;

import courses.Courses;
import enums.ManagerType;
import unisystem2023.News;
import unisystem2023.Request;

public class Manager extends Employee implements RecieveRequests{

	private static final long serialVersionUID = 1L;
	private static Vector <Teacher> teachers = new Vector <Teacher>();
    private static Vector <Student> students = new Vector <Student>();
    private static Vector <Courses> courses= new Vector <Courses>();
    private static Vector <News> news = new Vector <News>();
    private ManagerType type;
    private static Vector <Request> requests = new Vector <Request>();
    
    public Manager(){
		super();
	}

	public Manager(String login, String password){
		super(login, password);
	}
	
    private Vector <Teacher> getTeachers() {
        return this.teachers;
    }
    
    private void setTeachers(Vector <Teacher> teachers) {
        this.teachers = teachers;
    }
    

    private Vector <Student> getStudents() {
        return this.students;
    }
    

    private void setStudents(Vector <Student> students) {
        this.students = students;
    }
    
    
    private Vector <Courses> getCourses() {
        return this.courses;
    }


    private void setCourses(Vector <Courses> courses) {
        this.courses = courses;
    }
    

    private Vector <News> getNews() {
        return this.news;
    }
    

    private void setNews(Vector <News> news) {
        this.news = news;
    }
    

    private ManagerType getType() {
        return this.type;
    }
    

    private void setType (ManagerType type) {
        this.type = type;
    }
    

    public Vector <Teacher> viewTeacher() {
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


    public Vector <Courses> viewCourses() {
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
    

    public Vector <Courses> viewTeachersCourse() {
        //TODO
        return null;
    }
    

    public Vector <Student> viewStudent() {
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

	@Override
	public void completeRequest(Request r) {
		r.execute();
		requests.remove(r);
		
	}

	@Override
	public void declineRequest(Request r) {
		requests.remove(r);
	}
	public void addRequest(Request r) {
		requests.add(r);
	}
	public static Vector <Request> getAllRequests(){
		return requests;
	}
    
    
}
