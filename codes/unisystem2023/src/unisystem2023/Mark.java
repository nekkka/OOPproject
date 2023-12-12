package unisystem2023;

public class Mark {
    public Integer courseId;
    public Courses courseName;
    public Double numericDouble;

    public Double getMark(){
        return numericDouble;
    }
    
    public void setMark(Double numericDouble){
    	this.numericDouble = numericDouble;
    }

    public void showMarkList(){

    }
}