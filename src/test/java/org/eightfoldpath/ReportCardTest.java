package org.eightfoldpath;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.Assert;

public class ReportCardTest {

    @Test
    public void testConstructor() {
        ReportCard reportCard = new ReportCard("Test Student", new ArrayList());
        Assert.assertNotNull(reportCard);
    }

    @Test
    public void testStudentName() {
        ReportCard reportCard = new ReportCard("Test Student", new ArrayList());
        Assert.assertNotNull(reportCard);
        Assert.assertEquals(reportCard.getStudentName(), "Test Student");
    }

    @Test
    public void testToString() {
        ReportCard reportCard = new ReportCard("Test Student", new ArrayList());
        Assert.assertNotNull(reportCard);
        Assert.assertTrue(reportCard.toString().indexOf("Test Student") > 0);
        reportCard.addGradeForClass("Math", 81);
        Assert.assertTrue(reportCard.toString().indexOf("Grade for Math - 81") > 0);
    }

    @Test
    public void testGradesShouldBeEmpty() {
        ReportCard reportCard = new ReportCard("Test Student", new ArrayList());
        ArrayList grades = reportCard.getGrades();
        Assert.assertTrue(grades.isEmpty());
    }

    @Test
    public void testAddGradeForClass() {
        ReportCard reportCard = new ReportCard("Test Student", new ArrayList());
        reportCard.addGradeForClass("English", 74);
        Assert.assertTrue(((Integer) reportCard.getGradeForClass("English")).intValue() == 74);
    }

    @Test
    public void testRemoveGradeForClass() {
        ReportCard reportCard = new ReportCard("Test Student", new ArrayList());
        reportCard.addGradeForClass("English", 74);
        Assert.assertTrue(((Integer) reportCard.getGradeForClass("English")).intValue() == 74);
        Assert.assertTrue(reportCard.removeGradeForClass("English"));
        Assert.assertNull(reportCard.getGradeForClass("English"));
    }

    @Test
    public void testLetterGrade() {
        ReportCard reportCard = new ReportCard("Test Student", new ArrayList());
        reportCard.addGradeForClass("Science", 85);
        Assert.assertEquals(ReportCard.GRADE_B, reportCard.getLetterGradeForClass("Science"));
    }


}
