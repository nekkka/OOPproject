package users;

import java.io.Serializable;

import courses.Courses;
import enums.Faculty;
import enums.OrganizationName;
import main.Database;
import unisystem2023.Mark;
import users.Student;

public class StudentTest implements Serializable{
	public static void main(String[] args) {
	    Database database = Database.getInstance();
	    Student student = (Student) database.getUser("a_nuriyeva@kbtu.kz", "parol");
	    if (student != null) {
	        student.setFaculty(Faculty.SITE);
	        student.setYearOfStudy(2);
	        student.setGPA(3.6);
	        student.setMember(OrganizationName.BCL);
	        try {
	            Database.saveDB();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Student not found!");
	    }
	}}

