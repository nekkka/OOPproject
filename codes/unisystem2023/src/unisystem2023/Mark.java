package unisystem2023;

public class Mark {
    private Integer courseId;
    private Courses courseName;
    private Double numericDouble;

    public Mark(Integer courseId, Courses courseName, Double numericDouble) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numericDouble = numericDouble;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
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
