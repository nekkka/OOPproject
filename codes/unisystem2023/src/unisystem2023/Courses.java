package unisystem2023;

import java.util.ArrayList;
import java.util.Vector;

public class Courses extends DataManager {
	private String courseName;
	private String id;
	private int credits;
	private CoursesType courseType;
	private Semester semester;
	private Teacher lector = new Teacher();
	private Teacher practice = new Teacher();
	private Faculty faculty;

	
	
	public Courses() {
		
	}
	
	public Courses(String coursesName,String id,int credits) {
		this.courseName = coursesName;
		this.id = id;
		this.credits = credits;
		
	}
	
    public Courses(String courseName, String id, int credits, CoursesType courseType,
            Semester semester, Teacher lector, Teacher practice, Faculty faculty) {
		 this.courseName = courseName;
		 this.id = id;
		 this.credits = credits;
		 this.courseType = courseType;
		 this.semester = semester;
		 this.lector = lector;
		 this.practice = practice;
		 this.faculty = faculty;
}

	public String getCoursesName() {
		return courseName;
	}

	public void setCoursesName(String coursesName) {
		this.courseName = coursesName;
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
	
	public CoursesType getCourseType() {
		return courseType;
	}

	public void setCourseType(CoursesType courseType) {
		this.courseType = courseType;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	    public Teacher getLector() {
	        return lector;
	    }

	    public void setLector(Teacher t){
			lector = t;
		}

	    public Teacher getPracticeTeacher() {
	        return practice;
	    }

		public void setPracticeTeacher(Teacher t){
			practice = t;
		}

	    public Faculty getFaculty() {
	        return faculty;
	    }

	    public void setFaculty(Faculty faculty) {
	        this.faculty = faculty;
	    }
	    
	
	
	//Ниже нада разобраца
	public Vector<String> getLessonsForCourse(String coursesName) {
		return  courseLessonsMap.getOrDefault(coursesName, new Vector<>());
		}
	    

	
	public String toString() {
		return "Course's name: " + courseName + ", credits: " + credits
				+ ", ID code: " + id + ' '; // + lector + ' ' + practice
	}
	
	

}
