package courses;

import java.util.Vector;

import enums.DayWeek;
import unisystem2023.DataManager;


class Lesson extends DataManager{
    private String lessonName;
    private Courses courseName;
    //private Map<DayWeek, Time> schedule;
    private Vector<DayWeek> schedule;
    private int auditorium; // мб экспепшн на номер кабов сделаем
    
    public Lesson() {
        // Default constructor
    }

    public Lesson(String lessonName, Courses courseName) {
        this.lessonName = lessonName;
        this.courseName = courseName;
    }
    
    public Lesson(String lessonName, Courses courseName, Vector<DayWeek> schedule, int auditorium) {
        this.lessonName = lessonName;
        this.courseName = courseName;
        this.schedule = schedule;
        this.auditorium = auditorium;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Courses getCourseName() {
        return courseName;
    }

    public void setCourseName(Courses courseName) {
        this.courseName = courseName;
    }

    public Vector<DayWeek> getSchedule() {
        return schedule;
    }

    public void setSchedule(Vector<DayWeek> schedule) {
        this.schedule = schedule;
    }

    public int getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(int auditorium) {
        this.auditorium = auditorium;
    }

    
}
