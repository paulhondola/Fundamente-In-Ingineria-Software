package org.paul;

public class StudentScore {
    private String studentName;
    private int score;

    // constructor
    public StudentScore(String studentName, int score) {
        this.studentName = studentName;
        this.score = score;
    }

    // getter and setter for studentName
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // getter and setter for score
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}