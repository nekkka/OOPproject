package unisystem2023;

import java.util.ArrayList;
import java.util.HashMap;

/**
* @generated
*/
public class Student {
	//implements InfoTeacher, CanBeResearcher
    private Faculty faculty;
    private int yearOfStudy;
    private double gpa;
    private OrganizationName member;
    private ArrayList <Courses> courses;

    
    public Faculty getFaculty() {
        return this.faculty;
    }


    public Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    
    public int getYearOfStudy() {
        return this.yearOfStudy;
    }


    public int setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    

    private double getGpa() {
        return this.gpa;
    }
    
    private double setGpa(Double gpa) {
        this.gpa = gpa;
    }
    

    private OrganizationName getMember() {
        return this.member;
    }

    private OrganizationName setMember(OrganizationName member) {
        this.member = member;
    }
    

    public ArrayList <Courses> getCourses() {
        return this.courses;
    }

    public ArrayList <Courses> setCourses(ArrayList <Courses> courses) {
        this.courses = courses;
    }
    


    //                          Operations                                  
    
    public void viewMarks() {
        //TODO
        return null;
    }
    
    public void rateTeacher() {
        //TODO
        return null;
    }
    

   /* public double getMarks() {
        //TODO
        return 0.0;
    }*/
    
    public int getYearOfStudy() {
        //TODO
        return 0;
    }
    
    
    public double getGPA() {
        //TODO
        return 0.0;
    }

    
   
    public void viewCourses() {
        //TODO
        return null;
    }
    
    public HashMap<Course, Mark> getCoursesAndMarks() {
        //TODO
        return null;
    }


    public void registerForCourses() {
        //TODO
        return null;
    }
    

    public Transcript getTranscript() {
        //TODO
        return null;
    }

    public Map <OrganizationName, String> viewOrganization() {
        //TODO
        return null;
    }
    
    
    public Map <OrganizationName, String> joinOrganization() {
        //TODO
        return null;
    }

    public Map <Teacher, Course> viewTeachers() {
        //TODO
        return null;
    }
    
    public boolean equals() {
        //TODO
        return false;
    }
    
    
}
