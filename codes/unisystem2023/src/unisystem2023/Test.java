package oopFinalProject;

public class Test {
	 public static void main(String[] args) {
	        // Creating instances of Courses and Lesson classes
		 	DataManager dm = new DataManager();
	        Courses mathCourse = new Courses("Math", "M101", 3);
	        Courses physicsCourse = new Courses("Physics", "P201", 4);

	        Lesson mathLesson1 = new Lesson("lesson1", "Math");
	        Lesson mathLesson2 = new Lesson("lesson2", "Math");
	        Lesson physicsLesson1 = new Lesson("lesson1", "Physics");

	        mathCourse.addLessonToCourse("Math", "lesson1");
	        mathCourse.addLessonToCourse("Math", "lesson2");
	        physicsCourse.addLessonToCourse("Physics", "lesson1");

	        mathCourse.createCourse("Chemistry");

	        System.out.println("Lessons for Math course: " + mathCourse.getLessonsForCourse("Math"));
	        System.out.println("Lessons for Physics course: " + physicsCourse.getLessonsForCourse("Physics"));
	        System.out.println("Lessons for Chemistry course: " + mathCourse.getLessonsForCourse("Chemistry"));
	        


	        System.out.println(mathCourse);
	        
	    }
	 

}
