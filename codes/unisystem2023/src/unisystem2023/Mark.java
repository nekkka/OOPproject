package unisystem2023;

public class Mark {
    private String courseId;
    private Courses courseName;
    private Double numericDouble;

    public Mark(String courseId, Courses courseName, Double numericDouble) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numericDouble = numericDouble;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Courses getCourseName() {
        return courseName;
    }

    public void setCourseName(Courses courseName) {
        this.courseName = courseName;
    }

    public Double getMark() {
        return numericDouble;
    }

    public void setMark(Double numericDouble) {
        this.numericDouble = numericDouble;
    }

    public void showMarkList() {
        // в разработке
    }
}
