package oopFinalProject;

import java.util.Set;
import java.util.Vector;

public class Courses extends DataManager {
	String coursesName;
	String id;
	int credits;
	String semesterOfCourses;
	String typeOfCourses;
	private CoursesType courseType;
	private Semester semester;
	
	public Courses() {
		
	}
	
	public Courses(String coursesName,String id,int credits) {
		this.coursesName = coursesName;
		this.id = id;
		this.credits = credits;
		
	}

	public String getCoursesName() {
		return coursesName;
	}

	public void setCoursesName(String coursesName) {
		this.coursesName = coursesName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public void createCourse(String coursesName) {}
	
	public Vector<String> getLessonsForCourse(String coursesName) {
		return  courseLessonsMap.getOrDefault(coursesName, new Vector<>());
		}
	
	
	public Set<String> getAllCourses(){
		return courseLessonsMap.keySet() ;
		}
	
	public String toString() {
		return "DataManager [courseLessonsMap=" + courseLessonsMap + "]";
	}
	
	

}
