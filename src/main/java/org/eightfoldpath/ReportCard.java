package org.eightfoldpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;

public class ReportCard {

    private String studentName;
    private ArrayList grades;
    private Date dateReported;
    
    public static final String CLASS_NAME = "CLASS_NAME"; 
    public static final String GRADE = "GRADE";

    public static final String GRADE_A = "A";
    public static final String GRADE_B = "B";
    public static final String GRADE_C = "C";
    public static final String GRADE_D = "D";
    public static final String GRADE_F = "F";

    public ReportCard() {
    }

    public ReportCard(String studentName, ArrayList grades) {
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
        HashMap gradeForClass = new HashMap();
        gradeForClass.put(CLASS_NAME, className);
        gradeForClass.put(GRADE, new Integer(grade));
        grades.add(gradeForClass);
    }

    public boolean removeGradeForClass(String className) {
        boolean gradeRemoved = false;
        if (grades != null) {
            Iterator<HashMap> it = grades.iterator();
            while (it.hasNext()) {
                HashMap grade = it.next();
                if (grade.get(CLASS_NAME).equals(className)) {
                    grades.remove(grade);
                    gradeRemoved = true;
                    break;
                }
            }
        }
        return gradeRemoved;
    }

    public ArrayList getGrades() {
        return grades;
    }

    public Integer getGradeForClass(String className) {
        Integer gradeForClass = null;

        if (grades != null) {
            Iterator<HashMap> it = grades.iterator();
            while (it.hasNext()) {
                HashMap grade = it.next();
                if (grade.get(CLASS_NAME).equals(className)) {
                    gradeForClass = (Integer) grade.get(GRADE);
                    break;
                }
            }
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

    public String toString() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        StringBuffer sb = new StringBuffer();
        sb.append("Report Card for " + studentName + "\n");
        sb.append("Date Reported: " +  df.format(dateReported) + "\n");
        if (grades != null) {
            Iterator<HashMap> it = grades.iterator();
            while (it.hasNext()) {
                HashMap grade = it.next();
                sb.append("Grade for " + grade.get(CLASS_NAME).toString() + " - " + grade.get(GRADE).toString() + "\n");
            }
        }

        return sb.toString();
    }
}
