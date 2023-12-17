package unisystem2023;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Semester;

public class Transcript implements Serializable {
    private ArrayList<Marks> allGPA;
    private Semester semester;
    private ArrayList<String> allLetterGrades;
    private Double attestationOne;
    private Double attestationTwo;
    private Double finalExamMark;

    public Transcript() {
        this.allGPA = new ArrayList<>();
        this.allLetterGrades = new ArrayList<>();
        this.attestationOne = null;
        this.attestationTwo = null;
        this.finalExamMark = null;
    }
    
    public ArrayList<String> getAllLetterGrades() {
        return allLetterGrades;
    }

    public void setAllLetterGrades(ArrayList<String> allLetterGrades) {
        this.allLetterGrades = allLetterGrades;
    }

    public ArrayList<Double> getGPA() {
        return allGPA;
    }

    public void showTranscript() {
        if (semester != null) {
            System.out.println("Semester: " + semester);
            System.out.println("Attestation One: " + attestationOne);
            System.out.println("Attestation Two: " + attestationTwo);
            System.out.println("Final Exam Mark: " + finalExamMark);
            System.out.println("GPA: " + calculateGPA());
            System.out.println("Letter Grade: " + calculateLetterGrade());
        } else {
            System.out.println("Transcript not available for this semester.");
        }
    }

    public Double getAttestationOne() {
        return attestationOne;
    }

    public void setAttestationOne(Double attestationOne) {
        this.attestationOne = attestationOne;
    }

    public Double getAttestationTwo() {
        return attestationTwo;
    }

    public void setAttestationTwo(Double attestationTwo) {
        this.attestationTwo = attestationTwo;
    }

    public Double getFinalExamMark() {
        return finalExamMark;
    }

    public void setFinalExamMark(Double finalExamMark) {
        this.finalExamMark = finalExamMark;
    }


    // Метод для вычисления общего GPA
    private double calculateGPA() {
        if (attestationOne != null && attestationTwo != null && finalExamMark != null) {
            return (attestationOne + attestationTwo + finalExamMark) / 3.0;
        } else {
            return 0.0;
        }
    }


    // Метод для вычисления буквенной оценки GPA
    private String calculateLetterGrade() {
        double gpa = calculateGPA();
        if (gpa >= 4.5) {
            return "A";
        } else if (gpa >= 3.5) {
            return "B";
        } else if (gpa >= 2.5) {
            return "C";
        } else if (gpa >= 1.5) {
            return "D";
        } else {
            return "F";
        }
    }
}
