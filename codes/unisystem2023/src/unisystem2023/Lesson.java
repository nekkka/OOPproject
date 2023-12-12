package oopFinalProject;


class Lesson extends DataManager {
    private String lessonName;
    private String courseName;

    
    
    public Lesson() {
		// TODO Auto-generated constructor stub
	}
    
    public Lesson(String lessonName, String courseName) {
        this.lessonName = lessonName;
        this.courseName = courseName;
    }

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void addLessonToCourse(String courseName, String lessonName) {}
    

   
}

