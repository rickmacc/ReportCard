package org.eightfoldpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;

public class ReportCard {

    public static final String GRADE_A = "A";
    public static final String GRADE_B = "B";
    public static final String GRADE_C = "C";
    public static final String GRADE_D = "D";
    public static final String GRADE_F = "F";

    private String studentName;
    private HashMap grades;
    private Date dateReported;

    public ReportCard() {
    }

    public ReportCard(String studentName, HashMap grades) {
        this.studentName = studentName;
        this.grades = grades;
        this.dateReported = new Date();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateReported() {
        return dateReported;
    }

    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }

    public void addGradeForClass(String className, int grade) {
        grades.put(className, new Integer(grade));
    }

    public boolean removeGradeForClass(String className) {
        boolean gradeRemoved = false;
        if (grades != null && grades.containsKey(className)) {
            grades.remove(className);
            gradeRemoved = true;
        }
        return gradeRemoved;
    }

    public HashMap getGrades() {
        return grades;
    }

    public Integer getGradeForClass(String className) {
        Integer gradeForClass = null;

        if (grades != null) {
            gradeForClass = (Integer) grades.get(className);
        }

        return gradeForClass;
    }

    public String getLetterGradeForClass(String className) {
        String letterGrade = "";
        Integer grade = getGradeForClass(className);
        if (grade.intValue() >= 90) {
            letterGrade = GRADE_A;
        } else if (grade.intValue() >= 80) {
            letterGrade = GRADE_B;
        } else if (grade.intValue() >= 70) {
            letterGrade = GRADE_C;
        } else if (grade.intValue() >= 60) {
            letterGrade = GRADE_D;
        } else {
            letterGrade = GRADE_F;
        }
        return letterGrade;
    }

    @Override
    public String toString() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        StringBuffer sb = new StringBuffer();
        sb.append("Report Card for " + studentName + "\n");
        sb.append("Date Reported: " +  df.format(dateReported) + "\n");
        if (grades != null) {
            grades.forEach((key, value)->sb.append("Grade for " + key + " - " + value.toString() + "\n"));
        }

        return sb.toString();
    }
}
