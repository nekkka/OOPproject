package unisystem2023;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class DataManager {
    protected Map<String, Vector<String>> courseLessonsMap;

    public DataManager() {
        courseLessonsMap = new HashMap<>();
    }

    public void addLessonToCourse(String courseName, String lesson) {
								        // If the course already exists in the map, add the lesson to its vector
								        // Otherwise, create a new vector for the course and add the lesson
        courseLessonsMap.computeIfAbsent(courseName, k -> new Vector<>()).add(lesson);
    }

                                                   // Method to get lessons for a specific course
    public Vector<String> getLessonsForCourse(String courseName) {
        return courseLessonsMap.getOrDefault(courseName, new Vector<>());
    }

    public void createCourse(String courseName) {
                                                   // Check if the course already exists
        if (!courseLessonsMap.containsKey(courseName)) {
            
            courseLessonsMap.put(courseName, new Vector<>()); 
            System.out.println("Course '" + courseName + "' created successfully.");
        } else {
            System.out.println("Course '" + courseName + "' already exists.");
        }
    }
    
    public Set<String> getAllCourses() {
        return courseLessonsMap.keySet();
    }

	@Override
	public String toString() {
		return "DataManager [courseLessonsMap=" + courseLessonsMap + "]"; 
	}

  
}
