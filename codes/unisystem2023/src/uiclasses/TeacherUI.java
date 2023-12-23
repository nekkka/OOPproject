package uiclasses;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import courses.Courses;
import unisystem2023.Database;
import users.Researcher;
import users.Student;
import users.Teacher;

public class TeacherUI extends EmployeeUI{

	public TeacherUI(){
		super();
	}

	public TeacherUI(Teacher teacher){
		super(teacher);
	}

	public List <Courses> viewCourses() throws IOException{
		List <Courses> courses = Database.getInstance().getTeacherCourses((Teacher)user);
		for(Courses cur: courses){
			print(cur.toString());
		}
		return courses;
	}

	public List <Student> viewStudents(Courses c) throws IOException{
		List <Student> students = Database.getInstance().getUsers().stream()
								  .filter(u -> u instanceof Student).map(s -> (Student)s)
								  .filter(s -> ((Student)s).getCourses().contains(c))
								  .collect(Collectors.toList());
		for(Student s: students){
			print(s.toString());
		}
		return students;
	}
	
	public void researcherMenu(){
		Researcher r = Database.getInstance().getResearcher((Student)user);
		if(r == null){
			r = new Researcher((Student)user);
		}
		new ResearcherUI(r).main();
	}

	public void putMark() throws IOException{
		Courses course;
		while(true){
			List <Courses> courses = viewCourses();
			print("Insert your course name or 0 to exit");
			final String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
			try{
				course = courses.stream()
						 .filter(c -> c.getName().equals(ans))
						 .collect(Collectors.toList()).get(0);
				break;
			}
			catch (IndexOutOfBoundsException ioobe){
				print("No such course");
			}
		}
		while(true){
			List <Student> students = viewStudents(course);
			print("Insert student's login to put mark to or 0 to exit");
			final String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
			Student student;
			try{
				student = students.stream()
						  .filter(s -> s.getLogin().equals(ans))
						  .collect(Collectors.toList()).get(0);
			}
			catch (IndexOutOfBoundsException ioobe){
				print("No such student");
				continue;
			}
			print("Insert points");
			double points = Double.parseDouble(reader.readLine());
			print("Insert 0 to put first attestation");
			print("Insert 1 to put second attestation");
			print("Insert 2 to put final");
			String choose = reader.readLine();
			switch(choose){
				case "0":
					student.getCurrentMarks().get(course).setFirstAtt(points);
					break;
				case "1":
					student.getCurrentMarks().get(course).setSecondAtt(points);
					break;
				case "2":
					student.getCurrentMarks().get(course).setFinalMark(points);
					student.checkCourses();
					break;
				default:
					print("No such option");
			}
		}
	}

	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. Change password");
				print("3. View messages");
				print("4. Send message");
				print("5. View courses");
                print("6. Put mark");
                print("7. Researcher menu");
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
						viewMessages();
						break;
					case "4":
						sendMessage();
						break;
					case "5":
						viewCourses();
						break;
                    case "6":
						putMark();
						break;
                    case "7":
						researcherMenu();
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

}

