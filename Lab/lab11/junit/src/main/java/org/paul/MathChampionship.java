package org.paul;

import java.util.List;

public class MathChampionship {
    private List<StudentScore> studentScores;
    private int maxAchievableScore;

    public Prize getPrize(String studentName) {
        StudentScore targetStudent = null;

        for (StudentScore student : studentScores) {
            if (student.getStudentName().equals(studentName)) {
                targetStudent = student;
                break;
            }
        }

        if (targetStudent == null) {
            throw new StudentNotFoundException(studentName);
        }

        // find the prize
        if (targetStudent.getScore() > 95) {
            return Prize.GOLD;
        } else if (targetStudent.getScore() > 90) {
            return Prize.SILVER;
        } else if (targetStudent.getScore() > 85) {
            return Prize.BRONZE;
        } else if (targetStudent.getScore() > 80) {
            return Prize.MENTION;
        } else {
            return null;
        }
    }

    public void setMaxAchievableScore(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max achievable score must be greater than zero");
        }
        this.maxAchievableScore = i;
    }

    public void setStudentScores(List<StudentScore> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Student scores list cannot be null or empty");
        }
        this.studentScores = list;
    }
}
